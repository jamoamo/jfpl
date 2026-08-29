# Sentinel Audit — jfpl

**Scope:** Whole repository (89 source files under `src/main/java` and `src/test/java`, plus `pom.xml`, `README.md`). Java 11 / Maven library wrapping fantasy.premierleague.com. Checkstyle and SpotBugs configured; Dependabot manages plugin versions.

**Passes run:** 1 of 3 (pass 1 across 10 applicable dimensions produced high-confidence, cross-confirmed findings on the most critical issues — four independent agents converged on the same root-cause login/connection-leak bugs — so further passes were not needed to raise confidence on the headline issues).

**Dimensions triaged:** All 8 core dimensions applicable. `sentinel-dependency-health` (pom.xml present) and `sentinel-api-design` (public library) included. `sentinel-feature-gaps` included as a full repo audit. `sentinel-adapted-usecases` skipped — no hexagonal/ports-and-adapters architecture in this codebase.

---

## Bugs

**[Critical][Confirmed] `login()` always returns `true` — actual login result is discarded**
`src/main/java/com/github/jamoamo/jfpl/FPLClient.java:75-81`
`request.execute(URL_LOGIN, params, response -> loginResponseWasSucess(response))` returns a boolean reflecting whether login actually succeeded, but the call site discards it and `login()` unconditionally `return true;`. `FPL.login()` (`FPL.java:70-87`) relies on this to decide whether to throw `XFPLLoginException`, so bad credentials are silently reported as a successful login and callers proceed believing they are authenticated.
*Fix:* capture and return the actual boolean from `request.execute(...)`.

**[High][Confirmed] `isLoggedIn()` always returns `false` — `loggedIn` field is never assigned**
`src/main/java/com/github/jamoamo/jfpl/HttpConnection.java:64,97-100`
`loggedIn` is declared but never set to `true` anywhere in the class. Combined with the bug above, the library's entire login-status surface is non-functional: `login()` always claims success, `isLoggedIn()` always claims failure.
*Fix:* set `this.loggedIn = true` on a validated successful login response; reset on logout/failure.

**[High][Confirmed] `CloseableHttpResponse` never closed — connection pool leak on every GET and POST**
`src/main/java/com/github/jamoamo/jfpl/HttpConnection.java:84-95, 102-125`
Neither `execute()` nor `getRequest()` closes the `CloseableHttpResponse` (no try-with-resources, no `response.close()`); only the request object's `releaseConnection()` is called. Apache HttpClient's default pooling connection manager will exhaust its pool under sustained use, causing later requests to stall or throw `ConnectionPoolTimeoutException`. Independently confirmed by `sentinel-security`, `sentinel-performance`, `sentinel-best-practices`, and `sentinel-maintainability`.
*Fix:* wrap response handling in try-with-resources in both methods.

**[Medium][Confirmed] `IndexOutOfBoundsException` if a team has no flagged captain/vice-captain**
`src/main/java/com/github/jamoamo/jfpl/UserTeamMapper.java:59-83`
`mapCaptain()`/`mapViceCaptain()` guard against *more than one* match (`captainList.size() > 1`) but never check for zero before calling `.get(0)`. A malformed/edge-case API response throws an unchecked `IndexOutOfBoundsException` instead of the intended `XFPLMappingException`, leaking an implementation detail through `FPL.getCurrentUserTeam()`.
*Fix:* check `isEmpty()` and throw `XFPLMappingException` for both cases.

**[Low][Confirmed] Mojibake in MIT license header across ~58 files**
e.g. `FPL.java:8`, `FPLClient.java:8`, `UserMapper.java:8` — "So Аftware" contains a Cyrillic "А" (U+0410) homoglyph mid-word instead of Latin "Software". See Spelling section — same root cause, but flagged here too since a stray non-ASCII homoglyph in source is worth a security-hygiene note (a known technique for hiding/obfuscating content), even though in this case it's clearly benign corruption from a copy-paste/encoding mishap.
*Fix:* repo-wide replace of "So Аftware" → "Software".

---

## Security

**[Critical][Confirmed] Same root cause as Bugs — `login()` always reports success**
`src/main/java/com/github/jamoamo/jfpl/FPLClient.java:75-81`. See Bugs above. Security-relevant framing: an application built on this library cannot detect rejected credentials, locked accounts, or a changed login flow — it will treat every login attempt as authenticated.

**[High][Confirmed] Same root cause — `isLoggedIn()` permanently broken**
`src/main/java/com/github/jamoamo/jfpl/HttpConnection.java:64,97-100`. See Bugs above.

**[Medium][Suspected] Login-success detection depends on a redirect `Location` header that may never be observed**
`src/main/java/com/github/jamoamo/jfpl/FPLClient.java:84-98`, `HttpConnection.java:66-74`
`loginResponseWasSucess` inspects the `Location` header of the login response for `state=success`, but `HttpClientBuilder.create().build()` uses default redirect-following behavior, which may auto-follow the redirect before this code sees the header — making the check silently unreliable even once the discarded-boolean bug above is fixed.
*Fix:* disable auto-redirects for the login request (`RequestConfig.custom().setRedirectsEnabled(false)`) and verify against the live login endpoint.

**[Low][Confirmed] Unclosed HTTP responses — see Bugs (connection/resource exhaustion, DoS against the process itself under sustained use).**

**[Low][Confirmed] `jfpl.fpl_api_url` system property lets any code in the JVM redirect all non-login API calls**
`src/main/java/com/github/jamoamo/jfpl/FPLClient.java:57`
Any code able to set JVM system properties can redirect `getStaticData`/`getUser`/etc. to an attacker-controlled host whose responses are trusted and deserialized into model classes. Impact is limited (cookies aren't automatically sent cross-domain, login endpoint unaffected) but still a spoofing vector if system properties are attacker-influenceable elsewhere in the host application.
*Fix:* restrict this override to a test-only constructor rather than a globally-settable system property, or document the risk clearly.

No SQL/command injection, unsafe deserialization, disabled TLS verification, hardcoded secrets, or credential logging were found. Runtime dependency versions (httpclient 4.5.14, gson 2.10.1, log4j-api 2.23.1) have no known unpatched CVEs at review time.

---

## Best Practices

**[High][Confirmed] `getUser()` uses a narrower, inconsistent exception-translation pattern than every sibling method**
`src/main/java/com/github/jamoamo/jfpl/FPL.java:138-151`
Only catches `XServiceUnavailable` (which `HttpConnection` throws but no other `FPL` method handles) instead of the `XConnectionException`/`XResponseMappingException`/`XResourceNotFound` pattern used everywhere else. A connection failure or 404 during `getUser()` leaks internal, undocumented package-private exception types straight out of the public API. Cross-referenced in API Design below.

**[Medium][Confirmed] `XFPLServiceUnavailable` is dead code, and its name is easily confused with the actually-used `XServiceUnavailable`**
`src/main/java/com/github/jamoamo/jfpl/XFPLServiceUnavailable.java` — never constructed anywhere. Meanwhile `XServiceUnavailable` (package-private, different class) is what `HttpConnection` actually throws, and it's caught in exactly one place (`getUser()`).
*Fix:* remove `XFPLServiceUnavailable`, or wire `XServiceUnavailable` into the standard translation pattern and rename to avoid the near-duplicate.

**[Medium][Confirmed] Six-fold duplicated exception-translation block in `FPL.java`**
`FPL.java:247-267, 301-320, 334-351, 364-381, 392-414, 425-442`
Identical 3-catch block copy-pasted six times; a change to translation policy must be replicated correctly in all six (and `getUser()` already shows how easy it is to miss one).
*Fix:* extract a shared generic helper, e.g. `private <T> T translated(Supplier<T> call)`.

**[Medium][Confirmed] `XNotAuthorised`/`XNotAllowed` (401/403) are thrown by `HttpConnection` but never caught/translated anywhere in `FPL.java`**
`HttpConnection.java:139-142` vs. all six `FPL.java` catch blocks. A 401/403 (e.g. expired session) propagates as an undocumented internal exception type from every public method.
*Fix:* fold into the shared translation helper above.

**[Medium][Confirmed] `getCurrentUser()`/`getCurrentUserTeam()` declare `throws Exception`, breaking the codebase's unchecked-exception convention**
`FPL.java:118-119, 175-176` — every other public method uses specific `X*` types. Cross-referenced in API Design below.

**[Low][Confirmed] `getCurrentUserData()` declares `throws IOException` that can never be thrown**
`FPL.java:153-168` — vestigial, misleading signature; the only call inside throws unchecked `XClientException`.

**[Medium][Suspected] `FPL.java` — the primary public entry point, and owner of the (broken) exception-translation contract — has essentially no unit tests.** Cross-referenced in Test Quality below.

**[Low][Confirmed] Stray rhetorical comment left in shipped code**
`src/main/java/com/github/jamoamo/jfpl/TeamMapper.java:36` — `//why are tests skipped?`, appears stale since `TeamMapperTest.java` exists.
*Fix:* remove, or convert to an actionable note if it points at a real gap.

**[Low][Confirmed] `TeamMapper` lacks the descriptive class Javadoc its sibling mappers have** (e.g. compare `PlayerMapper.java:36-40`).

---

## Missing Features

**[High][Confirmed] League standings are modeled as empty stub classes and never implemented**
`src/main/java/com/github/jamoamo/jfpl/JsonUserLeagues.java:30-33`, `model/FPLUserLeagues.java:30-33`
Both classes are empty placeholders; `JsonUser.getLeagues()` returns this always-empty type. FPL's classic/H2H league standings are a core part of the real API and a primary reason consumers would want this library, yet nothing wires these classes up to `IFPLClient`/`FPLClient`/`FPL`.
*Fix:* add DTOs, client methods against `leagues-classic/{id}/standings/` and `leagues-h2h/{id}/standings/`, a mapper, and public `FPL` accessors; design for pagination from the start (FPL's real endpoint paginates, see Low finding below).

**[Medium][Confirmed] `getFixturesForGameweek` exists in `IFPLClient`/`FPLClient` but is never exposed on the public `FPL` facade**
`IFPLClient.java:48-49`, `FPLClient.java:147-154` vs. `FPL.java:244-268` (only whole-list `getFixtures()`).
*Fix:* add `public List<FPLFixture> getFixtures(int gameweekNr)` to `FPL.java` following the existing translation pattern.

**[Medium][Confirmed] Transfers are fully modeled (`JsonTeamTransfers`, `FPLPlayerTransfers`) but have no retrieval path** — no client method hits `entry/{id}/transfers/`.
*Fix:* add `getEntryTransfers(int entryId)` end-to-end (client → mapper → `FPL` accessor).

**[Low][Suspected] No pagination support designed in for the eventual league-standings implementation** — FPL's real endpoint paginates (`page_standings`, `page_new_entries`); worth designing for now rather than retrofitting.

**[Low][Suspected] No configurable timeout/retry policy surfaced to consumers** — see Performance section (no `RequestConfig` timeouts configured at all, not just non-configurable).

---

## Maintainability

**[Medium][Confirmed] `FPLDataCache` violates SRP/OCP — one field+getter+setter triplet hardcoded per cached type**
`src/main/java/com/github/jamoamo/jfpl/FPLDataCache.java:26-50`, with duplicated check-cache/fetch/store logic at each call site in `FPL.java:153-168` and `417-443`.
*Fix:* generalize to a typed `Map<Class<?>, Object>`-backed cache with a single compute-if-absent method.

**[Medium][Confirmed] `FPL` facade directly `new`s concrete Mapper classes and `FPLClient` on every call — DIP violation, testability cost**
`FPL.java:144, 199, 230, 250, 281, 337, 367, 395` (mappers), `:55` (client). `FPL.java` is the highest-churn file in the repo; every mapper change touches it, and unit tests can't substitute mapper behavior.
*Fix:* inject mappers via the existing package-private constructor pattern (already used for `client`), or make stateless mappers static.

**[Low][Confirmed] Dead defensive null-check on a `final` field**
`FPL.java:157` — `this.cachedData != null` can never be false since `cachedData` is `final` and initialized inline; signals uncertainty about the class's own invariants.

**[Low][Confirmed] Near-duplicate captain/vice-captain mapping logic** — `UserTeamMapper.java:59-83`; extract a shared `findUniquePick(...)` helper (also fixes the empty-list bug noted under Bugs).

**[Low][Confirmed] Chip-type switch statements use undocumented magic strings tied to an unversioned external API contract** — `UserTeamMapper.java:113-156` (`"wildcard"`, `"freehit"`, `"bboost"`, `"3xc"`). Add a comment noting these mirror the real FPL API's literal field values.

**[Low][Confirmed] Unexplained checkstyle suppression** — `FPL.java:43`, `@SuppressWarnings("checkstyle:classFanOutComplexity")` with no comment; masks the DIP/SRP issue above rather than being a judged, documented exception.

*(The six-fold FPL.java exception-duplication and inconsistent throws-declarations findings are the same root cause as Best Practices above — not repeated here.)*

---

## Performance

**[Medium][Confirmed] Team/player maps are fully rebuilt from scratch on every call, despite a caching layer already existing**
`FPL.java:445-459` (`getTeamMap`/`getPlayerMap`) re-map the *entire* ~700-player dataset (including nested stats objects) via `PlayerMapper.mapPlayer` every single invocation, even though the raw JSON is cached in `FPLDataCache`. Every call to `getUser()`, `getCurrentUserTeam()`, `getEntryGameweek()`, `getFixtures()`, or `getPlayers()` pays this cost again.
*Fix:* cache the mapped `List<FPLTeam>`/`List<FPLPlayer>` (or derived maps) in `FPLDataCache`, invalidated only when new static data is stored.

**[Medium][Confirmed] Unclosed `CloseableHttpResponse` — same root cause as Bugs, framed here as pool exhaustion under load.**

**[Low][Confirmed] New `Gson` instance built on every HTTP response** — `HttpConnection.java:157-159`. `Gson` is thread-safe/immutable once built.
*Fix:* hoist to a single `static final Gson GSON`.

**[Low][Suspected] No connection pool sizing or connect/socket timeouts configured** — `HttpConnection.java:66-74` uses `HttpClientBuilder.create()` defaults (2 connections per route, no timeout). Combined with the unclosed-response leak, a slow/unresponsive FPL endpoint can hang indefinitely.

---

## Test Quality

**[High][Confirmed] `HttpConnection.handleResponseStatus`'s five error-mapping branches (401/403/404/503/default) are completely untested**
`src/test/java/com/github/jamoamo/jfpl/HttpConnectionTest.java:38-49` only asserts the 200 happy path. This is precisely why the connection-leak and status-mapping issues went undetected.
*Fix:* one test per status-code branch asserting the correct exception type.

**[High][Confirmed] Authenticated/user-specific `FPL` flows have essentially zero test coverage**
`FPLTest.java` never exercises `login`, `getCurrentUser`, `getUser`, `getCurrentUserTeam`, `getUserHistory`/`getCurrentUserHistory`, or `getEntryGameweek`. The test double `TestClient` explicitly throws `UnsupportedOperationException` for most of these, and its `login()` unconditionally returns `true` — meaning even if the `login()` bug above were exercised, the test double would mask it. **This is the direct cause of the Critical login bug shipping undetected.**
*Fix:* implement these methods on `TestClient` (or a purpose-built fake), and add success/failure-path tests for all of them, especially `login()` (both outcomes) and the `getUser()` exception-translation gap.

**[Medium][Confirmed] `XFPLResourceNotFound`'s translation path is never exercised** — every `FPL.java` catch block maps it, but `TestClient.checkExceptions()` only supports IOException/API-exception flags, never a 404 case.

**[Medium][Suspected] `getFixturesForGameweek` is untested and has no test hook in `TestClient`** — worth confirming it's actually reachable/used before investing in coverage.

**[Low][Confirmed] `TestApp.java` is a manual network-hitting smoke test living in the test tree with no `@Test` annotations** — never run by JUnit, but could mislead readers into thinking `getUser`/`getCurrentUserHistory` are covered.
*Fix:* move to an `examples/`/`manual/` directory or exclude from Surefire, and rename away from the misleading "Test" prefix.

**[Low][Suspected] `TestClient`'s mutable public fields invite shared-state bugs if reused across tests in future** — not currently an issue, but the design doesn't prevent it.

---

## Observability

**[High][Confirmed] `FPL.java` discards the original exception (and its stack trace) at every exception-translation site**
`FPL.java:256-268, 309-320, 340-351, 370-381, 403-414, 431-442` — e.g. `catch(XConnectionException ex) { throw new XFPLUnavailableException(); }` never logs `ex` nor passes it as the cause. For a library, the log/cause-chain is the only debugging surface available to consumers, and this destroys it at nearly every call site.
*Fix:* chain the original exception as the cause, and add a log line (with the attempted URL/operation) at each catch site.

**[Medium][Confirmed] Inconsistent request logging between GET and POST paths** — `getRequest()` logs URL/status/IOException failures; `execute()` (used for login) logs none of it. Same operation type, instrumented inconsistently.

**[Medium][Confirmed] Login failures are silently swallowed with no diagnostic logging** — `FPLClient.java:84-98`, `FPL.java:70-87`; a bad-credentials failure and a "FPL changed its login flow" failure look identical with nothing in the logs to tell them apart.

**[Medium][Confirmed] API error responses (4xx/5xx) are thrown with no accompanying log entry** — `HttpConnection.java:127-148`; only an INFO-level status log exists beforehand, commonly filtered out in production. A 503 (documented in `XFPLServiceUnavailable`'s own Javadoc as a real, recurring condition) is effectively invisible.

**[Low][Confirmed] No cache hit/miss visibility** — `FPL.java:153-168, 417-443`; a DEBUG-level log on hit/miss would explain otherwise-mysterious latency to consumers.

**[Low][Confirmed] JSON parse failures in `processResponse` aren't logged**, unlike the sibling IOException handler two methods up — `HttpConnection.java:150-168`.

---

## Spelling

**[High][Confirmed] Corrupted MIT license header across ~58 files** — "So Аftware" (with a Cyrillic "А" homoglyph) instead of "Software". See Bugs section for the security-hygiene note.
*Fix:* `grep -rl "Аftware"` → replace with plain ASCII "Software" repo-wide.

**[High][Confirmed] Javadoc typo in the public API** — `FPL.java:240`, `@return a list of al fixtures.` → "all fixtures."

**[Medium][Confirmed] Public class name misspelled: `FPLAutomcaticSub` → should be `FPLAutomaticSub`**
`src/main/java/com/github/jamoamo/jfpl/model/FPLAutomcaticSub.java:30`, used consistently in `EntryGameweekMapper.java` and `FPLEntryGameweek.java`. It's part of the public API surface, so a rename is a breaking change.
*Fix:* rename with a deprecated alias for one release, or fold into the pre-1.0 API cleanup (see API Design below).

**[Medium][Confirmed] README grammar typos** — `README.md:11` "a users history" → "a user's history"; `README.md:12` "for an user" → "for a user".

---

## Dependency Health

**[Medium][Confirmed] `httpclient` 4.5.14 is Apache's legacy, maintenance-only HTTP client line**
`pom.xml:46-50` — Apache's actively developed successor is `httpclient5`. 4.5.14 is effectively the terminal 4.x release; future CVE response and enhancements land in httpclient5 instead.
*Fix:* plan a migration to `org.apache.httpcomponents.client5:httpclient5` (different API surface — scope as a deliberate migration, not a version bump).

**[Low][Confirmed] `log4j-api` without a binding is correct for a library, but worth documenting** — `pom.xml:63-67`; no `log4j-core`/binding is shipped (correct — lets consumers choose), but undocumented, so consumers may see silent no-op logging during their own debugging.
*Fix:* note in README that consumers must supply a log4j2 binding.

**[Low][Confirmed] `gson` 2.10.1 is one-plus minor behind current 2.11.x/2.12.x** — low risk, not abandoned; bump on next Dependabot cycle. Confirm `.github/dependabot.yml` actually covers the Maven ecosystem, not just plugins.

**[Low][Confirmed] License compatibility clean** — httpclient/gson/log4j-api are all Apache-2.0, compatible with the project's MIT license.

**[Low][Confirmed] Test dependencies correctly scoped** — `junit-jupiter`/`mockito-core` both carry `<scope>test</scope>`.

**Not audited:** transitive dependency tree (`mvn dependency:tree` not run this pass — worth checking httpclient 4.x's own transitive pulls, e.g. commons-codec/commons-logging, for a "lightweight" wrapper library).

---

## API Design

**[High][Confirmed] Inconsistent exception translation leaks internal, uncatchable exception types from public methods**
`FPL.java:138-151` (`getUser`), `:118-127` (`getCurrentUser`), `:175-187` (`getCurrentUserTeam`) — same root cause as the Best Practices finding above. Framed here as a contract-breaking issue: because the leaked types (`XConnectionException`, `XResourceNotFound`, `XResponseMappingException`) are package-private, external code cannot even name them in a `catch` clause — only `catch(RuntimeException)` works, defeating the purpose of the documented `X*` hierarchy.

**[Medium][Confirmed] `getCurrentUser()`/`getCurrentUserTeam()` declare `throws Exception`** — same root cause as Best Practices; framed here as: every other method uses the specific `X*` hierarchy, so this pair breaks the documented contract shape.

**[Medium][Confirmed] `XFPLResourceNotFound` is thrown by six methods but never declared or documented on any of them** — undiscoverable without reading source, unlike its sibling exceptions which several methods do declare.

**[Medium][Confirmed] `getFixtures`/`getCurrentUserHistory` omit `XFPLAPIResponseException` from their declared signature despite throwing it** — inconsistent with `getPlayers`/`getGameweeks`/`getTeams`/`getPlayerTypes`, which declare both.

**[Medium][Confirmed] The public exception hierarchy has no common root, and mixes checked/unchecked with no naming convention distinguishing them**
`XFPLLoginException`/`XFPLServiceUnavailable` are checked (`extends Exception`); `XFPLAPIResponseException`/`XFPLMappingException`/`XFPLResourceNotFound`/`XFPLUnavailableException` are unchecked — with identical `-Exception` naming giving no visual cue which is which. No consumer can write one `catch` clause for "any jfpl error." Combined with the `XFPLServiceUnavailable`/`XServiceUnavailable`/`XFPLUnavailableException` naming collision (see Best Practices), this is confusing before any code is even read.
*Fix:* since the library is pre-1.0 (0.6-SNAPSHOT), this is the right time to consolidate around a single public root (e.g. `XFPLException`) with a consistently-unchecked subtype set, before the contract locks at 1.0.

**[Low][Confirmed] Dead public exception type `XFPLServiceUnavailable`** — same as Best Practices finding; never thrown anywhere.

**[Low][Confirmed] Public exception constructors are all package-private** — prevents consumers from constructing them for tests/mocks. Worth a deliberate call, not necessarily a defect.

---

## Not Audited

- Full field-by-field comparison of all `Json*` DTOs against their `FPL*` model equivalents (deferred — flagged by `sentinel-maintainability` and `sentinel-best-practices` as worthwhile for a pass 2 if deeper duplication analysis is wanted).
- `mvn dependency:tree` transitive dependency analysis (no build/network execution performed).
- Remaining Mapper test files (`EntryGameweekMapperTest`, `FixtureMapperTest`, `GameweekMapperTest`, `TeamMapperTest`, `UserHistoryMapperTest`, `UserTeamMapperTest`) were structurally skimmed but not read line-by-line for edge-case gaps.

---

## Summary — Highest Priority

1. **Fix the login/session bugs** (`FPLClient.login()` discards its result; `HttpConnection.isLoggedIn()` never sets `loggedIn`) — this is the single most severe issue, confirmed independently by four specialist agents, and the test suite currently cannot catch it because `TestClient.login()` is hardcoded to return `true`.
2. **Close HTTP responses** in `HttpConnection.execute()`/`getRequest()` via try-with-resources — a real resource-exhaustion risk for any long-lived consumer.
3. **Add tests for the untested error paths** (`handleResponseStatus` branches, login success/failure, `getUser()`'s exception gap) — this is what let #1 ship silently.
4. Before locking a 1.0 API contract: consolidate the exception hierarchy, fix the six-fold duplicated/inconsistent exception translation in `FPL.java`, and decide the fate of dead types (`XFPLServiceUnavailable`).

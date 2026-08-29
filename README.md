![Maven Central](https://img.shields.io/maven-central/v/io.github.jamoamo/jfpl?style=for-the-badge)
# jFPL
A Java Wrapper for the unofficial fpl api (fantasy.premierleague.com/api)

Functionality currently supported:
* Retrieve the list of game-weeks
* Retrieve the current gameweek
* Retrieve the list of players
* Retrieve the list of teams
* Retrieve the list of fixtures
* Retrieve a user's history
* Retrieve gameweek information for a user and gameweek
* Retrieve FPL player types
* Retrieve total number of FPL players

## Logging

jFPL uses log4j-api for logging and ships without a log4j binding, so log calls will silently
no-op unless the consuming application supplies one (e.g. log4j-core, or log4j-to-slf4j).

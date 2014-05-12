# Sinuca

A pool (sinuca) game in Java with Swing: ball physics, collisions between balls and cushions, and pockets. Made in the third semester of Digital Games at Fatec (Feb-May 2014), first in Eclipse and later moved to NetBeans with an Ant build.

## Author

Fernando Luiz Neme Chibli ([@fershibli](https://github.com/fershibli))

## Releases

Builds are made by GitHub Actions (`.github/workflows/release.yml`) on macOS, Windows and Linux: each platform gets a zipped app image with its own Java runtime, plus a portable `Sinuca.jar` (`java -jar Sinuca.jar`). Push a tag such as `v1.0` (or run the workflow by hand) to publish a release.

NetBeans users can also use `ant jar`.

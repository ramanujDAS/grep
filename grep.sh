#!/bin/sh

set -e # Exit early if any commands fail

(
  cd "$(dirname "$0")"
  mvn -B package -Ddir=/tmp/grep-java
  echo "Compiled your program to /tmp/grep-java"
)

exec java -jar /tmp/grep-java/grep.jar "$@"

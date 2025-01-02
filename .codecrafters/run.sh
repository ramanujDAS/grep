#!/bin/sh


set -e # Exit on failure

exec java -jar /tmp/codecrafters-build-grep-java/codecrafters-grep.jar "$@"

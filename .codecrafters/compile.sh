#!/bin/sh

set -e # Exit on failure

mvn -B package -Ddir=/tmp/codecrafters-build-grep-java

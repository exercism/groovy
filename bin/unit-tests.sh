#!/usr/bin/env bash
trap 'exit 1' ERR

./gradlew --version

pushd exercises
echo ""
echo ">>> Running tests..."
TERM=dumb ../gradlew build --parallel --continue
popd
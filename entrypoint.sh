#!/bin/sh

# 1. Clean a previous build and build new
mvn clean install

# 2. Run a new build
java -jar target/authentication-1.0.0.jar

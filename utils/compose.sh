#!/usr/bin/env bash

if [ ! -n "$BASH" ]; then
  PROJECT_DIR=$(realpath "$(dirname $0)/../")
else
  PROJECT_DIR=$(realpath "$(dirname ${BASH_SOURCE})/../")
fi

DOCKER_DIR="${PROJECT_DIR}"
COMPOSE_FILES_OPTIONS=" -f docker-compose.yml -f docker-compose.local.yml"

compose() {
    cd ${DOCKER_DIR} && docker-compose ${COMPOSE_FILES_OPTIONS} $@; cd - > /dev/null
}

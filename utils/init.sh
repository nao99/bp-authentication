#!/usr/bin/env bash

if [ ! -n "$BASH" ]; then
  PROJECT_DIR=$(realpath "$(dirname $0)/../")
else
  PROJECT_DIR=$(realpath "$(dirname ${BASH_SOURCE})/../")
fi

createdConfigs=()

config_copy() {
    if [[ ! -f $2 ]]; then
        cp $1 $2;
        if [[ $? != 0 ]]; then
           echo -e "\nERROR: unable to create local $1: file not exists or permissions are not granted"
           exit 1
        fi
        createdConfigs+=($2)
    fi
}

# *****************************************
# docker compose configuration
# *****************************************
echo "************************************"
echo "Initializing docker-compose configuration: "
echo "--> creating docker-compose.local.yml file... "
config_copy ${PROJECT_DIR}/docker-compose.yml ${PROJECT_DIR}/docker-compose.local.yml

echo "--> creating .env file... "
config_copy ${PROJECT_DIR}/.env.dist ${PROJECT_DIR}/.env
echo -e "\n"

# *****************************************
# app configuration
# *****************************************
echo "************************************"
echo "Initializing application configuration: "
echo "--> creating application.yml file for application... "
config_copy ${PROJECT_DIR}/src/main/resources/application.yml.dist ${PROJECT_DIR}/src/main/resources/application.yml
echo -e "\n"

echo "************************************"
echo "INITIALIZATION COMPLETED!"
if [[ ${#createdConfigs[@]} -gt 0 ]]; then
    echo "New configuration files created:"
    for f in ${createdConfigs[@]}; do
        echo "--> $f"
    done

    echo -e "\nFeel free to modify them as you need\n"
else
    echo "No configuration files were created"
fi

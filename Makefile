PROJECT_NAME ?= authentication
VERSION = 1.0.0

all:
	@echo "make init  - Initializes application environment (local docker-compose.yml, application.yml and .env)"
	@echo "make build - Builds application docker image"
	@echo "make up	  - Brings up docker containers using pre-configured compose files"
	@echo "make down  - Stops and removes docker containers"
	@exit 0

init:
	@./utils/init.sh

build:
	docker build -t org.studyportal/$(PROJECT_NAME):$(VERSION) -t org.studyportal/$(PROJECT_NAME):1-latest .

up:
	@./utils/compose_up.sh

down:
	@./utils/compose_down.sh

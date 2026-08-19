#!/bin/bash

export SPRING_PROFILES_ACTIVE=${1:-default}
cd $(dirname "$0")
./mvnw clean spring-boot:run

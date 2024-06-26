#!/bin/bash

export SPRING_PROFILES_ACTIVE=${1:-default}
if [[ "$SPRING_PROFILES_ACTIVE" =~ "kafka" ]]; then
  export LOCALNAME=${HOSTNAME}
fi

cd $(dirname "$0")
./mvnw clean spring-boot:run

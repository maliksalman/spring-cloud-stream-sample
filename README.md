# spring-cloud-stream-sample

A sample set of spring-boot applications that use spring-cloud-stream to exchange some messages

There are two components in this system, the `initiator` and `responder`. Initiator listens on a port for *POST* calls and generates events. The `responder` only listens and generates events, it doesn't have an API.


## 1. Building

Both components are built and run similarly, they are both gradle projects.

```
./gradlew clean build
```

## 2. Running

```
java -jar build/libs/{APPNAME}-1.0.jar
```

where *APPNAME* is either `initiator` or `responder`

## 3. Running pre-requisites

These sample applications need a running instance of RabbitMQ or Kafka to function. Since the components use spring-cloud-stream abstraction, it can potentially work with any of the spring-cloud-stream 'binders' but was only tested with RabbitMQ and Kafka. You have to pick the same messaging technology for both components - these project don't show how to mix and match multiple messaging technologies in the same application but that is entirely possible.

### 3.1 Running with RabbitMQ (in docker)

The following command will start RabbitMQ running on port 5672 with the admin console available at [http://localhost:15672](http://localhost:15672)

```
docker run --rm -d -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

The username/password to access this RabbitMQ dashboard instance would be `guest`/`guest`

### 3.2 Running with Kafka (in docker)

The following command will start Kafka/Zookeeper running on ports 9092 (kafka) and 2181 (zookeeper). When running this way, start the applications with `kafka` spring profile (default profile will assume RabbitMQ). Also, there is no UI to interact/debug with kafka.

```
docker run --rm -d -p 2181:2181 -p 9092:9092 -e ADVERTISED_HOST={{{YOUR_HOSTNAME_HERE}}} maliksalman/kafka-dev:3.0.0
```

## 4. Kind of events

There are 3 kinds of events that flow through this system:

| Event Type | Producer Component | Consumer Component | Notes |
| ---------- | -------- | -------- | ----- |
| `this` | `initiator` | `responder` | Generate this event through `POST /generate/this` in the initiator component |
| `that` | `initiator` | `responder` | Generate this event through the `POST /generate/that` in the initiator component |
| `other` | `responder` | `initiator` | The responder generates this event upon receiving the other event |

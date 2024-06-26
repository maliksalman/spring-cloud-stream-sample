# spring-cloud-stream-sample

A sample set of spring-boot applications that use spring-cloud-stream to exchange some messages

There are two components in this system, the `initiator` and `responder`. Initiator listens on a port for *POST* calls and generates events. The `responder` only listens and generates events, it doesn't have an API.

## 1. Pre-requisites

- JDK 21+
- Docker (docker-compose)
 
## 2. Running (development)

These sample applications need a running instance of RabbitMQ or Kafka to function. Since the components use [**spring-cloud-stream**](https://spring.io/projects/spring-cloud-stream) abstraction, it can potentially work with any of the spring-cloud-stream _*binders*_ but these samples were only tested with RabbitMQ and Kafka binders. You have to pick the same messaging technology for both components - this project doesn't show how to mix and match multiple messaging technologies in the same application but that is entirely possible.

Both of the components use the new [docker-compose support](https://docs.spring.io/spring-boot/reference/features/dev-services.html#features.dev-services.docker-compose) to start dev containers when run via `./mvnw spring-boot:run` command or within an IDE. For convenience, we will use [initiator/spring-boot-run.sh](initiator/spring-boot-run.sh) and [responder/spring-boot-run.sh](responder/spring-boot-run.sh) scripts to start our components. When *not* using `./mvnw` or running inside an IDE, the docker-compose support is *not* active. 

### 2.1 Running with RabbitMQ (via docker-compose)

The following command will start the applications in the `default` spring profile. In this profile, the [compose-rabbit.yaml](compose-rabbit.yaml) will be used to start a dev container where RabbitMQ is running along with its management console. The RabbitMQ management console will be available using [http://localhost:15672](http://localhost:15672)

The username/password to access this RabbitMQ management console would be `myuser`/`secret`

```
responder/spring-boot-run.sh
```

and then in another terminal

```
initiator/spring-boot-run.sh
```

### 2.2 Running with Kafka (via docker-compose)

The following command will start the applications in the `kafka` spring profile. In this profile, the [compose-kafka.yaml](compose-kafka.yaml) will be used to start a dev container where Kafka/Zookeeper and kafka UI will be running. The kafka UI will be available using [http://localhost:15673](http://localhost:15673)

```
responder/spring-boot-run.sh kafka
```

and then in another terminal

```
initiator/spring-boot-run.sh kafka
```

### 2.3 Clean up

Because there are two components and they both share a single container instance, the configuration only starts a dev container when any of the components is started. The dev container is not shutdown when any of the components is terminated - this is not the default behavior for the docker-compose support in spring-boot but was configured to act this way intentionally for this application. To shut down and remove the dev containers when they are not needed, run `docker compose -f compose-kafka.yaml down` or `docker compose -f compose-rabbit.yaml down` 

## 3. Kind of events

There are 3 kinds of events that flow through this system:

| Event Type | Producer Component | Consumer Component | Notes |
| ---------- | -------- | -------- | ----- |
| `orange` | `initiator` | `responder` | Generate this event through `POST /generate/orange` in the initiator component |
| `apple` | `initiator` | `responder` | Generate this event through the `POST /generate/apple` in the initiator component |
| `pie` | `responder` | `initiator` | The responder generates this event upon receiving the *apple* event |

### 4.1 `orange` message flow:

![Orange Message Flow](orange-message-flow.jpg "Orange Message Flow")

### 4.2 `apple` and `pie` messages flow:

![Apple Message Flow](apple-message-flow.jpg "Apple Message Flow")

## 4. Verifying the application

Once both `initiator` and `responder` components are up and running, we can interact with the `initiator` API endpoints via the `initiator` [swagger-ui](http://localhost:8080). For example, after executing the `/generate/orange` API, notice that the `responder` component's log shows a message like:

```
2024-06-26T15:06:25.920-04:00  INFO 99902 --- [pic.responder-1] com.smalik.responder.OrangeConsumer      : Received: Fruit(id=30638c9d-6323-4a9d-a23a-581ca0bb8081, type=orange, time=2024-06-26T19:06:25.821542Z)
```
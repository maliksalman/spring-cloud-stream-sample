package com.smalik.initiator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {

    private final StreamBridge streamBridge;

    public Fruit generate(String type) {
        Fruit fruit = Fruit.builder()
                .id(UUID.randomUUID().toString())
                .time(OffsetDateTime.now())
                .type(type)
                .build();
        streamBridge.send(type, fruit);
        return fruit;
    }

    @Bean
    public Consumer<Pie> pieReceived() {
        return pie -> log.info("Received: {}", pie);
    }
}

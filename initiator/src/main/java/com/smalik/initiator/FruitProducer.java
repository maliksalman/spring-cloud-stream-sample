package com.smalik.initiator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class FruitProducer {

    private final StreamBridge streamBridge;

    public Fruit produce(String type) {
        Fruit fruit = Fruit.builder()
                .id(UUID.randomUUID().toString())
                .time(OffsetDateTime.now())
                .type(type)
                .build();
        streamBridge.send(type, fruit);
        return fruit;
    }
}

package com.smalik.initiator;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class FruitProducer {

    public Fruit produce(String type) {
        Fruit fruit = new Fruit(UUID.randomUUID(), OffsetDateTime.now());
        return fruit;
    }
}
package com.smalik.initiator;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class FruitProducer {

    private final StreamBridge streamBridge;

    public FruitProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public Fruit produce(String type) {
        Fruit fruit = new Fruit(UUID.randomUUID(), type, OffsetDateTime.now());
        streamBridge.send(type, fruit);
        return fruit;
    }
}

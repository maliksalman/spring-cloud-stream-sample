package com.smalik.initiator;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
public class FruitController {

    public record Fruit(
            UUID id,
            OffsetDateTime time) {
    }

    @PostMapping("/generate/apple")
    public Fruit generateAppleEvent() {
        return produce("apple");
    }

    @PostMapping("/generate/orange")
    public Fruit generateOrangeEvent() {
        return produce("orange");
    }

    private Fruit produce(String type) {
        Fruit fruit = new Fruit(UUID.randomUUID(), OffsetDateTime.now());

        // send the fruit as an event

        return fruit;
    }
}
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

    public Event generate(String type) {
        Event event = Event.builder()
                .id(UUID.randomUUID().toString())
                .time(OffsetDateTime.now())
                .type(type)
                .build();
        streamBridge.send(type, event);
        return event;
    }

    @Bean
    public Consumer<Event> pieReceived() {
        return event -> log.info("Received: {}", event);
    }
}

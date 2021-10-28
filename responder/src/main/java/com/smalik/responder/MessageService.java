package com.smalik.responder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;
import java.util.function.Function;

@Service
@Slf4j
public class MessageService {

    @Bean
    public Consumer<Event> orangeReceived() {
        return event -> log.info("Received: {}", event);
    }

    @Bean
    public Function<Event, Event> makeApplePie() {
        return event -> {
            log.info("Received: {}", event);
            return Event.builder()
                    .id(event.getId())
                    .type("pie")
                    .time(event.getTime())
                    .build();
        };
    }
}
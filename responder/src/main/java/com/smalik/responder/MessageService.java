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
    public Consumer<Event> thisReceived() {
        return evt -> log.info("Received: {}", evt);
    }

    @Bean
    public Function<Event, Event> convertThatToOther() {
        return that -> {
            log.info("Received: {}", that);
            return Event.builder()
                    .id(that.getId())
                    .type("other")
                    .time(that.getTime())
                    .build();
        };
    }
}
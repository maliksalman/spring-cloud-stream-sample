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
    public Consumer<Fruit> orangeReceived() {
        return orange -> log.info("Received: {}", orange);
    }

    @Bean
    public Function<Fruit, Pie> makeApplePie() {
        return apple -> {
            log.info("Received: {}", apple);
            return Pie.builder()
                    .id(apple.getId())
                    .time(apple.getTime())
                    .build();
        };
    }
}
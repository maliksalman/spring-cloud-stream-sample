package com.smalik.responder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@Slf4j
public class OrangeConsumer {

    @Bean
    public Consumer<Fruit> orangeReceived() {
        return orange -> log.info("Received: {}", orange);
    }
}
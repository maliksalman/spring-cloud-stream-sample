package com.smalik.responder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class OrangeConsumer {

    private final Logger log = LoggerFactory.getLogger(OrangeConsumer.class);

    @Bean
    public Consumer<Fruit> orangeReceived() {
        return orange -> log.info("Received: {}", orange);
    }
}
package com.smalik.initiator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class PieConsumer {

    private Logger log = LoggerFactory.getLogger(PieConsumer.class);

    @Bean
    public Consumer<Pie> pieReceived() {
        return pie -> log.info("Received: {}", pie);
    }

}

package com.smalik.initiator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@Slf4j
public class PieConsumer {

    @Bean
    public Consumer<Pie> pieReceived() {
        return pie -> log.info("Received: {}", pie);
    }

}

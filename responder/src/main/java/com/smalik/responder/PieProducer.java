package com.smalik.responder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PieProducer {

    private final Logger log = LoggerFactory.getLogger(PieProducer.class);

    @Bean
    public Function<Fruit, Pie> makeApplePie() {
        return apple -> {
            log.info("Received: {}", apple);
            return new Pie(apple.id(), apple.time());
        };
    }
}

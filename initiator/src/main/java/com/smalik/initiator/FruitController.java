package com.smalik.initiator;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generate")
public class FruitController {

    private final FruitProducer fruitProducer;

    public FruitController(FruitProducer fruitProducer) {
        this.fruitProducer = fruitProducer;
    }

    @PostMapping("/apple")
    public Fruit generateAppleEvent() {
        return fruitProducer.produce("apple");
    }

    @PostMapping("/orange")
    public Fruit generateOrangeEvent() {
        return fruitProducer.produce("orange");
    }
}
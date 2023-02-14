package com.smalik.initiator;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produce")
public class FruitController {

    private final FruitProducer fruitProducer;

    @PostMapping("/apple")
    public Fruit generateAppleEvent() {
        return fruitProducer.produce("apple");
    }

    @PostMapping("/orange")
    public Fruit generateOrangeEvent() {
        return fruitProducer.produce("orange");
    }
}

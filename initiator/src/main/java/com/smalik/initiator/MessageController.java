package com.smalik.initiator;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/generate/apple")
    public Fruit generateAppleEvent() {
        return messageService.generate("apple");
    }

    @PostMapping("/generate/orange")
    public Fruit generateOrangeEvent() {
        return messageService.generate("orange");
    }
}

package com.smalik.initiator;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/generate/this")
    public Event generateThisEvent() {
        return messageService.generate("this");
    }

    @PostMapping("/generate/that")
    public Event generateThatEvent() {
        return messageService.generate("that");
    }
}

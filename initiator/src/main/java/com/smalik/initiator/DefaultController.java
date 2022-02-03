package com.smalik.initiator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

    @RequestMapping("/")
    public String defaultEndpoint() {
        return "redirect:/swagger-ui.html";
    }
}

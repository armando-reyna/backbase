package com.backbase.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WelcomeController {

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", "Hello World");
        return "welcome";
    }

    @RequestMapping("/login")
    public String login(Map<String, Object> model) {
        model.put("message", "Hello World");
        return "login";
    }

}

package com.dev.sge.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "landing";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}

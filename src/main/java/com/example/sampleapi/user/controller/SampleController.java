package com.example.sampleapi.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/")
    public String greetings(){
        return "Greetings from rakki";
    }
}

package com.example.echoserver.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class EchoController {

    @RequestMapping("/echo")
    public String index(@RequestBody String body) {
        return body;
    }

}

package com.froyo.mlt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/public/test")
    public String publicTest() {
        return "Public Content";
    }

    @GetMapping("/api/private/test")
    public String privateTest() {
        return "Private Content";
    }
}

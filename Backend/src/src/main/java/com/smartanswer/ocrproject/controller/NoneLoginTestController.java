package com.smartanswer.ocrproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class NoneLoginTestController {

    @GetMapping("/hello")
    String testHello(){
        return "Hello world";
    }

}
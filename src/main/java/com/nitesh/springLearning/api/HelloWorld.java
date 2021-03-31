package com.nitesh.springLearning.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloWorld {
    @GetMapping
    public String home(){
        return "Application is under maintainence " + new Date();
    }
}

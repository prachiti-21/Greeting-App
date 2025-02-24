package com.example.GreetingService.controller;


import com.example.GreetingService.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@ComponentScan
@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final GreetingService greetingService;
    @Autowired
    public  GreetingController(GreetingService greetingService){
        this.greetingService=greetingService;

    }
    @GetMapping("/simple")
    public String getSimpleGreeting(){
        return greetingService.getSimpleGreeting();
    }
}

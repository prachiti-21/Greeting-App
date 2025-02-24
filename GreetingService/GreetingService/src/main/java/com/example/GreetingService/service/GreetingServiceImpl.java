package com.example.GreetingService.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
//@ComponentScan
@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String getSimpleGreeting(){
        return "Hello World";
    }
}

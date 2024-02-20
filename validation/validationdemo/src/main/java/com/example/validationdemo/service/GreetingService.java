package com.example.validationdemo.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    
    
    public String greet(String from, String to, String msg) {
        return String.format("Hello %s, %s says %s", to, from, msg);
    }
}

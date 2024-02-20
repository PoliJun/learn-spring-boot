package com.example.validationdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.validationdemo.dto.Greeting;
import com.example.validationdemo.service.GreetingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/greeting")
public class GreetingController {
    private final GreetingService greetingService;

    @PostMapping
    public ResponseEntity<String> greet(@RequestBody @Valid Greeting greeting) {
        return ResponseEntity.ok(greetingService.greet(greeting.getMsg(), greeting.getFrom(), greeting.getTo()));
    }
}

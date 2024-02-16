package com.example.jwtdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import java.util.Date;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1/demo-controller")
@RequiredArgsConstructor
public class DemoController {
    @GetMapping("")
    public ResponseEntity<String> sayHellResponseEntity() {
        return ResponseEntity.ok(new Date(System.currentTimeMillis()).toString() + " to "
                + new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24).toString());
    }

}

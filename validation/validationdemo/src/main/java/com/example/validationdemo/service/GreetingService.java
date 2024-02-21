package com.example.validationdemo.service;

import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.validationdemo.dto.Greeting;
import com.example.validationdemo.validator.ObjectValidator;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GreetingService {
    private final ObjectValidator<Greeting> objectValidator;

    public String greet(Greeting greeting) {
        var violations = objectValidator.validate(greeting);
        if (!violations.isEmpty()) {
            return String.join(" \n| ",
                    violations.stream().map(Object::toString).collect(Collectors.toSet()));
        }
        return String.format("Hello %s, %s says %s", greeting.getMsg(), greeting.getFrom(),
                greeting.getTo());
    }
}

package com.example.validationdemo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Greeting {

    @NotNull(message = "Message cannot be null")
    @NotEmpty(message = "Message cannot be empty")
    private String msg;

    @NotNull(message = "From cannot be null")
    @NotEmpty(message = "From cannot be empty")
    private String from;

    @NotNull(message = "To cannot be null")
    @NotEmpty(message = "To cannot be empty")
    private String to;
}

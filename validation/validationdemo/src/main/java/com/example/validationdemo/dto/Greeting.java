package com.example.validationdemo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Greeting {

    @NotNull
    @NotEmpty
    private String msg;
    
    @NotNull
    @NotEmpty
    private String from;
    
    @NotNull
    @NotEmpty
    private String to;
}

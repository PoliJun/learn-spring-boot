package com.example.validationdemo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExampleDto {
    @NotNull
    @NotEmpty
    private String a;
    @NotNull
    @NotEmpty
    private String b;
    @NotNull
    @NotEmpty
    private String c;
}

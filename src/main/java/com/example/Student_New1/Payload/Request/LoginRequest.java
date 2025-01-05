package com.example.Student_New1.Payload.Request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    // Getters and Setters
}

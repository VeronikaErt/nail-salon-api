package com.example.nailsalon.dto; import jakarta.validation.constraints.*;
public record LoginRequest(@NotBlank String login,@NotBlank String password) {}

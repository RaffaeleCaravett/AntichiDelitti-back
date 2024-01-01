package com.example.antichidelitti.payloads.entities;

import jakarta.validation.constraints.NotEmpty;

public record TagDTO(
        @NotEmpty(message="Il tag è obbligatorio")
        String tag
) {
}

package com.example.antichidelitti.payloads.entities;

import jakarta.validation.constraints.NotEmpty;

public record TemaDTO(
        @NotEmpty(message="Il thema è obbligatorio")
        String thema

){
}

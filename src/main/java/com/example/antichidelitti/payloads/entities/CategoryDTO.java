package com.example.antichidelitti.payloads.entities;

import jakarta.validation.constraints.NotEmpty;

public record CategoryDTO(

        @NotEmpty(message="La category è obbligatoria")
        String category
) {

}

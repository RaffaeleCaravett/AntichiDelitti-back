package com.example.antichidelitti.payloads.entities;

import jakarta.validation.constraints.NotEmpty;

public record LuogoDTO (
        @NotEmpty(message="Il luogo non può essere vuoto")
        String luogo
){
}

package com.example.antichidelitti.payloads.entities;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record ArticoloDTO(
        @NotEmpty(message="Il titolo non può essere vuoto")
        String titolo,
        @NotEmpty(message="Il testo non può essere vuoto")
        String testo,
        List<Long> category_id,
        List<Long> theme_id,
        List<Long> tag_id,
        long luogo_id,
        List<String> imageList,
        List<Long> personaggio_id

        ) {
}

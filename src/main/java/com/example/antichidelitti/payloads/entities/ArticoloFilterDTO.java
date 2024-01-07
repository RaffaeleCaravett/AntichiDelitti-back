package com.example.antichidelitti.payloads.entities;

import com.example.antichidelitti.categoria.Categoria;
import com.example.antichidelitti.tema.Tema;


public record ArticoloFilterDTO(
        String titolo,
        String luogo,
        long tema_id,
        long categoria_id
) {


}

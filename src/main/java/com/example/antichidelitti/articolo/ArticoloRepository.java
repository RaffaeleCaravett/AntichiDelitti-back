package com.example.antichidelitti.articolo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticoloRepository extends JpaRepository<Articolo,Long> {

List<Articolo> findByTitoloAndLuogo_LuogoContainsAndTemaList_ThemaContainsAndCategoriaList_CategoryContains(String titolo, String luogo, String thema, String categoria);

}


package com.example.antichidelitti.articolo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticoloRepository extends JpaRepository<Articolo,Long> {

List<Articolo> findByTitoloAndLuogo_LuogoContainsAndTemaList_IdAndCategoriaList_Id(String titolo, String luogo, Long thema, Long categoria);
    List<Articolo> findByTitoloAndLuogo_LuogoContainsAndTemaList_Id(String titolo, String luogo, Long thema);
    List<Articolo> findByTitoloAndLuogo_LuogoContainsAndCategoriaList_Id(String titolo, String luogo, Long categoria);
    List<Articolo> findByTitoloAndLuogo_LuogoContains(String titolo, String luogo);


}


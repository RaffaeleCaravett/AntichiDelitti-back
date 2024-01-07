package com.example.antichidelitti.articolo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticoloRepository extends JpaRepository<Articolo,Long> {

List<Articolo> findByTitoloContainsAndLuogo_IdAndTemaList_IdAndCategoriaList_Id(String titolo, Long luogo, Long thema, Long categoria);
    List<Articolo> findByTitoloContainsAndLuogo_IdAndTemaList_Id(String titolo, Long luogo, Long thema);
    List<Articolo> findByTitoloContainsAndLuogo_IdAndCategoriaList_Id(String titolo, Long luogo, Long categoria);
    List<Articolo> findByTitoloContainsAndCategoriaList_Id(String titolo, Long categoria);
    List<Articolo> findByTitoloContainsAndTemaList_Id(String titolo,  Long thema);
    List<Articolo> findByTitoloContainsAndTemaList_IdAndCategoriaList_Id(String titolo, Long thema, Long categoria);
    List<Articolo> findByTitoloContainsAndLuogo_Id(String titolo, Long luogo);
    List<Articolo> findByTitoloContains(String titolo);



}


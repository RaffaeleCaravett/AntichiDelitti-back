package com.example.antichidelitti.tema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemaRepository extends JpaRepository<Tema,Long> {
    List<Tema> findByThemaContainsIgnoreCase(String thema);
    Tema findByThema(String thema);
}

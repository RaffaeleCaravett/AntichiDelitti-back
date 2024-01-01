package com.example.antichidelitti.articolo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticoloRepository extends JpaRepository<Articolo,Long> {
}

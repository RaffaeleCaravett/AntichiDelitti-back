package com.example.antichidelitti.bozza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BozzaRepository extends JpaRepository<Bozza,Long> {
}

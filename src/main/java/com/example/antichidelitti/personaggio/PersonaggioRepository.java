package com.example.antichidelitti.personaggio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaggioRepository extends JpaRepository<Personaggio,Long> {
}

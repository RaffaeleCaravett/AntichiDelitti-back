package com.example.antichidelitti.personaggio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaggioRepository extends JpaRepository<Personaggio,Long> {
    List<Personaggio> findByAliasContainsIgnoreCase(String alias);
    Personaggio findByAlias(String alias);

}

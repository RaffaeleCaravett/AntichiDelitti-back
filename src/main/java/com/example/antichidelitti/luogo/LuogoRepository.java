package com.example.antichidelitti.luogo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LuogoRepository extends JpaRepository<Luogo,Long> {

List<Luogo> findByLuogoContainsIgnoreCase(String luogo);
    Luogo findByLuogo(String luogo);

}

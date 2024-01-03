package com.example.antichidelitti.categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    List<Categoria> findByCategoryContainsIgnoreCase(String category);
    Categoria findByCategory(String category);
}

package com.example.antichidelitti.categoria;

import com.example.antichidelitti.articolo.Articolo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String category;
    @ManyToMany(mappedBy = "categoriaList")
    private List<Articolo> article;
}

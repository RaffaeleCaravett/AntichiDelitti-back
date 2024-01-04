package com.example.antichidelitti.categoria;

import com.example.antichidelitti.articolo.Articolo;
import com.example.antichidelitti.bozza.Bozza;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @ManyToMany(mappedBy = "categoriaList")
    private List<Articolo> article;
    @JsonIgnore
    @ManyToMany(mappedBy = "categoriaList")
    private List<Bozza> bozza;
}

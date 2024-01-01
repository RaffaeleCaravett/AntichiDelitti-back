package com.example.antichidelitti.articolo;

import com.example.antichidelitti.categoria.Categoria;
import com.example.antichidelitti.luogo.Luogo;
import com.example.antichidelitti.tema.Tema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "articles")
@Getter
@Setter
public class Articolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titolo;
    private String testo;
    private List<String> images;
    @ManyToMany
    @JoinTable(name = "articole_category")
    private List<Categoria> categoriaList;
    @ManyToMany
    @JoinTable(name = "articole_themas")
    private List<Tema> temaList;
    @ManyToOne
    @JoinColumn(name = "luogo_id")
    private Luogo luogo;
    private LocalDate created_at;


}

package com.example.antichidelitti.bozza;

import com.example.antichidelitti.categoria.Categoria;
import com.example.antichidelitti.luogo.Luogo;
import com.example.antichidelitti.tag.Tag;
import com.example.antichidelitti.tema.Tema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "saved")
@Getter
@Setter
public class Bozza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titolo;
    private String testo;
    private List<String> images;
    @ManyToMany
    @JoinTable(name = "saved_category",
            joinColumns = @JoinColumn(name = "saved_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categoriaList;
    @ManyToMany
    @JoinTable(name = "saved_themas",
            joinColumns = @JoinColumn(name = "saved_id"),
            inverseJoinColumns = @JoinColumn(name = "tema_id"))
    private List<Tema> temaList;
    @ManyToMany
    @JoinTable(name = "saved_tags",
            joinColumns = @JoinColumn(name = "saved_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tagList;
    @ManyToOne
    @JoinColumn(name = "luogo_id")
    private Luogo luogo;
    private LocalDate created_at;
}



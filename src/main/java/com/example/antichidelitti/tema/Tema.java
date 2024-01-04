package com.example.antichidelitti.tema;

import com.example.antichidelitti.articolo.Articolo;
import com.example.antichidelitti.bozza.Bozza;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "themas")
@Getter
@Setter
public class Tema {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
private String thema;
@JsonIgnore
@ManyToMany(mappedBy = "temaList")
private List<Articolo> article;
@JsonIgnore
    @ManyToMany(mappedBy = "temaList")
    private List<Bozza> bozza;
}

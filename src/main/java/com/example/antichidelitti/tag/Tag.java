package com.example.antichidelitti.tag;

import com.example.antichidelitti.articolo.Articolo;
import com.example.antichidelitti.bozza.Bozza;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tags")
@Getter
@Setter
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tag;
    @JsonIgnore
    @ManyToMany(mappedBy = "tagList")
    private List<Articolo> article;
    @JsonIgnore
    @ManyToMany(mappedBy = "tagList")
    private List<Bozza> bozza;
}

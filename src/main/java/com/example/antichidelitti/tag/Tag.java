package com.example.antichidelitti.tag;

import com.example.antichidelitti.articolo.Articolo;
import com.example.antichidelitti.bozza.Bozza;
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
    @ManyToMany(mappedBy = "tagList")
    private List<Articolo> article;
    @ManyToMany(mappedBy = "tagList")
    private List<Bozza> bozza;
}

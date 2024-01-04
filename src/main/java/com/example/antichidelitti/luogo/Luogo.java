package com.example.antichidelitti.luogo;

import com.example.antichidelitti.articolo.Articolo;
import com.example.antichidelitti.bozza.Bozza;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="places")
@Getter
@Setter
public class Luogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String luogo;
    @JsonIgnore
    @OneToMany(mappedBy = "luogo")
    private List<Articolo> article;
    @JsonIgnore
    @OneToMany(mappedBy = "luogo")
    private List<Bozza> bozza;
}

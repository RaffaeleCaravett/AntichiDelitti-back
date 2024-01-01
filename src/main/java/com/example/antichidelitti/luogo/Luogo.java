package com.example.antichidelitti.luogo;

import com.example.antichidelitti.articolo.Articolo;
import com.example.antichidelitti.bozza.Bozza;
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
    @OneToMany(mappedBy = "luogo_id")
    private List<Articolo> article;
    @OneToMany(mappedBy = "luogo_id")
    private List<Bozza> bozza;
}

package com.example.antichidelitti.personaggio;

import com.example.antichidelitti.articolo.Articolo;
import com.example.antichidelitti.bozza.Bozza;
import com.example.antichidelitti.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="characters")
@Getter
@Setter
public class Personaggio {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String alias;
    @JsonIgnore
    @ManyToMany(mappedBy = "personaggioList")
    List<Articolo> articoloList;
}

package com.example.labxpert.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Echantillon echantillon;
    @ManyToOne
    private TestPre testPre;
    @ManyToOne
    private Analyse analyse;
    @OneToOne
    private Resultat resultat;
    @OneToMany(mappedBy = "test")
    private List<TestReactif> testReactifs;
}

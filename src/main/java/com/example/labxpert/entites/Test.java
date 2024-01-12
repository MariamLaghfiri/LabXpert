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

    @Override
    public String toString() {
        return "Test{" +
                "echantillon=" + echantillon +
                ", testPre=" + testPre +
                ", analyse=" + analyse +
                ", resultat=" + resultat +
                ", testReactifs=" + testReactifs +
                '}';
    }

    public Test(Echantillon echantillon, TestPre testPre, Analyse analyse, Resultat resultat, List<TestReactif> testReactifs) {
        this.echantillon = echantillon;
        this.testPre = testPre;
        this.analyse = analyse;
        this.resultat = resultat;
        this.testReactifs = testReactifs;
    }

}

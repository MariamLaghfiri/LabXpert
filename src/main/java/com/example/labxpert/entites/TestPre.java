package com.example.labxpert.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "test_pre")
public class TestPre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Double min_valeur;
    private Double max_valeur;
    @ManyToOne
    private AnalysePre analysePre;
    @OneToMany(mappedBy = "testPre")
    private List<Test> test;

    @Override
    public String toString() {
        return "TestPre{" +
                "nom='" + nom + '\'' +
                ", min_valeur=" + min_valeur +
                ", max_valeur=" + max_valeur +
                ", analysePre=" + analysePre +
                ", test=" + test +
                '}';
    }

    public TestPre(String nom, Double min_valeur, Double max_valeur, AnalysePre analysePre, List<Test> test) {
        this.nom = nom;
        this.min_valeur = min_valeur;
        this.max_valeur = max_valeur;
        this.analysePre = analysePre;
        this.test = test;
    }
}

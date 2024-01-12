package com.example.labxpert.entites;

import com.example.labxpert.entites.Enum.StatutR;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "resultat")
public class Resultat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Test test;
    private Double valeur;
    private String unite_mesure;
    @Enumerated(EnumType.STRING)
    private StatutR statut;

    @Override
    public String toString() {
        return "Resultat{" +
                "test=" + test +
                ", valeur=" + valeur +
                ", unite_mesure='" + unite_mesure + '\'' +
                ", statut=" + statut +
                '}';
    }

    public Resultat(Test test, Double valeur, String unite_mesure, StatutR statut) {
        this.test = test;
        this.valeur = valeur;
        this.unite_mesure = unite_mesure;
        this.statut = statut;
    }
}

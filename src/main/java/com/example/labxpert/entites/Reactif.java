package com.example.labxpert.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "reactif")
public class Reactif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private Double quantite_en_stock;
    private Date date_expiration;
    private String fournisseur;
    @OneToMany(mappedBy = "reactif")
    private List<TestReactif> testReactif;

    @Override
    public String toString() {
        return "Reactif{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", quantite_en_stock=" + quantite_en_stock +
                ", date_expiration=" + date_expiration +
                ", fournisseur='" + fournisseur + '\'' +
                ", testReactif=" + testReactif +
                '}';
    }

    public Reactif(String nom, String description, Double quantite_en_stock, Date date_expiration, String fournisseur, List<TestReactif> testReactif) {
        this.nom = nom;
        this.description = description;
        this.quantite_en_stock = quantite_en_stock;
        this.date_expiration = date_expiration;
        this.fournisseur = fournisseur;
        this.testReactif = testReactif;
    }
}

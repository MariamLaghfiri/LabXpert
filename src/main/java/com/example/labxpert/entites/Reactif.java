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
}

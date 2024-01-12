package com.example.labxpert.entites;

import com.example.labxpert.entites.Enum.Role;
import com.example.labxpert.entites.Enum.Sexe;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Date date_naissance;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    @Column(name = "telephone", nullable = true)
    private String telephone;
    @Column(name = "adresse", nullable = true)
    private String adresse;
    @OneToMany(mappedBy = "patient")
    private List<Analyse> historique_analyses;
    @OneToMany(mappedBy = "patient")
    private List<Echantillon> echantillons;
}

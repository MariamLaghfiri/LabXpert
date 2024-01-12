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

    @Override
    public String toString() {
        return "Patient{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", date_naissance=" + date_naissance +
                ", sexe=" + sexe +
                ", telephone='" + telephone + '\'' +
                ", adresse='" + adresse + '\'' +
                ", historique_analyses=" + historique_analyses +
                ", echantillons=" + echantillons +
                '}';
    }

    public Patient(String nom, String prenom, Date date_naissance, Sexe sexe, String telephone, String adresse, List<Analyse> historique_analyses, List<Echantillon> echantillons) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.sexe = sexe;
        this.telephone = telephone;
        this.adresse = adresse;
        this.historique_analyses = historique_analyses;
        this.echantillons = echantillons;
    }
}

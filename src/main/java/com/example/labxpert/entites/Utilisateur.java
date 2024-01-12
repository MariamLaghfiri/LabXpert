package com.example.labxpert.entites;

import com.example.labxpert.entites.Enum.Role;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "telephone", nullable = true)
    private String telephone;
    @Column(name = "adresse", nullable = true)
    private String adresse;
    @OneToMany(mappedBy = "utilisateur")
    private List<Analyse> analyses;

    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", telephone='" + telephone + '\'' +
                ", adresse='" + adresse + '\'' +
                ", analyses=" + analyses +
                '}';
    }

    public Utilisateur(String nom, String password, Role role, String telephone, String adresse, List<Analyse> analyse) {
        this.nom = nom;
        this.password = password;
        this.role = role;
        this.telephone = telephone;
        this.adresse = adresse;
        this.analyses = analyse;
    }
}

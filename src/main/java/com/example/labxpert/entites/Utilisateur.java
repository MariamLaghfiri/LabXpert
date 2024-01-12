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
}

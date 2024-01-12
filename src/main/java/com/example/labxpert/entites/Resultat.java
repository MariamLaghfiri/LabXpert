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
    private Analyse analyse;
    private Double valeur;
    private String unite_mesure;
    @Enumerated(EnumType.STRING)
    private StatutR statut;
}

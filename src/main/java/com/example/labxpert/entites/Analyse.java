package com.example.labxpert.entites;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "analyses")
public class Analyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date_debut_analyse;
    private LocalDateTime date_fin_analyse;
    private String commentaires;
    @ManyToOne
    private Echantillon echantillon;
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private Planification planification;
    @OneToOne
    private Resultat resultat;
    @ManyToOne
    private Patient patient;
    @OneToMany(mappedBy = "analyse")
    private List<AnalyseReactif> analyse_reactifs;
}

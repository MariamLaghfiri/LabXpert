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
    private Utilisateur utilisateur;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private AnalysePre analysePre;
    @OneToMany(mappedBy = "analyse")
    private List<Test> test;

    @Override
    public String toString() {
        return "Analyse{" +
                "date_debut_analyse=" + date_debut_analyse +
                ", date_fin_analyse=" + date_fin_analyse +
                ", commentaires='" + commentaires + '\'' +
                ", utilisateur=" + utilisateur +
                ", patient=" + patient +
                ", analysePre=" + analysePre +
                ", test=" + test +
                '}';
    }

    public Analyse(LocalDateTime date_debut_analyse, LocalDateTime date_fin_analyse, String commentaires, Utilisateur utilisateur, Patient patient, AnalysePre analysePre, List<Test> test) {
        this.date_debut_analyse = date_debut_analyse;
        this.date_fin_analyse = date_fin_analyse;
        this.commentaires = commentaires;
        this.utilisateur = utilisateur;
        this.patient = patient;
        this.analysePre = analysePre;
        this.test = test;
    }
}

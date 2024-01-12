package com.example.labxpert.entites;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "planification")
public class Planification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "planification")
    private List<Analyse> analyse;
    @ManyToOne
    private Utilisateur utilisateur;
    private LocalDateTime date_debut;
    private LocalDateTime date_fin;
}

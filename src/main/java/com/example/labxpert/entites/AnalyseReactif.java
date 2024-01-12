package com.example.labxpert.entites;

import com.example.labxpert.entites.Enum.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "analyse_reactif")
public class AnalyseReactif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Analyse analyse;
    @ManyToOne
    private Reactif reactif;
    private Double quantity;
}

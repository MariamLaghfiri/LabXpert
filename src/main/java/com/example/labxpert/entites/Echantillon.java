package com.example.labxpert.entites;

import com.example.labxpert.entites.Enum.StatutE;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "echantillon")
public class Echantillon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Patient patient;
    private String type_analyse;
    private Date date_prelevement;
    @Enumerated(EnumType.STRING)
    private StatutE statut;
    @OneToMany(mappedBy = "echantillon")
    private List<Test> test;
}

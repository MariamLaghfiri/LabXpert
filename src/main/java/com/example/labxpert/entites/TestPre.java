package com.example.labxpert.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "test_pre")
public class TestPre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Double min_valeur;
    private Double max_valeur;
    @ManyToOne
    private AnalysePre analysePre;
    @OneToMany(mappedBy = "testPre")
    private List<Test> test;
}

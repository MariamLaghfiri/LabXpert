package com.example.labxpert.entites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "test_reactif")
public class TestReactif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Test test;
    @ManyToOne
    private Reactif reactif;
    private Double quantity;
}

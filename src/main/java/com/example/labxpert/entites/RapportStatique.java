package com.example.labxpert.entites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rapport_statique")
public class RapportStatique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String periode_rapport;
}

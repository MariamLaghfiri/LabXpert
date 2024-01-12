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

    @Override
    public String toString() {
        return "RapportStatique{" +
                "type='" + type + '\'' +
                ", periode_rapport='" + periode_rapport + '\'' +
                '}';
    }

    public RapportStatique(String type, String periode_rapport) {
        this.type = type;
        this.periode_rapport = periode_rapport;
    }
}

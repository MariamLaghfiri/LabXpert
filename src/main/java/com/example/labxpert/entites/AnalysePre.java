package com.example.labxpert.entites;

import com.example.labxpert.entites.Enum.Branches;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "analyses_pre")
public class AnalysePre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Branches branche;
    @OneToMany(mappedBy = "analysePre")
    private List<Analyse> analyse;
    @OneToMany(mappedBy = "analysePre")
    private List<TestPre> testPre;
}

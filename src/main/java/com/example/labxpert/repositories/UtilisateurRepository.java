package com.example.labxpert.repositories;

import com.example.labxpert.entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}

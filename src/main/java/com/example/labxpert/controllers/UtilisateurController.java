package com.example.labxpert.controllers;

import com.example.labxpert.entites.Utilisateur;
import com.example.labxpert.exceptions.ResourceNotFoundException;
import com.example.labxpert.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    //get utilisateur
    @GetMapping("/utilisateurs")
    public List<Utilisateur> getAllUtilisar(){
        return this.utilisateurRepository.findAll();
    }
    //get utilisateur by ID
    @GetMapping("/utilisateurs/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur not exist with id :" + id));
        return ResponseEntity.ok(utilisateur);
    }
    //save Utilisateur
    @PostMapping("/utilisateurs")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }
    //update Utilisateur
    @PutMapping("utilisateurs/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable(value = "id") Long id, @RequestBody Utilisateur utilisateurP){
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur not exist with id :" + id));
        utilisateur.setNom(utilisateurP.getNom());
        utilisateur.setRole(utilisateurP.getRole());
        utilisateur.setAdresse(utilisateurP.getAdresse());
        utilisateur.setTelephone(utilisateurP.getTelephone());
        utilisateur.setPassword(utilisateurP.getPassword());
        Utilisateur updatedUtilisateur = utilisateurRepository.save(utilisateur);
        return ResponseEntity.ok(updatedUtilisateur);
    }
    //delete Utilisateur
    @DeleteMapping("utilisateurs/{id}")
    public Map<String, Boolean> deleteUtilisateur(@PathVariable(value = "id") Long id){
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur not exist with id :" + id));
        this.utilisateurRepository.delete(utilisateur);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}

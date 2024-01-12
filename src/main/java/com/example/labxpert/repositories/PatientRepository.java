package com.example.labxpert.repositories;

import com.example.labxpert.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

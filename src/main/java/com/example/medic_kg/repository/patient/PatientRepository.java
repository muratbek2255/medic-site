package com.example.medic_kg.repository.patient;

import com.example.medic_kg.entity.patient.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findByEmail(String emil);

    @Transactional
    @Modifying
    @Query("UPDATE Patient a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
}
package com.example.Aster_Hosp.repo;

import com.example.Aster_Hosp.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> { }


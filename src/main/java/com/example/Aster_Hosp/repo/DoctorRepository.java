package com.example.Aster_Hosp.repo;

import com.example.Aster_Hosp.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}

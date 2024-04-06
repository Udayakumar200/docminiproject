package com.doc.doctorpat.repo;

import com.doc.doctorpat.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface PatientRepo extends JpaRepository<Patient,Long> {
    Optional<Patient> findByEmailAndPassword(String email, String password);
}

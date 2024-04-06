package com.doc.doctorpat.repo;

import com.doc.doctorpat.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor,Long> {
}

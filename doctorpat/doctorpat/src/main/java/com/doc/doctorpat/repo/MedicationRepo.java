package com.doc.doctorpat.repo;

import com.doc.doctorpat.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepo extends JpaRepository<Medication,Long> {

}

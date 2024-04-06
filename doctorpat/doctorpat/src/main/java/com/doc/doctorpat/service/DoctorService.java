package com.doc.doctorpat.service;

import com.doc.doctorpat.dto.DoctorDTO;
import com.doc.doctorpat.entity.Doctor;


import java.util.List;

public interface DoctorService {
    Doctor getDoctorById(Long id);
    List<Doctor> getAllDoctors();
    DoctorDTO addDoctor(DoctorDTO doctorDTO);

}

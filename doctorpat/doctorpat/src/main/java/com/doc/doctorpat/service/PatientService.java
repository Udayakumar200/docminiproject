package com.doc.doctorpat.service;

import com.doc.doctorpat.dto.PatientDTO;

public interface PatientService {
    PatientDTO login(String email, String password);
}

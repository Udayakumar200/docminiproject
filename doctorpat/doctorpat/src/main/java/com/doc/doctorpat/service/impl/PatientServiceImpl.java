package com.doc.doctorpat.service.impl;

import com.doc.doctorpat.dto.PatientDTO;
import com.doc.doctorpat.entity.Patient;
import com.doc.doctorpat.execpt.ResourceNotFoundException;
import com.doc.doctorpat.mapper.PatientMapper;
import com.doc.doctorpat.repo.PatientRepo;
import com.doc.doctorpat.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepo patientRepo;
    private final PatientMapper patientMapper;

    @Autowired
    public PatientServiceImpl(PatientRepo patientRepo, PatientMapper patientMapper) {
        this.patientRepo = patientRepo;
        this.patientMapper = patientMapper;
    }
    @Override
    public PatientDTO login(String email, String password) {
        Patient patient = patientRepo.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid email or password"));
        return patientMapper.mapToPatientDTO(patient);

    }
}

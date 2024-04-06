package com.doc.doctorpat.mapper;

import com.doc.doctorpat.dto.PatientDTO;
import com.doc.doctorpat.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {
    public static PatientDTO mapToPatientDTO(Patient patient){
        return new PatientDTO(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getHistory(),
                patient.getPassword()
        );
    }

    public static Patient mapToPatient(PatientDTO patientDTO){
        return new Patient (
                patientDTO.getId(),
                patientDTO.getName(),
                patientDTO.getEmail(),
                patientDTO.getHistory(),
                patientDTO.getPassword()
        );
    }
}

package com.doc.doctorpat.mapper;

import com.doc.doctorpat.dto.MedicationDTO;
import com.doc.doctorpat.entity.Medication;
import org.springframework.stereotype.Component;

@Component
public class MedicationMapper {
    public MedicationDTO mapToMedicationDTO(Medication medication) {
        MedicationDTO dto = new MedicationDTO();
        dto.setId(medication.getId());
        dto.setName(medication.getName());
        dto.setDosage(medication.getDosage());
        return dto;
    }
    public Medication mapToMedication(MedicationDTO dto) {
        Medication medication = new Medication();
        medication.setId(dto.getId());
        medication.setName(dto.getName());
        medication.setDosage(dto.getDosage());
        return medication;
    }

}

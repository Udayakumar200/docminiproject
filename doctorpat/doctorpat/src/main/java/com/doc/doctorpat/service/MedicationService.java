package com.doc.doctorpat.service;

import com.doc.doctorpat.dto.MedicationDTO;

import java.util.List;

public interface MedicationService {
    MedicationDTO viewmedic(Long medicationId);
    MedicationDTO createmedic(MedicationDTO medicationDTO);
    MedicationDTO getmedic (Long MedicationId);
    List<MedicationDTO> getAllmedic();
    MedicationDTO updatemedic(Long medicationId, MedicationDTO updatemedic);
    void deletemedic (Long MedicationId);
}

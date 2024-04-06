package com.doc.doctorpat.service.impl;

import com.doc.doctorpat.dto.MedicationDTO;
import com.doc.doctorpat.entity.Medication;
import com.doc.doctorpat.mapper.MedicationMapper;
import com.doc.doctorpat.repo.MedicationRepo;
import com.doc.doctorpat.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicationServiceImpl implements MedicationService {

    private final MedicationRepo medicationRepo;
    private final MedicationMapper medicationMapper;

    @Autowired
    public MedicationServiceImpl(MedicationRepo medicationRepo, MedicationMapper medicationMapper) {
        this.medicationRepo = medicationRepo;
        this.medicationMapper = medicationMapper;
    }

    @Override
    public MedicationDTO viewmedic(Long medicationId) {
        Medication medication = medicationRepo.findById(medicationId).orElse(null);
        return medication != null ? medicationMapper.mapToMedicationDTO(medication) : null;
    }

    @Override
    public MedicationDTO createmedic(MedicationDTO medicationDTO) {
        Medication medication = medicationMapper.mapToMedication(medicationDTO);
        medication = medicationRepo.save(medication);
        return medicationMapper.mapToMedicationDTO(medication);
    }

    @Override
    public MedicationDTO getmedic(Long medicationId) {
        return viewmedic(medicationId);
    }

    @Override
    public List<MedicationDTO> getAllmedic() {
        return medicationRepo.findAll().stream()
                .map(medicationMapper::mapToMedicationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MedicationDTO updatemedic(Long medicationId, MedicationDTO updatedMedicationDTO) {
        Medication existingMedication = medicationRepo.findById(medicationId).orElse(null);
        if (existingMedication != null) {
            Medication updatedMedication = medicationMapper.mapToMedication(updatedMedicationDTO);
            updatedMedication.setId(medicationId);
            updatedMedication = medicationRepo.save(updatedMedication);
            return medicationMapper.mapToMedicationDTO(updatedMedication);
        }
        return null;
    }

    @Override
    public void deletemedic(Long medicationId) {
        medicationRepo.deleteById(medicationId);
    }
}

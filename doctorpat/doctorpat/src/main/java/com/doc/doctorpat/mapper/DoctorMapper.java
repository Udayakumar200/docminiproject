package com.doc.doctorpat.mapper;

import com.doc.doctorpat.dto.DoctorDTO;
import com.doc.doctorpat.entity.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {
    public DoctorDTO mapToDoctorDTO(Doctor doctor) {
        DoctorDTO dto = new DoctorDTO();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setSpeciality(doctor.getSpeciality());

        return dto;
    }

    public Doctor mapToDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setId(doctorDTO.getId());
        doctor.setName(doctorDTO.getName());
        doctor.setSpeciality(doctorDTO.getSpeciality());

        return doctor;
    }
}


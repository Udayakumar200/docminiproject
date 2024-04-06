package com.doc.doctorpat.service.impl;

import com.doc.doctorpat.dto.DoctorDTO;
import com.doc.doctorpat.entity.Doctor;
import com.doc.doctorpat.mapper.DoctorMapper;
import com.doc.doctorpat.repo.DoctorRepo;
import com.doc.doctorpat.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepo doctorRepository;
    private final DoctorMapper doctorMapper;

    @Autowired
    public DoctorServiceImpl(DoctorRepo doctorRepository,DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }
    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);

    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public DoctorDTO addDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setId(doctorDTO.getId());
        doctor.setName(doctorDTO.getName());
        doctor.setSpeciality(doctorDTO.getSpeciality());
        Doctor savedDoctor = doctorRepository.save(doctor);
        return doctorMapper.mapToDoctorDTO(savedDoctor);
    }
}

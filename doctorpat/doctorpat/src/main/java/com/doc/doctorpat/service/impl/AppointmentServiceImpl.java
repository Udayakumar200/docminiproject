package com.doc.doctorpat.service.impl;

import com.doc.doctorpat.dto.AppointmentDTO;
import com.doc.doctorpat.entity.Appointment;
import com.doc.doctorpat.entity.Doctor;
import com.doc.doctorpat.execpt.ResourceNotFoundException;
import com.doc.doctorpat.mapper.AppointmentMapper;
import com.doc.doctorpat.repo.AppointmentRepo;
import com.doc.doctorpat.repo.DoctorRepo;
import com.doc.doctorpat.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {


    private final AppointmentRepo appointmentRepo;
    private final DoctorRepo doctorRepo;
    private final AppointmentMapper appointmentMapper;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepo appointmentRepo, DoctorRepo doctorRepo, AppointmentMapper appointmentMapper) {
        this.appointmentRepo = appointmentRepo;
        this.doctorRepo = doctorRepo;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public List<AppointmentDTO> getAllAppointment() {
        List<Appointment> appointments = appointmentRepo.findAll();
        return appointments.stream()
                .map(appointmentMapper::mapToAppointmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDTO bookAppointment(Long doctorId, Long patientId, LocalDateTime appointmentDateTime) {
        Doctor doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + doctorId));

        if (appointmentRepo.existsByDoctorAndAppointmentDateTime(doctor, appointmentDateTime)) {
            throw new ResourceNotFoundException("Appointment slot is already booked");
        }

        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setAppointmentDateTime(appointmentDateTime);

        Appointment savedAppointment = appointmentRepo.save(appointment);
        return appointmentMapper.mapToAppointmentDTO(savedAppointment);
    }

    }





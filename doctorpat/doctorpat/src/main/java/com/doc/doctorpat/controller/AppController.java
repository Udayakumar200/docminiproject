package com.doc.doctorpat.controller;

import com.doc.doctorpat.dto.AppointmentDTO;
import com.doc.doctorpat.dto.DoctorDTO;
import com.doc.doctorpat.dto.MedicationDTO;
import com.doc.doctorpat.dto.PatientDTO;
import com.doc.doctorpat.entity.Appointment;
import com.doc.doctorpat.mapper.AppointmentMapper;
import com.doc.doctorpat.service.AppointmentService;
import com.doc.doctorpat.service.DoctorService;
import com.doc.doctorpat.service.MedicationService;
import com.doc.doctorpat.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/patient")
public class AppController {
    private final AppointmentService appointmentService;
    private final PatientService patientService;
    private final MedicationService medicationService;
    private final AppointmentMapper appointmentMapper;
    private final DoctorService doctorService;


    @Autowired
    public AppController(AppointmentService appointmentService,
                         PatientService patientService,
                         MedicationService medicationService,
                         AppointmentMapper appointmentMapper,
    DoctorService doctorService) {
        this.appointmentService = appointmentService;
        this.patientService = patientService;
        this.medicationService = medicationService;
        this.appointmentMapper = appointmentMapper;
        this.doctorService  = doctorService;
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> addDoctor(@RequestBody DoctorDTO doctorDTO) {
        DoctorDTO addedDoctor = doctorService.addDoctor(doctorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedDoctor);
    }
    // Endpoint for booking an appointment
    @PostMapping("/appointments")
    public ResponseEntity<AppointmentDTO> bookAppointment(@RequestParam Long doctorId,
                                                          @RequestParam Long patientId,
                                                          @RequestParam LocalDateTime appointmentDateTime) {
        AppointmentDTO createdAppointmentDTO = appointmentService.bookAppointment(doctorId, patientId, appointmentDateTime);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAppointmentDTO);
    }


    // Endpoint for patient login
    @PostMapping("/login")
    public ResponseEntity<PatientDTO> login(@RequestParam String email, @RequestParam String password) {
        PatientDTO patient = patientService.login(email, password);
        return ResponseEntity.ok(patient);
    }

    // Endpoint for checking medication
    @GetMapping("/medications/{medicationId}")
    public ResponseEntity<MedicationDTO> checkMedic(@PathVariable Long medicationId) {
        MedicationDTO medication = medicationService.viewmedic(medicationId);
        return ResponseEntity.ok(medication);
    }

    // Endpoint for booking medication
    @PostMapping("/medications")
    public ResponseEntity<MedicationDTO> bookMedic(@RequestBody MedicationDTO medicationDTO) {
        MedicationDTO newMedication = medicationService.createmedic(medicationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMedication);
    }

    // Endpoint for updating medication
    @PutMapping("/medications/{medicationId}")
    public ResponseEntity<MedicationDTO> updateMedic(@PathVariable Long medicationId,
                                                     @RequestBody MedicationDTO updatedMedicationDTO) {
        MedicationDTO updatedMedication = medicationService.updatemedic(medicationId, updatedMedicationDTO);
        if (updatedMedication != null) {
            return ResponseEntity.ok(updatedMedication);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint for deleting medication
    @DeleteMapping("/medications/{medicationId}")
    public ResponseEntity<Void> deleteMedication(@PathVariable Long medicationId) {
        medicationService.deletemedic(medicationId);
        return ResponseEntity.noContent().build();
    }

}
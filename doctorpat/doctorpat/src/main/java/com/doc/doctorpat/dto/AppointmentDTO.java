package com.doc.doctorpat.dto;

import com.doc.doctorpat.entity.Doctor;
import com.doc.doctorpat.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {
    private Long id;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime appointmentDateTime;


}


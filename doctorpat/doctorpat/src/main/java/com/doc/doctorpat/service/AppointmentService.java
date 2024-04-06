package com.doc.doctorpat.service;

import com.doc.doctorpat.dto.AppointmentDTO;


import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {
    List<AppointmentDTO> getAllAppointment();

    AppointmentDTO bookAppointment(Long doctorId, Long patientId, LocalDateTime appointmentDateTime);

}

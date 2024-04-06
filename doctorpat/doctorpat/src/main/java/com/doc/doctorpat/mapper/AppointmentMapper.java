package com.doc.doctorpat.mapper;

import com.doc.doctorpat.dto.AppointmentDTO;
import com.doc.doctorpat.entity.Appointment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    public AppointmentDTO mapToAppointmentDTO(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(appointment.getId());
        dto.setPatient(appointment.getPatient());
        dto.setDoctor(appointment.getDoctor());
        dto.setAppointmentDateTime(appointment.getAppointmentDateTime());
        return dto;
    }
    public Appointment maptoAppointment(AppointmentDTO dto) {
        Appointment appointment = new Appointment();
        appointment.setId(dto.getId());
        appointment.setPatient(dto.getPatient());
        appointment.setDoctor(dto.getDoctor());
        appointment.setAppointmentDateTime(dto.getAppointmentDateTime());
        return appointment;
    }
}

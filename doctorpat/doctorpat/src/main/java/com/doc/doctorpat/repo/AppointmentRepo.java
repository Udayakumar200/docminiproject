package com.doc.doctorpat.repo;

import com.doc.doctorpat.entity.Appointment;
import com.doc.doctorpat.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;


public interface AppointmentRepo extends JpaRepository<Appointment ,Long> {
    boolean existsByDoctorAndAppointmentDateTime(Doctor doctor, LocalDateTime appointmentDateTime);

}

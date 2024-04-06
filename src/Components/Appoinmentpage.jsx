import React, { useState, useEffect } from 'react';
import { fetchAppointments, bookAppointment } from '../Services/Appservice'; 

const AppointmentsPage = () => {
  const [appointments, setAppointments] = useState([]);
  const [showBookingForm, setShowBookingForm] = useState(false);
  const [doctorId, setDoctorId] = useState('');
  const [doctorName, setDoctorName] = useState('');
  const [appointmentDate, setAppointmentDate] = useState('');
  const [appointmentTime, setAppointmentTime] = useState('');

  const handleBookAppointment = () => {
    const appointmentDateTime = new Date(`${appointmentDate} ${appointmentTime}`);
    bookAppointment({ doctorId, doctorName, appointmentDateTime })
      .then(response => {
        console.log('Appointment booked successfully:', response.data);
        fetchAppointmentsData();
        setDoctorId('');
        setDoctorName('');
        setAppointmentDate('');
        setAppointmentTime('');
        setShowBookingForm(false);
      })
      .catch(error => {
        console.error('Error booking appointment:', error);
      });
  };

  const fetchAppointmentsData = () => {
    fetchAppointments()
      .then(response => {
        setAppointments(response.data);
      })
      .catch(error => {
        console.error('Error fetching appointments:', error);
      });
  };

  useEffect(() => {
    fetchAppointmentsData();
  }, []);

  return (
    <div className="container mt-5">
      <h2 className="text-center mb-4">Book Appointments</h2>
      {showBookingForm ? (
        <div className="row mb-3">
          <div className="col-md-4">
            <input
              type="text"
              className="form-control"
              placeholder="Doctor ID"
              value={doctorId}
              onChange={e => setDoctorId(e.target.value)}
            />
          </div>
          <div className="col-md-4">
            <input
              type="text"
              className="form-control"
              placeholder="Doctor Name"
              value={doctorName}
              onChange={e => setDoctorName(e.target.value)}
            />
          </div>
          <div className="col-md-4">
            <input
              type="date"
              className="form-control"
              placeholder="Date"
              value={appointmentDate}
              onChange={e => setAppointmentDate(e.target.value)}
            />
          </div>
          <br /> <br />
          <div className="col-md-4">
            <input
              type="time"
              className="form-control"
              placeholder="Time"
              value={appointmentTime}
              onChange={e => setAppointmentTime(e.target.value)}
            />
          </div>
          <div className="col-md-12 mt-3">
            <button className="btn btn-primary" onClick={handleBookAppointment}>Book Appointment</button>
          </div>
        </div>
      ) : (
        <button className="btn btn-primary mb-3" onClick={() => setShowBookingForm(true)}>Book Appointment</button>
      )}
      <div className="row">
        {appointments.map(appointment => (
          <div key={appointment.id} className="col-md-4 mb-3">
            <div className="card">
              <div className="card-body">
                <h5 className="card-title">{appointment.doctor.name}</h5>
                <p className="card-text mb-3">Time: {new Date(appointment.appointmentDateTime).toLocaleString()}</p>
                {appointment.patient ? (
                  <p className="card-text">Patient: {appointment.patient.name}</p>
                ) : (
                  <p className="text-muted">Not booked</p>
                )}
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default AppointmentsPage;

import axios from 'axios';

const REST_API_BASE_URL = 'http://localhost:8080/api/patient'; // Your REST API base URL

const registerPatient = async (formData) => {
    try {
      const response = await axios.post(`${REST_API_BASE_URL}/patient/register`, formData);
      return response.data;
    } catch (error) {
      throw error;
    }
  };
  
  export { registerPatient };


const fetchAppointments = () => axios.get(`${REST_API_BASE_URL}/appointments`);
const bookAppointment = (appointmentData) => axios.post(`${REST_API_BASE_URL}/appointments`, appointmentData);

const fetchMedications = async () => {
  try {
    const response = await axios.get(`${REST_API_BASE_URL}/medications`);
    return response.data;
  } catch (error) {
    throw error;
  }
};

const addMedication = async (medicationData) => {
  try {
    const response = await axios.post(`${REST_API_BASE_URL}/medications`, medicationData);
    return response.data;
  } catch (error) {
    throw error;
  }
};

const updateMedication = async (id, medicationData) => {
  try {
    const response = await axios.put(`${REST_API_BASE_URL}/medications/${id}`, medicationData);
    return response.data;
  } catch (error) {
    throw error;
  }
};

const deleteMedication = async (id) => {
  try {
    await axios.delete(`${REST_API_BASE_URL}/medications/${id}`);
  } catch (error) {
    throw error;
  }
};

export { fetchAppointments, bookAppointment, fetchMedications, addMedication, updateMedication, deleteMedication };

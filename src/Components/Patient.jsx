import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { registerPatient } from '../Services/Appservice';

const Patient = () => {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    history: '',
    password: '',
  });
  
  const navigate = useNavigate();
  
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const data = await registerPatient(formData); 
      console.log(data);
    } catch (error) {
      console.error(error);
    }
    // Navigate to the "Option" component
    navigate('/op');
  };

  return (
    <div className="d-flex justify-content-center align-items-center vh-10">
      <div className="container">
        <br /> <br />
        <form onSubmit={handleSubmit} className="p-4 border rounded">
          <div className="mb-3">
            <label htmlFor="name" className="form-label">Name</label>
            <input
              type="text"
              name="name"
              value={formData.name}
              onChange={handleChange}
              className="form-control"
              id="name"
              placeholder="Enter your name"
              required
            />
          </div>
          <div className="mb-3">
            <label htmlFor="email" className="form-label">Email</label>
            <input
              type="email"
              name="email"
              value={formData.email}
              onChange={handleChange}
              className="form-control"
              id="email"
              placeholder="Enter your email"
              required
            />
          </div>
          <div className="mb-3">
            <label htmlFor="history" className="form-label">Medical History</label>
            <textarea
              name="history"
              value={formData.history}
              onChange={handleChange}
              className="form-control"
              id="history"
              placeholder="Enter your medical history"
              required
            />
          </div>
          <div className="mb-3">
            <label htmlFor="password" className="form-label">Password</label>
            <input
              type="password"
              name="password"
              value={formData.password}
              onChange={handleChange}
              className="form-control"
              id="password"
              placeholder="Enter your password"
              required
            />
          </div>
          <button type="submit" className="btn btn-primary">Register</button>
        </form>
      </div>
    </div>
  );
};

export default Patient;

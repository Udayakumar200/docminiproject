import React from 'react';
import { Link } from 'react-router-dom';

const Option = () => {
  return (
    <div className="d-flex justify-content-center align-items-center vh-100">
      <div>
        <Link to="/ad" className="btn btn-primary me-2">Book Appointment</Link>
        <Link to="/adi" className="btn btn-primary">Medication</Link>
      </div>
    </div>
  );
};

export default Option;

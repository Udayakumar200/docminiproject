import React, { useState, useEffect } from 'react';
import { fetchMedications ,addMedication,deleteMedication,updateMedication} from '../Services/Appservice';
const MedicationPage = () => {
  const [medications, setMedications] = useState([]);
  const [name, setName] = useState('');
  const [dosage, setDosage] = useState('');
  const [editingId, setEditingId] = useState(null);

  useEffect(() => {
    fetchMedications()
      .then((data) => setMedications(data))
      .catch((error) => console.error('Error fetching medications:', error));

  }, []);

  const addMedication = () => {
    // Add new medication
    const newMedication = { name, dosage };
    setMedications([...medications, newMedication]);
    setName('');
    setDosage('');
  };

  const deleteMedication = (id) => {
    // Delete medication by id
    const updatedMedications = medications.filter((medication) => medication.id !== id);
    setMedications(updatedMedications);
  };

  const editMedication = (id) => {
    // Set editingId to enable editing mode
    setEditingId(id);
    const medicationToEdit = medications.find((medication) => medication.id === id);
    setName(medicationToEdit.name);
    setDosage(medicationToEdit.dosage);
  };

  const updateMedication = () => {
    // Update medication
    const updatedMedications = medications.map((medication) => {
      if (medication.id === editingId) {
        return { ...medication, name, dosage };
      }
      return medication;
    });
    setMedications(updatedMedications);
    setName('');
    setDosage('');
    setEditingId(null);
  };

  return (
    <div className="container">
      <h2>Medication Page</h2>
      <div className="mb-3">
        <input
          type="text"
          className="form-control"
          placeholder="Medication Name"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
      </div>
      <div className="mb-3">
        <input
          type="text"
          className="form-control"
          placeholder="Dosage"
          value={dosage}
          onChange={(e) => setDosage(e.target.value)}
        />
      </div>
      <div>
        {editingId === null ? (
          <button className="btn btn-primary me-2" onClick={addMedication}>Add Medication</button>
        ) : (
          <button className="btn btn-primary me-2" onClick={updateMedication}>Update Medication</button>
        )}
        <button className="btn btn-secondary" onClick={() => { setName(''); setDosage(''); setEditingId(null); }}>Clear</button>
      </div>
      <ul className="list-group mt-3">
        {medications.map((medication) => (
          <li key={medication.id} className="list-group-item d-flex justify-content-between align-items-center">
            {medication.name} - {medication.dosage}
            <div>
              <button className="btn btn-danger me-2" onClick={() => deleteMedication(medication.id)}>Delete</button>
              <button className="btn btn-primary" onClick={() => editMedication(medication.id)}>Edit</button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default MedicationPage;

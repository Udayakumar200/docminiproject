
import './App.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Patient from './Components/Patient'
import Headerfile from './Components/Headerfile';
import Option from './Components/Option';

import AppointmentsPage from './Components/Appoinmentpage';
import MedicationPage from './Components/MedicationPage';

function App() {


  return (
    <>
    <BrowserRouter>
    <Headerfile />
    <Routes>
<Route path="/" element={<Patient />} />

<Route path="/opt" element={<Option />} />
<Route path="/ad" element={<AppointmentsPage />} />

<Route path="/adi" element={<MedicationPage />} />
    </Routes>
    </BrowserRouter>

 
    </>
  )
}

export default App

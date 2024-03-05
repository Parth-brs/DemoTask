package com.example.demo.Service;

import com.example.demo.Model.Patient;

public interface patientService {

    Patient addPatient(Patient patient);

    Patient getPatientById(String id);


}

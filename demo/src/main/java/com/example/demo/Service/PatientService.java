package com.example.demo.Service;

import com.example.demo.Model.Patient;

import java.util.UUID;

public interface PatientService {

    Patient addPatient(Patient patient);

    Patient getPatientById(Integer id);


}

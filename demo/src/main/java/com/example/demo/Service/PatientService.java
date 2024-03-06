package com.example.demo.Service;

import com.example.demo.Exception.PatientException;
import com.example.demo.Model.Patient;

import java.util.UUID;

public interface PatientService {

    Patient addPatient(Patient patient) throws PatientException;

    Patient getPatientById(Integer id) throws PatientException;


}

package com.example.demo.Service;


import com.example.demo.Model.Patient;
import com.example.demo.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PatientServiceImplementation implements PatientService {

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);

    }

    @Override
    public Patient getPatientById(String id) {
        return patientRepository.findById(id).get();

    }
}

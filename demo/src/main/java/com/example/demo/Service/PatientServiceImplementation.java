package com.example.demo.Service;



import com.example.demo.Exception.PatientException;
import com.example.demo.Model.Patient;
import com.example.demo.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service

public class PatientServiceImplementation implements PatientService {

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public Patient addPatient(Patient patient)  throws PatientException {
        return patientRepository.save(patient);

    }

    @Override
    public Patient getPatientById(Integer id)  throws PatientException{
        return patientRepository.findById(id).orElse(null);
    }
}

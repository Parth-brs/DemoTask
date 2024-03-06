package com.example.demo.Repository;

import com.example.demo.Model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    void testSaveAndRetrievePatient() {

        Patient patient = new Patient();
        patient.setName("John Doe");
        patient.setAmount("30000");


        Patient savedPatient = patientRepository.save(patient);

        Patient retrievedPatient = patientRepository.findById(savedPatient.getId()).orElse(null);

        assert retrievedPatient != null;

        assertEquals(patient.getName(), retrievedPatient.getName());
        assertEquals(patient.getAmount(), retrievedPatient.getAmount());
    }



}
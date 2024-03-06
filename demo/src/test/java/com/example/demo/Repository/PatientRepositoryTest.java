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
        // Create a new Patient object
        Patient patient = new Patient();
        patient.setName("John Doe");
        patient.setAmount("30000");

        // Save the patient using the repository
        Patient savedPatient = patientRepository.save(patient);

        // Retrieve the saved patient from the database using its ID
        Patient retrievedPatient = patientRepository.findById(savedPatient.getId()).orElse(null);

        // Assert that the retrieved patient is not null
        assert retrievedPatient != null;

        // Assert that the saved patient's attributes match the retrieved patient's attributes
        assertEquals(patient.getName(), retrievedPatient.getName());
        assertEquals(patient.getAmount(), retrievedPatient.getAmount());
    }

}
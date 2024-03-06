package com.example.demo.Service;

import com.example.demo.Exception.PatientException;
import com.example.demo.Model.Patient;
import com.example.demo.Repository.PatientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)

@SpringBootTest
class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientServiceImplementation patientService;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {

        patientRepository.deleteAll();
    }

    @Test
    void addPatient() throws PatientException {
        Patient patient = new Patient();
        patient.setId(1);
        patient.setName("John Doe");
        patient.setAmount("30000");

        when(patientRepository.save(any(Patient.class))).thenReturn(patient);

        Patient result = patientService.addPatient(patient);

        assertEquals(patient, result);
    }

    @Test
    void getPatientById() throws PatientException {
        Patient patient = new Patient();
        patient.setId(1);
        patient.setName("John Doe");
        patient.setAmount("30000");

        when(patientRepository.findById(1)).thenReturn(Optional.of(patient));

        Patient result = patientService.getPatientById(1);

        assertEquals(patient.getId(), result.getId());
        assertEquals(patient.getName(), result.getName());
        assertEquals(patient.getAmount(), result.getAmount());
        assertEquals(patient.getCity(), result.getCity());
    }
}
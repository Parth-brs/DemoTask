package com.example.demo.Controller;

import com.example.demo.Model.Patient;
import com.example.demo.Service.PatientService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PatientControllerTest {

    @Mock
    private PatientService patientService;

    @InjectMocks
    private PatientController patientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addPatient() {
        Patient patient = new Patient();
        patient.setId(1);
        patient.setName("Parth");
        patient.setAmount("30000");


        when(patientService.addPatient(any(Patient.class))).thenReturn(patient);


        ResponseEntity<Patient> responseEntity = patientController.addPatient(patient);


        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());

        assertEquals(patient, responseEntity.getBody());
    }

    @Test
    void getPatientById() {
        Patient patient = new Patient();
        patient.setId(1);
        patient.setName("Kabir");
        patient.setAmount("30000");


        when(patientService.getPatientById(1)).thenReturn(patient);


        ResponseEntity<?> response = patientController.getPatientById(1);


        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(patient, response.getBody());
    }

    @Test
    void getTest() {
    }
}
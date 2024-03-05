package com.example.demo.Controller;

import com.example.demo.Model.Patient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Service.patientService;

@RestController
@RequestMapping("/patient")
@CrossOrigin("*")
public class PatientController {

    @Autowired
    private patientService PatientService;

    @PostMapping("/addPatient")
    public ResponseEntity<String> addPatient(@RequestBody Patient patient) {
        Patient addedPatient = PatientService.addPatient(patient);
        if (addedPatient != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Patient added successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add patient");
        }
    }

    @GetMapping("/getPatient/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable String id) {
        Patient patient = PatientService.getPatientById(id);
        if (patient != null) {
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/test")
    public String getTest() {
        return "Running";
    }
}

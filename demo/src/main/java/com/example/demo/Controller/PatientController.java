package com.example.demo.Controller;

import com.example.demo.Exception.PatientException;
import com.example.demo.Model.Patient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private com.example.demo.Service.PatientService PatientService;

    @PostMapping("/addPatient")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient)  {
        try{
            Patient addedPatient = PatientService.addPatient(patient);
            if (addedPatient != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(addedPatient);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(addedPatient);
            }
        }
        catch (PatientException patientException) {
            patientException.getMessage();
        }
        return null;
    }

    @GetMapping("/getPatient/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable Integer id) {
        try{
            Patient patient = PatientService.getPatientById(id);
            if (patient != null) {
                return new ResponseEntity<>(patient,HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Data Not Found",HttpStatus.NOT_FOUND);
            }
        }
        catch (PatientException patientException) {
            patientException.getMessage();
        }
        return null;
    }


    @GetMapping("/test")
    public String getTest() {
        return "Running";
    }
}

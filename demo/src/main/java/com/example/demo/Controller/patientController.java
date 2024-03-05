package com.example.demo.Controller;


import com.example.demo.Model.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
@CrossOrigin("*")
public class patientController {


    @PostMapping("/addPatient")
    public ResponseEntity<String> addPatient(@RequestBody Patient student){
        //logic for add patient
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/getPatient/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable String id){
        //logic to get patient
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/test")
    public String getTest(){

        return "Running";
    }



}


package org.example.demo.controller;

import org.example.demo.dto.PatientDto;
import org.example.demo.exception.ResourceNotFoundException;
import org.example.demo.models.Patient;
import org.example.demo.service.PatientService;
import org.example.demo.util.DtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto){
        System.out.println("Creating patient"); // LOG: Request received
        Patient patient = DtoConverter.toPatient(patientDto);  // Convert DTO to Entity (using DtoConverter)
        Patient createdPatient = patientService.createPatient(patient); // Call Service Layer
        if (createdPatient != null) {
            return new ResponseEntity<>(DtoConverter.toPatientDto(createdPatient), HttpStatus.CREATED); // Convert Entity back to DTO for response
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatient(){
        System.out.println("Fetching the patients");
        List<Patient> patients = patientService.getAllPatients();
        if (patients != null) {
            List<PatientDto> patientDtos = patients.stream()
                    .map(DtoConverter::toPatientDto)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(patientDtos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id){
        System.out.println("Fetching the patient by ID");
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            return new ResponseEntity<>(DtoConverter.toPatientDto(patient), HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Patient not found with id: " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable Long id, @RequestBody PatientDto patientDto){
        System.out.println("Updating the patient by ID");
        Patient patient = DtoConverter.toPatient(patientDto);
        Patient updatedPatient = patientService.updatePatient(id, patient);
        if (updatedPatient != null) {
            return new ResponseEntity<>(DtoConverter.toPatientDto(updatedPatient), HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Patient not found with id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id){
        System.out.println("Deleting the patient by ID");
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            patientService.deletePatient(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        throw new ResourceNotFoundException("Patient not found with id: " + id);
    }

}

package org.example.demo.controller;

import org.example.demo.dto.DoctorDto;
import org.example.demo.exception.ResourceNotFoundException;
import org.example.demo.models.Doctor;
import org.example.demo.service.DoctorService;
import org.example.demo.util.DtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto){
        System.out.println("Creating Doctor");
        Doctor doctor = DtoConverter.toDoctor(doctorDto);
        Doctor createdDoctor = doctorService.createDoctor(doctor);
        if (createdDoctor != null) {
            return new ResponseEntity<>(DtoConverter.toDoctorDto(createdDoctor), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctor(){
        System.out.println("Fetching the Doctors");
        List<Doctor> doctors = doctorService.getAllDoctors();
        if (doctors != null) {
            List<DoctorDto> doctorDtos = doctors.stream()
                    .map(DtoConverter::toDoctorDto)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(doctorDtos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable long id){
        System.out.println("Fetching the Doctor by ID");
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor != null) {
            return new ResponseEntity<>(DtoConverter.toDoctorDto(doctor), HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Doctor not found with id: " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable long id, @RequestBody DoctorDto doctorDto){
        System.out.println("Updating the Doctor by ID");
        Doctor doctor = DtoConverter.toDoctor(doctorDto);
        Doctor updatedDoctor = doctorService.updateDoctor(id, doctor);
        if (updatedDoctor != null) {
            return new ResponseEntity<>(DtoConverter.toDoctorDto(updatedDoctor), HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Doctor not found with id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable long id){
        System.out.println("Deleting the Doctor by ID");
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor != null) {
            doctorService.deleteDoctor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        throw new ResourceNotFoundException("Doctor not found with id: " + id);
    }

}

package org.example.demo.controller;

import org.example.demo.dto.AppointmentDto;
import org.example.demo.exception.ResourceNotFoundException;
import org.example.demo.models.Appointment;
import org.example.demo.service.AppointmentService;
import org.example.demo.util.DtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto){
        System.out.println("Creating Appointment");
        System.out.println("Received DTO: " + appointmentDto.toString());
        
        Appointment appointment = DtoConverter.toAppointment(appointmentDto);
        System.out.println("Converted to Entity: " + appointment.toString());
        
        Appointment createdAppointment = appointmentService.createAppointment(appointment);
        if (createdAppointment != null) {
            AppointmentDto responseDto = DtoConverter.toAppointmentDto(createdAppointment);
            System.out.println("Response DTO: " + responseDto.toString());
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointment(){
        System.out.println("Fetching the Appointments");
        List<Appointment> appointments = appointmentService.getAllAppointments();
        if (appointments != null) {
            List<AppointmentDto> appointmentDtos = appointments.stream()
                    .map(DtoConverter::toAppointmentDto)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(appointmentDtos, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long id){
        System.out.println("Fetching the Appointment by ID");
        Appointment appointment = appointmentService.getAppointmentById(id);
        if (appointment != null) {
            return new ResponseEntity<>(DtoConverter.toAppointmentDto(appointment), HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Appointment not found with id: " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable Long id, @RequestBody AppointmentDto appointmentDto){
        System.out.println("Updating the Appointment by ID");
        Appointment appointment = DtoConverter.toAppointment(appointmentDto);
        Appointment updatedAppointment = appointmentService.updateAppointment(id, appointment);
        if (updatedAppointment != null) {
            return new ResponseEntity<>(DtoConverter.toAppointmentDto(updatedAppointment), HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Appointment not found with id: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id){
        System.out.println("Deleting the Appointment by ID");
        Appointment appointment = appointmentService.getAppointmentById(id);
        if (appointment != null) {
            appointmentService.deleteAppointment(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        throw new ResourceNotFoundException("Appointment not found with id: " + id);
    }

}

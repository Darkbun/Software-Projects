package org.example.demo.service;

import org.example.demo.models.Appointment;
import org.example.demo.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment) {
        try{
            System.out.println("Creating appointment with data:");
            System.out.println("Patient ID: " + appointment.getPatientId());
            System.out.println("Doctor ID: " + appointment.getDoctorId());
            System.out.println("Date: " + appointment.getDate());
            
            Appointment savedAppointment = appointmentRepository.save(appointment);
            System.out.println("Appointment saved successfully with ID: " + savedAppointment.getId());
            return savedAppointment;
        }catch(Exception e){
            System.out.println("Error creating appointment: "+e.getMessage());
            e.printStackTrace(); // Print full stack trace for debugging
            return null;
        }
    }

    public List<Appointment> getAllAppointments() {
        try{
            return appointmentRepository.findAll();
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
            return null;
        }
    }

    public Appointment getAppointmentById(Long id) {
        try{
            return appointmentRepository.findById(id).orElse(null);
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
            return null;
        }
    }

    public Appointment updateAppointment(Long id, Appointment appointment){
        try{
            Appointment existingAppointment = appointmentRepository.findById(id).orElse(null);
            if (existingAppointment != null) {
                existingAppointment.setPatientId(appointment.getPatientId());
                existingAppointment.setDoctorId(appointment.getDoctorId());
                existingAppointment.setDate(appointment.getDate());
                return appointmentRepository.save(existingAppointment);
            }
            return null;
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
            return null;
        }
    }

    public void deleteAppointment(Long id) {
        try{
            appointmentRepository.deleteById(id);
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
        }
    }
}

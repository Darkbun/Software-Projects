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
            return appointmentRepository.save(appointment);
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
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

    public Appointment getAppointmentById(long id) {
        try{
            return appointmentRepository.findById(id).orElse(null);
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
            return null;
        }
    }

    public Appointment updateAppointment(long id, Appointment appointment){
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

    public void deleteAppointment(long id) {
        try{
            appointmentRepository.deleteById(id);
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
        }
    }
}

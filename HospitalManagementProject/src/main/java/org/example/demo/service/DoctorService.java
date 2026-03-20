package org.example.demo.service;

import org.example.demo.models.Doctor;
import org.example.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor createDoctor(Doctor doctor) {
        try{
            return doctorRepository.save(doctor);
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
            return null;
        }
    }

    public List<Doctor> getAllDoctors() {
        try{
            return doctorRepository.findAll();
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
            return null;
        }
    }

    public Doctor getDoctorById(Long id) {
        try{
            return doctorRepository.findById(id).orElse(null);
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
            return null;
        }
    }

    public Doctor updateDoctor(Long id, Doctor doctor){
        try{
            Doctor existingDoctor = doctorRepository.findById(id).orElse(null);
            if (existingDoctor != null) {
                existingDoctor.setName(doctor.getName());
                existingDoctor.setSpeciality(doctor.getSpeciality());
                return doctorRepository.save(existingDoctor);
            }
            return null;
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
            return null;
        }
    }

    public void deleteDoctor(Long id) {
        try{
            doctorRepository.deleteById(id);
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
        }
    }
}

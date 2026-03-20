package org.example.demo.service;

import org.example.demo.models.Patient;
import org.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        try{
            return patientRepository.save(patient); // Call Repository to save to database
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage()); //LOG: Error Handling
            return null;
        }
    }

    public List<Patient> getAllPatients() {
        try{
            System.out.println("Into service layer");
            return patientRepository.findAll();
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
            return null;
        }
    }

    public Patient getPatientById(Long id) {
        try{
            return patientRepository.findById(id).orElse(null);
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
            return null;
        }
    }

    public Patient updatePatient(Long id, Patient patient){
        try{
            Patient existingPatient = patientRepository.findById(id).orElse(null);
            if (existingPatient != null) {
                existingPatient.setName(patient.getName());
                existingPatient.setGender(patient.getGender());
                existingPatient.setAge(patient.getAge());
                return patientRepository.save(existingPatient);
            }
            return null;
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
            return null;
        }
    }

    public void deletePatient(Long id) {
        try{
            System.out.println("Into service layer");
            patientRepository.deleteById(id);
        }catch(Exception e){
            System.out.println("Error message: "+e.getMessage());
        }
    }


}

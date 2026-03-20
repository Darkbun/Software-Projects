package org.example.demo.util;

import org.example.demo.dto.*;
import org.example.demo.models.*;

public class DtoConverter {

    public static PatientDto toPatientDto(Patient patient) {
        return PatientDto.builder()
                .id(patient.getId())
                .name(patient.getName())
                .gender(patient.getGender())
                .age(patient.getAge())
                .build();
    }

    public static Patient toPatient(PatientDto patientDto) {
        return Patient.builder()
                .id(patientDto.getId()) // Let JPA handle null/0 for new records
                .name(patientDto.getName())
                .gender(patientDto.getGender())
                .age(patientDto.getAge())
                .build();
    }

    public static DoctorDto toDoctorDto(Doctor doctor) {
        return DoctorDto.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .speciality(doctor.getSpeciality())
                .build();
    }

    public static Doctor toDoctor(DoctorDto doctorDto) {
        return Doctor.builder()
                .id(doctorDto.getId()) // Let JPA handle null/0 for new records
                .name(doctorDto.getName())
                .speciality(doctorDto.getSpeciality())
                .build();
    }

    public static BillDto toBillDto(Bill bill) {
        return BillDto.builder()
                .id(bill.getId())
                .patientId(bill.getPatientId())
                .doctorId(bill.getDoctorId())
                .amount(bill.getAmount())
                .status(bill.getStatus())
                .build();
    }

    public static Bill toBill(BillDto billDto) {
        System.out.println("Converting BillDto to Bill:");
        System.out.println("Input DTO: " + billDto.toString());
        
        Bill bill = Bill.builder()
                .id(billDto.getId()) // Let JPA handle null/0 for new records
                .patientId(billDto.getPatientId())
                .doctorId(billDto.getDoctorId())
                .amount(billDto.getAmount())
                .status(billDto.getStatus())
                .build();
        
        System.out.println("Converted Entity: " + bill.toString());
        return bill;
    }

    public static AppointmentDto toAppointmentDto(Appointment appointment) {
        return AppointmentDto.builder()
                .id(appointment.getId())
                .patientId(appointment.getPatientId())
                .doctorId(appointment.getDoctorId())
                .date(DateUtil.formatDateTime(appointment.getDate()))
                .build();
    }

    public static Appointment toAppointment(AppointmentDto appointmentDto) {
        System.out.println("Converting AppointmentDto to Appointment:");
        System.out.println("Input DTO: " + appointmentDto.toString());
        
        Appointment appointment = Appointment.builder()
                .id(appointmentDto.getId()) // Let JPA handle null/0 for new records
                .patientId(appointmentDto.getPatientId())
                .doctorId(appointmentDto.getDoctorId())
                .date(DateUtil.parseDateTime(appointmentDto.getDate()))
                .build();
        
        System.out.println("Converted Entity: " + appointment.toString());
        return appointment;
    }
}

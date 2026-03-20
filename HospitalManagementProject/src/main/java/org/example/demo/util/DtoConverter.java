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
                .id(patientDto.getId() != null ? patientDto.getId() : 0)
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
                .id(doctorDto.getId() != null ? doctorDto.getId() : 0)
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
        return Bill.builder()
                .id(billDto.getId() != null ? billDto.getId() : 0)
                .patientId(billDto.getPatientId() != null ? billDto.getPatientId() : 0)
                .doctorId(billDto.getDoctorId() != null ? billDto.getDoctorId() : 0)
                .amount(billDto.getAmount())
                .status(billDto.getStatus())
                .build();
    }

    public static AppointmentDto toAppointmentDto(Appointment appointment) {
        return AppointmentDto.builder()
                .id(appointment.getId())
                .patientId(appointment.getPatientId())
                .doctorId(appointment.getDoctorId())
                .date(appointment.getDate())
                .build();
    }

    public static Appointment toAppointment(AppointmentDto appointmentDto) {
        return Appointment.builder()
                .id(appointmentDto.getId() != null ? appointmentDto.getId() : 0)
                .patientId(appointmentDto.getPatientId() != null ? appointmentDto.getPatientId() : 0)
                .doctorId(appointmentDto.getDoctorId() != null ? appointmentDto.getDoctorId() : 0)
                .date(appointmentDto.getDate())
                .build();
    }
}

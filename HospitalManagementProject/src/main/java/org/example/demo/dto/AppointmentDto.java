package org.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppointmentDto {
    private Long id;
    
    @JsonProperty("patientId")
    private Long patientId;
    
    @JsonProperty("doctorId")
    private Long doctorId;
    
    @JsonProperty("date")
    private String date; // Formatted date string for API
}

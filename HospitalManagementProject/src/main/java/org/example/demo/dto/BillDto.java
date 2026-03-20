package org.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillDto {
    private Long id;
    
    @JsonProperty("patientId")
    private Long patientId;
    
    @JsonProperty("doctorId")
    private Long doctorId;
    
    @JsonProperty("amount")
    private double amount;
    
    @JsonProperty("status")
    private String status;
}

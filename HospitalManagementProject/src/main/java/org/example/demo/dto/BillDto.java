package org.example.demo.dto;

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
    private Long patientId;
    private Long doctorId;
    private double amount;
    private String status;
}

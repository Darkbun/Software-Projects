package com.example.calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalculationResponse {
    private double a;
    private double b;
    private String operation;
    private Double result;
    private String status;
    private String error;


//    public CalculationResponse(double a, double b, String operation, Double result, String status, String error){
//        this.a = a;
//        this.b = b;
//        this.operation = operation;
//        this.result = result;
//        this.status = status;
//        this.error = error;
//    }
//
//    public double getA() {
//        return a;
//    }
//
//    public void setA(double a) {
//        this.a = a;
//    }
//
//    public double getB() {
//        return b;
//    }
//
//    public void setB(double b) {
//        this.b = b;
//    }
//
//    public String getOperation() {
//        return operation;
//    }
//
//    public void setOperation(String operation) {
//        this.operation = operation;
//    }
//
//    public Double getResult() {
//        return result;
//    }
//
//    public void setResult(double result) {
//        this.result = result;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getError() {
//        return error;
//    }
//
//    public void setError(String error) {
//        this.error = error;
//    }
}

package com.example.calculator.controller;

import com.example.calculator.dto.CalculationResponse;
import com.example.calculator.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
@Slf4j
public class CalculatorController {

    private final CalculatorService calculatorservice;

    public CalculatorController(CalculatorService calculatorservice) {
        this.calculatorservice = calculatorservice;
    }

    @GetMapping("/add")
    public CalculationResponse add(double a, double b) {
        double result = calculatorservice.add(a, b);
        return new CalculationResponse(a, b, "add", result, "success", null);
    }

    @GetMapping("/subtract")
    public CalculationResponse subtract(double a, double b) {
        double result = calculatorservice.subtract(a, b);
        return new CalculationResponse(a, b, "subtract", result, "success", null);
    }

    @GetMapping("/multiply")
    public CalculationResponse multiply(double a, double b) {
        double result = calculatorservice.multiply(a, b);
        return new CalculationResponse(a, b, "multiply", result, "success", null);
    }

    @GetMapping("/divide")
    public CalculationResponse divide(double a, double b) {
        if (b == 0) {
            log.warn("error");
            return new CalculationResponse(a, b, "divide", null, "error", "Cannot divide by zero");
        }
        double result = calculatorservice.divide(a, b);
        return new CalculationResponse(a, b, "divide", result, "success", null);
    }

}

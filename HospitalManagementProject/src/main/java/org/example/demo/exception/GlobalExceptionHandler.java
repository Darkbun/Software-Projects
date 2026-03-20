package org.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(
            Map.of("error", ex.getMessage(), "status", "NOT_FOUND"),
            HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGlobalException(Exception ex) {
        return new ResponseEntity<>(
            Map.of("error", "Internal server error: " + ex.getMessage(), "status", "INTERNAL_SERVER_ERROR"),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(
            Map.of("error", ex.getMessage(), "status", "BAD_REQUEST"),
            HttpStatus.BAD_REQUEST
        );
    }
}

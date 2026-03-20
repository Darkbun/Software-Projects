package org.example.demo.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    
    public static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(formatter);
    }
    
    public static LocalDateTime parseDateTime(String dateString) {
        if (dateString == null || dateString.trim().isEmpty()) {
            System.out.println("Date string is null or empty");
            return null;
        }
        try {
            LocalDateTime parsed = LocalDateTime.parse(dateString, formatter);
            System.out.println("Successfully parsed date: " + dateString + " -> " + parsed);
            return parsed;
        } catch (Exception e) {
            System.out.println("Failed to parse date: " + dateString + ", Error: " + e.getMessage());
            System.out.println("Please use format: dd-MM-yyyy HH:mm:ss (e.g., 20-03-2026 14:30:00)");
            e.printStackTrace();
            return null;
        }
    }
    
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(formatter);
    }
}

package org.example.demo.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private static final DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    
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
            // Try ISO format first
            LocalDateTime parsed = LocalDateTime.parse(dateString, isoFormatter);
            System.out.println("Successfully parsed ISO date: " + dateString + " -> " + parsed);
            return parsed;
        } catch (Exception e1) {
            try {
                // Try custom format
                LocalDateTime parsed = LocalDateTime.parse(dateString, formatter);
                System.out.println("Successfully parsed custom date: " + dateString + " -> " + parsed);
                return parsed;
            } catch (Exception e2) {
                System.out.println("Failed to parse date: " + dateString + ", Error: " + e2.getMessage());
                e2.printStackTrace();
                return null;
            }
        }
    }
    
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(formatter);
    }
}

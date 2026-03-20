package org.example.demo.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(formatter);
    }
    
    public static LocalDateTime parseDateTime(String dateString) {
        if (dateString == null || dateString.trim().isEmpty()) {
            return null;
        }
        return LocalDateTime.parse(dateString, formatter);
    }
    
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(formatter);
    }
}

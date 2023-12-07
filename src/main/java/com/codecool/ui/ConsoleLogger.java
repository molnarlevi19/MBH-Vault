package com.codecool.ui;

import com.codecool.logger.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogger implements Logger {

    @Override
    public void logInfo(String message) {
        String formattedMessage = formatLogMessage("INFO", message);
        System.out.println(formattedMessage);
    }

    @Override
    public String logError(String message) {
        String formattedMessage = formatLogMessage("ERROR", message);
        System.err.println(formattedMessage);
        return formattedMessage;
    }

    private String formatLogMessage(String logLevel, String message) {
        LocalDateTime timestamp = LocalDateTime.now();
        String formattedTimestamp = timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return String.format("[%s] [%s] - %s", formattedTimestamp, logLevel, message);
    }
}

package com.codecool;

import com.codecool.logger.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    private String filePath;
    private Logger logger;

    public ReadFile(String filePath, Logger logger) {
        this.filePath = filePath;
        this.logger = logger;
    }

    public List<String> readDocumentContent() {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(this.filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            logger.logError("Error reading file: " + e.getMessage());
        }

        return lines;
    }

}

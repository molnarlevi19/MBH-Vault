package com.codecool;

import com.codecool.logger.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    private final String filePath;
    private final Logger logger;

    public ReadFile(String filePath, Logger logger) {
        if (filePath == null) {
            throw new IllegalArgumentException("File path cannot be null");
        }
        this.filePath = filePath;
        this.logger = logger;
    }

    public List<String> readDocumentContent() {
        List<String> lines = new ArrayList<>();

        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().trim();
                if (!data.isEmpty()) {
                    lines.add(data);
                }
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            logger.logError("An error occurred." + e.getMessage());
        }

        logger.logInfo("The read passwords: " + lines);
        return lines;
    }

}

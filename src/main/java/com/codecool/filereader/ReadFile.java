package com.codecool.filereader;

import com.codecool.logger.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The ReadFile class is responsible for reading the content of a document from a file.
 */
public class ReadFile {

    private final String filePath;
    private final Logger logger;

    /**
     * Constructs a ReadFile instance with the specified file path and logger.
     *
     * @param filePath The path to the file to be read.
     * @param logger   The logger used for logging messages.
     * @throws IllegalArgumentException If the file path is null.
     */
    public ReadFile(String filePath, Logger logger) {
        if (filePath == null) {
            throw new IllegalArgumentException("File path cannot be null");
        }
        this.filePath = filePath;
        this.logger = logger;
    }

    /**
     * Reads the content of the document from the specified file.
     *
     * @return A list of strings representing the lines of the document.
     */
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

        return lines;
    }

}

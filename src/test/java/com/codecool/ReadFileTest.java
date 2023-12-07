package com.codecool;

import com.codecool.logger.Logger;
import com.codecool.ui.ConsoleLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {

    private Logger logger;

    @BeforeEach
    void setup(){
        logger = new ConsoleLogger();
    }

    @Test
    void testReadDocumentContent_GoodPath() {
        String goodPath = "src/main/resources/input.txt";
        ReadFile readFile = new ReadFile(goodPath, logger);

        List<String> lines = readFile.readDocumentContent();

        assertNotNull(lines);
    }

    @Test
    void testReadDocumentContent_BadPath() {
        String badPath = "src/main/resources/bad_path.txt";
        ReadFile readFile = new ReadFile(badPath, logger);

        List<String> lines = readFile.readDocumentContent();

        assertNotNull(lines);
        assertTrue(lines.isEmpty());
    }

    @Test
    void testConstructor_NullFilePath() {

        assertThrows(IllegalArgumentException.class, () -> new ReadFile(null, logger));
    }

}
package com.codecool;

import com.codecool.logger.Logger;
import com.codecool.ui.ConsoleLogger;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Logger logger = new ConsoleLogger();

        String filePath = "src/main/resources/input.txt";

        ReadFile readFile = new ReadFile(filePath, logger);
        List<String> asd = readFile.readDocumentContent();

        PasswordChecker passwordChecker = new PasswordChecker(asd);
        List<String> correctPassword = passwordChecker.passwordChecker();
        logger.logInfo("The correct password(s): " + correctPassword.toString());

        logger.logInfo("The number of correct password(s): " + correctPassword.size());
    }

}

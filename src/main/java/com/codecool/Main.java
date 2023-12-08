package com.codecool;

import com.codecool.filereader.ReadFile;
import com.codecool.logger.Logger;
import com.codecool.ui.ConsoleLogger;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Logger vaultLogger = new ConsoleLogger();

        String filePath = "src/main/resources/input.txt";

        ReadFile readFile = new ReadFile(filePath, vaultLogger);
        List<String> passwordsInFile = readFile.readDocumentContent();

        PasswordChecker passwordChecker = new PasswordChecker(passwordsInFile);
        List<String> correctPassword = passwordChecker.passwordChecker();

        vaultLogger.logInfo("The read password(s): " + passwordsInFile);

        vaultLogger.logInfo("The correct password(s): " + correctPassword.toString());

        vaultLogger.logInfo("The number of correct password(s): " + correctPassword.size());
    }

}

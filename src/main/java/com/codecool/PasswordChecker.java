package com.codecool;

import java.util.*;

public class PasswordChecker {

    private static final String[] PUNCTUATION_MARKS = new String[]{"?", "!", "."};
    private List<String> passwords;

    public PasswordChecker(List<String> passwords) {
        this.passwords = passwords;
    }

    public List<String> passwordChecker(){
        List<String> correctPasswords = new ArrayList<>();

        for(String password : this.passwords){
            if(hasMoreThanOneWord(password) &&
                    hasSignAtTheEnd(password) &&
                    hasNoDuplication(password) &&
                    onlyEnglishLetters(password) &&
                    onlyLowerCaseLetters(password)
            ) {

                correctPasswords.add(password);
            }
        }

        return correctPasswords;
    }

    private boolean hasMoreThanOneWord(String password){
        return password.contains(" ");
    }

    private boolean hasSignAtTheEnd(String password) {
        for (String mark : PUNCTUATION_MARKS) {
            if (password.endsWith(mark)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasNoDuplication(String password){
        String[] splitPassword = password.split("\\W+");

        Set<String> counterDuplicates = new HashSet<>(Arrays.asList(splitPassword));

        return splitPassword.length == counterDuplicates.size();
    }

    private boolean onlyEnglishLetters(String password){
        if(hasSignAtTheEnd(password)){
            String passwordWithoutMark = password.substring(0, password.length() - 1);

            return passwordWithoutMark.matches("[a-zA-Z\\s]*");
        }

        return false;
    }

    private boolean onlyLowerCaseLetters(String password){
        return password.toLowerCase().equals(password);
    }

}

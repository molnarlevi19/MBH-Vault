package com.codecool;

import java.util.*;

/**
 * The PasswordChecker class is responsible for checking the validity of passwords based on certain criteria.
 */
public class PasswordChecker {

    private static final String[] PUNCTUATION_MARKS = new String[]{"?", "!", "."};
    private final List<String> passwords;

    /**
     * Constructs a PasswordChecker with the specified list of passwords.
     *
     * @param passwords The list of passwords to be checked.
     */
    public PasswordChecker(List<String> passwords) {
        this.passwords = passwords;
    }

    /**
     * Checks the list of passwords and returns a list of correct passwords.
     *
     * @return A list of correct passwords.
     */
    public List<String> passwordChecker(){
        List<String> correctPasswords = new ArrayList<>();

        for(String password : this.passwords){
            if(isValidPassword(password)) {

                correctPasswords.add(password);
            }
        }

        return correctPasswords;
    }

    /**
     * Checks if a password is valid based on specific criteria.
     *
     * @param password The password to be checked.
     * @return true if the password is valid, false otherwise.
     */
    public boolean isValidPassword(String password) {
        return hasMoreThanOneWord(password) &&
                hasSignAtTheEnd(password) &&
                hasNoDuplication(password) &&
                onlyEnglishLetters(password) &&
                onlyLowerCaseLetters(password);
    }

    /**
     * Checks if a password contains more than one word.
     *
     * @param password The password to be checked.
     * @return true if the password contains more than one word, false otherwise.
     */
    boolean hasMoreThanOneWord(String password){
        return password.contains(" ");
    }

    /**
     * Checks if a password has a valid sign at the end.
     *
     * @param password The password to be checked.
     * @return true if the password has a valid punctuation sign at the end, false otherwise.
     */
    boolean hasSignAtTheEnd(String password) {
        for (String mark : PUNCTUATION_MARKS) {
            if (password.endsWith(mark)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a password has no duplicated words.
     *
     * @param password The password to be checked.
     * @return true if there are no duplicated words, false otherwise.
     */
    boolean hasNoDuplication(String password){
        String[] splitPassword = password.split("\\W+");

        Set<String> counterDuplicates = new HashSet<>(Arrays.asList(splitPassword));

        return splitPassword.length == counterDuplicates.size();
    }

    /**
     * Checks if a password contains only English letters.
     *
     * @param password The password to be checked.
     * @return true if the password contains only English letters, false otherwise.
     */
    boolean onlyEnglishLetters(String password){
        if(hasSignAtTheEnd(password)){
            String passwordWithoutMark = password.substring(0, password.length() - 1);

            return passwordWithoutMark.matches("[a-zA-Z\\s]*");
        }

        return false;
    }

    /**
     * Checks if a password contains only lowercase letters.
     *
     * @param password The password to be checked.
     * @return true if the password contains only lowercase letters, false otherwise.
     */
    boolean onlyLowerCaseLetters(String password){
        return password.toLowerCase().equals(password);
    }

}

package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckerTest {

    private PasswordChecker passwordChecker;

    @BeforeEach
    void setUp() {
        List<String> testPasswords = Arrays.asList(
                "InValidPassword because UpperCase!",
                "InvalidPasswordWithoutSpace",
                "valid password first.",
                "almost valid pássword!",
                "valid password second!",
                "invalid password no punctuation",
                "invalid password no password duplicate?",
                "alma korte!",
                "szilva.",
                "citrom lime",
                "korte korte?",
                "dinnye, ananasz, fuge",
                "Alma Korte!"
        );

        passwordChecker = new PasswordChecker(testPasswords);
    }

    @Test
    void testPasswordChecker() {
        List<String> expectedValidPasswords = Arrays.asList(
                "valid password first.",
                "valid password second!",
                "alma korte!"
        );

        List<String> actualValidPasswords = passwordChecker.passwordChecker();

        assertEquals(expectedValidPasswords, actualValidPasswords);
    }

    @Test
    void testValidPassword(){
        assertTrue(passwordChecker.isValidPassword("alma korte!"));
    }

    @Test
    void testInvalidPassword_WithSingleWord() {
        assertFalse(passwordChecker.isValidPassword("szilva."));
    }

    @Test
    void testInvalidPassword_WithNoPunctuation() {
        assertFalse(passwordChecker.isValidPassword("citrom lime"));
    }

    @Test
    void testInvalidPassword_WithDuplicateWord() {
        assertFalse(passwordChecker.isValidPassword("korte korte?"));
    }

    @Test
    void testInvalidPassword_WithUpperCaseLetter() {
        assertFalse(passwordChecker.isValidPassword("Alma Korte!"));
    }


    @Test
    void testInvalidPassword_WithNonAlphabeticCharacters() {
        assertFalse(passwordChecker.isValidPassword("dinnye, ananasz, fuge"));
    }

    @ParameterizedTest
    @MethodSource("passwordsProvider")
    void testHasSignAtTheEnd(String password, boolean expectedResult) {
        boolean actualResult = passwordChecker.hasSignAtTheEnd(password);
        assertEquals(expectedResult, actualResult);
    }
    private static Stream<Arguments> passwordsProvider() {
        return Stream.of(
                Arguments.of("InValidPassword because UpperCase!", true),
                Arguments.of("valid password first.", true),
                Arguments.of("almost valid pássword!", true),
                Arguments.of("valid password second!", true),
                Arguments.of("invalid password no password duplicate?", true),
                Arguments.of("NoSignAtTheEnd", false)
        );
    }

    @Test
    void testPassword_WithNoDuplication() {
        assertTrue(passwordChecker.hasNoDuplication("almost valid pássword!"));
        assertFalse(passwordChecker.hasNoDuplication("invalid password no password duplicate?"));
    }

    @Test
    void testPassword_WithOnlyEnglishLetters() {
        assertTrue(passwordChecker.onlyEnglishLetters("valid password first."));
        assertFalse(passwordChecker.onlyEnglishLetters("almost valid pássword!"));
    }

    @Test
    void testPassword_WithOnlyLowerCaseLetters() {
        assertTrue(passwordChecker.onlyLowerCaseLetters("invalid password no punctuation"));
        assertFalse(passwordChecker.onlyLowerCaseLetters("InValidPassword because UpperCase!"));
    }

}
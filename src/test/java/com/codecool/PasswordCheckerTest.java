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
                "invalid password no password duplicate?"
        );

        passwordChecker = new PasswordChecker(testPasswords);
    }
    @Test
    void testPasswordChecker() {

        List<String> correctPasswords = passwordChecker.passwordChecker();

        assertEquals(2, correctPasswords.size());
        assertEquals("valid password first.", correctPasswords.get(0));
        assertEquals("valid password second!", correctPasswords.get(1));
    }

    @Test
    void testHasMoreThanOneWord() {
        assertTrue(passwordChecker.hasMoreThanOneWord("Two words"));
        assertFalse(passwordChecker.hasMoreThanOneWord("SingleWord"));
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
    void testHasNoDuplication() {
        assertTrue(passwordChecker.hasNoDuplication("almost valid pássword!"));
        assertFalse(passwordChecker.hasNoDuplication("invalid password no password duplicate?"));
    }

    @Test
    void testOnlyEnglishLetters() {
        assertTrue(passwordChecker.onlyEnglishLetters("valid password first."));
        assertFalse(passwordChecker.onlyEnglishLetters("almost valid pássword!"));
    }

    @Test
    void testOnlyLowerCaseLetters() {
        assertTrue(passwordChecker.onlyLowerCaseLetters("invalid password no punctuation"));
        assertFalse(passwordChecker.onlyLowerCaseLetters("InValidPassword because UpperCase!"));
    }

}
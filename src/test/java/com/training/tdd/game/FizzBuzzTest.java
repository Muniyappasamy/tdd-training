package com.training.tdd.game;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FizzBuzzTest {

    FizzBuzzGame fizzBuzzGame;

    @BeforeEach
    void setup() {
        fizzBuzzGame = new FizzBuzzGame();
    }

    @DisplayName(" Fizz buss Constructor Test")
    @Test
    public void fizzbuzzConstructorTest() {
        Assertions.assertNotNull(fizzBuzzGame);
    }

    @DisplayName(" Test Return Same Number Function")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void returnSameNumber(int input) {
        int result = fizzBuzzGame.printNumber(input);
        Assertions.assertEquals(input, result);
    }

    @DisplayName(" Test Multiple of 3 For fizz Function")
    @ParameterizedTest
    @ValueSource(ints = {3, 9, 123})
    public void multipleOfThreeNumber(int input) {
        String expectedResult = "fizz";
        String result = fizzBuzzGame.fizzbuzz(input);
        Assertions.assertEquals(expectedResult, result);
    }
    @DisplayName(" Test Multiple of 5 For buzz Function")
    @ParameterizedTest
    @ValueSource(ints = {5, 20, 200})
    public void multipleOfFiveNumber(int input) {
        String expectedResult = "buzz";
        String result = fizzBuzzGame.fizzbuzz(input);
        Assertions.assertEquals(expectedResult, result);
    }
    @DisplayName(" Test Multiple of 7 For pop Function")
    @ParameterizedTest
    @ValueSource(ints = {7, 28, 77})
    public void multipleOfSevenNumber(int input) {
        String expectedResult = "pop";
        String result = fizzBuzzGame.fizzbuzz(input);
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName(" Test Multiple of 3 And 7 For fizz pop Function")
    @ParameterizedTest
    @ValueSource(ints = {21, 63, 126})
    public void multipleOfThreeAndSevenNumber(int input) {
        String expectedResult = "fizz pop";
        String result = fizzBuzzGame.fizzbuzz(input);
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName(" Test Multiple of 5 And 7 For buzz pop Function")
    @ParameterizedTest
    @ValueSource(ints = {35, 70, 140})
    public void multipleOfFiveAndSevenNumber(int input) {
        String expectedResult = "buzz pop";
        String result = fizzBuzzGame.fizzbuzz(input);
        Assertions.assertEquals(expectedResult, result);
    }
    @DisplayName(" Test Multiple of 3,5 And 7 For fizz buzz pop Function")
    @ParameterizedTest
    @ValueSource(ints = {105, 210, 315})
    public void multipleOfThreeAndFiveAndSevenNumber(int input) {
        String expectedResult = "fizz buzz pop";
        String result = fizzBuzzGame.fizzbuzz(input);
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName(" Test Multiple of 3 And 5 For fizz buzz Function")
    @ParameterizedTest
    @ValueSource(ints = {15, 45, 45})
    public void multipleOfThreeAndFiveNumber(int input) {
        String expectedResult = "fizz buzz";
        String result = fizzBuzzGame.fizzbuzz(input);
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName(" Using Custome Subtitution For 1")
    @Test
    public void customSubtitionForNumberOne() {
        int actualInput = 1;
        int expectedResult = 1;
        String result = fizzBuzzGame.customfizzbuzz(actualInput);
        Assertions.assertEquals(expectedResult, Integer.parseInt(result));
    }

    @DisplayName(" Using Custome Subtitution Multiple Of 2 for Fizz")
    @ParameterizedTest
    @ValueSource(ints = {2,8})
    public void customSubtitionForMultipleOfNumberTwo(int input) {
        String expectedResult = "fizz";
        String result = fizzBuzzGame.customfizzbuzz(input);
        Assertions.assertEquals(expectedResult, result);
    }
    @DisplayName(" Using Custome Subtitution Multiple Of 3 for bizz")
    @ParameterizedTest
    @ValueSource(ints = {3,9})
    public void customSubtitionForMultipleOfNumberThree(int input) {
        String expectedResult = "bizz";
        String result = fizzBuzzGame.customfizzbuzz(input);
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName(" Using Custome Subtitution Multiple Of 2 and 3 for fizz  bizz")
    @ParameterizedTest
    @ValueSource(ints = {12,24})
    public void customSubtitionForMultipleOfNumberTwoAndThree(int input) {
        String expectedResult = "fizz bizz";
        String result = fizzBuzzGame.customfizzbuzz(input);
        Assertions.assertEquals(expectedResult, result);
    }
}

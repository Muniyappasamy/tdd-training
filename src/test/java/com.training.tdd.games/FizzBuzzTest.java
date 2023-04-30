package com.training.tdd.games;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FizzBuzzTest{
    FizzBuzz fizzBuzz;
    @BeforeEach
    void setup(){
        fizzBuzz = new FizzBuzz();
    }
    @DisplayName("Check fizz buzz class is created")
    @Test
    public void fizzBuzzConstructorTest(){

        Assertions.assertNotNull(fizzBuzz);
    }
    @DisplayName("Display the Same Number As input")
    @ParameterizedTest
    @ValueSource( ints = {1,2,4})
    public void fizzBuzzReturnSameNumber(int input){

        int output = fizzBuzz.returnSameNumber(input);
        Assertions.assertEquals(output,input);
    }

    @DisplayName("Multiple of 3 give fizz")
    @Test
    public void multipleOfThreeReturnFizz(){
        int input = 3;
        String expectedOutput = "fizz";
        String result = fizzBuzz.playFizzBuzz(input);
        Assertions.assertEquals(expectedOutput,result);
    }

    @DisplayName("Multiple of 3 give fizz test With Different Inputs")
    @ParameterizedTest
    @ValueSource(ints = {3,9,123})
    public void multipleOfThreeReturnFizzWithDifferentInputs(int input){
        String expectedOutput = "fizz";
        String result = fizzBuzz.playFizzBuzz(input);
        Assertions.assertEquals(expectedOutput,result);
    }
    @DisplayName("Multiple of 5 give buzz")
    @Test
    public void multipleOfThreeReturnbuzz(){
        int input = 5;
        String expectedOutput = "buzz";
        String result = fizzBuzz.playFizzBuzz(input);
        Assertions.assertEquals(expectedOutput,result);
    }

    @DisplayName("Multiple of 5 give buzz test With Different Inputs")
    @ParameterizedTest
    @ValueSource(ints = {5,20,200})
    public void multipleOfFiveReturnFizzWithDifferentInputs(int input){
        String expectedOutput = "buzz";
        String result = fizzBuzz.playFizzBuzz(input);
        Assertions.assertEquals(expectedOutput,result);
    }

    @DisplayName("Multiple of 5 give buzz test With Non multiple of 5 number Inputs")
    @ParameterizedTest
    @ValueSource(ints = {1,2,4})
    public void nonmultipleOfFiveReturnInputAsOutput(int input){
        String result = fizzBuzz.playFizzBuzz(input);
        Assertions.assertEquals(input,result);
    }


}
package com.training.tdd.games;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FizzBuzzTest{

    @Test
    public void fizzBuzzConstructorTest(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        Assertions.assertNotNull(fizzBuzz);
    }
    @Test
    public void fizzBuzzReturnSameNumber(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        int input = 1;
        int output = fizzBuzz.returnSameNumber(input);
        Assertions.assertEquals(output,input);
    }

}
package com.training.tdd.games;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FizzBuzzTest{
    FizzBuzz fizzBuzz;
    @BeforeEach
    void setup(){
        fizzBuzz = new FizzBuzz();
    }
    @Test
    public void fizzBuzzConstructorTest(){

        Assertions.assertNotNull(fizzBuzz);
    }
    @Test
    public void fizzBuzzReturnSameNumber(){

        int input = 1;
        int output = fizzBuzz.returnSameNumber(input);
        Assertions.assertEquals(output,input);
    }

}
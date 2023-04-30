package com.training.tdd.games;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
    @Test
    public void fizzBuzzConstructorTest(){

        Assertions.assertNotNull(fizzBuzz);
    }
    @ParameterizedTest
    @ValueSource( ints = {1,2,4})
    public void fizzBuzzReturnSameNumber(int input){
        
        int output = fizzBuzz.returnSameNumber(input);
        Assertions.assertEquals(output,input);
    }

}
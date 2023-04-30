package com.training.tdd.games;

public class FizzBuzz {
    public int returnSameNumber(int input) {
        return input;
    }

    public String playFizzBuzz(int input) {

        String result = (input%3 == 0)? "fizz":String.valueOf(input);
        return result;
    }
}

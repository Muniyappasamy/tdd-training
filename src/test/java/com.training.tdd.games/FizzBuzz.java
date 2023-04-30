package com.training.tdd.games;

public class FizzBuzz {
    public int returnSameNumber(int input) {
        return input;
    }

    public String playFizzBuzz(int input) {
        String result;
        result = (input % 3 == 0) ? "fizz" : String.valueOf(input);
        result = (input % 5 == 0) ? "buzz" : String.valueOf(input);

        return result;
    }
}

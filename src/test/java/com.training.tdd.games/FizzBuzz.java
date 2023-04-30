package com.training.tdd.games;

public class FizzBuzz {
    public int returnSameNumber(int input) {
        return input;
    }

    public String playFizzBuzz(int input) {
        String result;

        if(input % 3 == 0 && input % 5 == 0){
            result = "fizz buzz";
        } else if (input % 3 == 0) {
            result = "fizz";
        } else if (input % 5 == 0) {
            result = "buzz";
        }
        else{
           result = String.valueOf(input);
        }

        return result;
    }
}

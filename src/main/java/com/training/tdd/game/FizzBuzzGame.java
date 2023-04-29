package com.training.tdd.game;

public class FizzBuzzGame {

    public int printNumber(int number){
        return number;
    }
    public String fizzbuzz(int input){

        String result = "";

        if(input % 3 == 0){
            result = (result == "")? "fizz" : result + " fizz";
        }
        if(input % 5 == 0){
            result = (result == "")? "buzz" : result + " buzz";
        }
        if(input % 7 == 0){
            result = (result == "")? "pop" : result + " pop";
        }
        return result;
    }

    public String customfizzbuzz(int input){

        String result = "";

        if(input == 1){
            result = "1";
        }
        if(input % 2 == 0){
            result = (result == "")? "fizz" : result + " fizz";
        }
        if(input % 3 == 0){
            result = (result == "")? "bizz" : result + " bizz";
        }
        return result;
    }
}

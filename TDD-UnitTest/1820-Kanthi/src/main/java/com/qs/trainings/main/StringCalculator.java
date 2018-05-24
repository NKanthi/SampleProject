package com.qs.trainings.main;

public class StringCalculator {

    public static final int add(String numbers) {
        int result = 0;
        String[] numbersArray = numbers.split(",|\n");
        for(String num : numbersArray){
            if(!num.isEmpty()) {
                result = result + Integer.parseInt(num);
            }
        }
        /*if(numbersArray.length > 2){
            throw new RuntimeException("More than 2 numbers are not allowed");
        } else {

        }*/
        return result;
    }
}

package com.example.coursework3.utils;

public class Validation {
    public static void checkPercent(Integer number) throws NotPercentException {
        if (!(0 <= number && number<=100)) {
            throw new NotPercentException();
        }
    }
}

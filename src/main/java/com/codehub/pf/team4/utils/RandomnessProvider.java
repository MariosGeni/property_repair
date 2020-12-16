package com.codehub.pf.team4.utils;

import com.codehub.pf.team4.enums.HouseType;

import java.util.Random;

public abstract class RandomnessProvider {
    // Generates a random int with exactly n digits
    public static int getRandomNumber(int numberOfDigits) {
        int newNumber = (int) Math.pow(10, numberOfDigits - 1);
        return newNumber + new Random().nextInt(9 * newNumber);
    }

    // Generates a random long with exactly n digits
    public static long getRandomNumber(long numberOfDigits) {
        long newNumber = (long) Math.pow(10, numberOfDigits - 1);
        return newNumber + (long)(Math.random()*(9 * newNumber));
    }

    // Generates a random long -> length of characters ranging from min to max
    public static Long getRandomNumber(int min, int max) {
        Long minNumber = (long) Math.pow(10, min - 1);
        Long maxNumber = (long) Math.pow(10, max - 1);
        return minNumber + (long) (Math.random() * (maxNumber - minNumber));
    }

    // Get a random integer between a range
    public static int getRandomNumberBetween(int minNumber, int maxNumber) {
        return minNumber + new Random().nextInt((maxNumber - minNumber) + 1);
    }

    // Get a random housetype
    public static HouseType getRandomHouseType() {
        int minNumber = 0;
        int maxNumber = 100;
        int value = getRandomNumberBetween(minNumber, maxNumber);
        if (value <= 33) return HouseType.DETACHED_HOUSE;
        else if (value <= 66) return HouseType.APARTMENT_BUILDING;
        else return HouseType.MAISONETTE;
    }

}

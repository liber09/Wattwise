package org.example;

import java.util.Collections;
import java.util.Map;

public class Calculator {

    public static void maxMinAverage(Map<String, Integer> userPriceList) {
        System.out.println("The most expensive hour this day is between " + getMaxPrice(userPriceList) + " cent per kWh");
    }

    private static String getMaxPrice(Map<String, Integer> userPriceList) {
        String maxKey = Collections.max(userPriceList.entrySet(),
                Map.Entry.comparingByValue()).getKey();
        Integer maxValue = userPriceList.get(maxKey);
        return maxKey + ", " + maxValue;
    }
}

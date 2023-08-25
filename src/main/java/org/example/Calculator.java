package org.example;

import java.util.Collections;
import java.util.Map;

public class Calculator {

    public static void maxMinAverage(Map<String, Integer> userPriceList) {
        System.out.println("The least expensive hour this day is between " +
                getMinPrice(userPriceList) + " cent per kWh");
        System.out.println("The most expensive hour this day is between " +
                getMaxPrice(userPriceList) + " cent per kWh");
        System.out.println("The average price this day is " +
                getAveragePrice(userPriceList) + " cent per kWh");
    }

    private static String getMinPrice(Map<String, Integer> userPriceList) {
        String minKey = Collections.min(userPriceList.entrySet(),
                Map.Entry.comparingByValue()).getKey();
        Integer minValue = userPriceList.get(minKey);
        return minKey + ", " + minValue;
    }

    private static String getMaxPrice(Map<String, Integer> userPriceList) {
        String maxKey = Collections.max(userPriceList.entrySet(),
                Map.Entry.comparingByValue()).getKey();
        Integer maxValue = userPriceList.get(maxKey);
        return maxKey + ", " + maxValue;
    }

    private static String getAveragePrice(Map<String, Integer> userPriceList) {
        return String.valueOf(userPriceList.values()
                .stream().mapToDouble(integer -> integer).average().orElse(0.0));
    }
}

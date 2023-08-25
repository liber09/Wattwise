package org.example;

import java.util.*;

public class Calculator {

    public static void maxMinAverage(Map<String, Integer> userPriceList) {
        System.out.println("Den billigaste timmen idag är mellan:  " +
                getMinPrice(userPriceList) + " öre per kWh");
        System.out.println("Den dyraste timmen idag är mellan: " +
                getMaxPrice(userPriceList) + " öre per kWh");
        System.out.println("Det genomsnittliga priset idag är: " +
                String.format("%.2f", getAveragePrice(userPriceList)) + " öre per kWh");
    }

    public static void getSortedPriceList(
            Map<String, Integer> userPriceList) {

        // Takes the content from userPriceList (hashMap) and add it to a temporary arrayList
        ArrayList<Map.Entry<String, Integer>> tempList = new ArrayList<>(userPriceList.entrySet());

        tempList.sort((obj1, obj2) -> {
            if (Objects.equals(obj1.getValue(), obj2.getValue())) {
                return obj1.getKey().compareTo(obj2.getKey());
            }
            return Integer.compare(obj1.getValue(), obj2.getValue());
        });

        for(Map.Entry<String, Integer> entry : tempList) {
            System.out.println("Tid: " + entry.getKey() +
                    " : " + entry.getValue() + " öre per kWh");
        }
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

    private static Double getAveragePrice(Map<String, Integer> userPriceList) {
        return userPriceList.values()
                .stream().mapToDouble(integer -> integer)
                .average().orElse(0.0);
    }
}

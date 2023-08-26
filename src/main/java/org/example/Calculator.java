package org.example;

import java.util.*;

public class Calculator {

    public static void maxMinAverage(Map<String, Integer> priceList) {
        System.out.println("Den billigaste timmen idag är mellan:  " +
                getMinPrice(priceList) + " öre per kWh");
        System.out.println("Den dyraste timmen idag är mellan: " +
                getMaxPrice(priceList) + " öre per kWh");
        System.out.println("Det genomsnittliga priset idag är: " +
                String.format("%.2f", getAveragePrice(priceList)) + " öre per kWh");
    }

    public static void getSortedPriceList(
            Map<String, Integer> priceList) {

        // Takes the content from priceList (hashMap) and add it to a temporary arrayList
        ArrayList<Map.Entry<String, Integer>> tempList = new ArrayList<>(priceList.entrySet());

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

    public static void bestChargingHours(int numberOfHours, Map<String, Integer> priceList) {

        // Takes the content from priceList (hashMap) and add it to a temporary arrayList
        ArrayList<Map.Entry<String, Integer>> tempList = new ArrayList<>(priceList.entrySet());

        tempList.sort((obj1, obj2) -> {
            if (Objects.equals(obj1.getKey(), obj2.getKey())) {
                return obj1.getValue().compareTo(obj2.getValue());
            }
            return CharSequence.compare(obj1.getKey(), obj2.getKey());
        });

        int lowestPrice = 999999999;
        int tempPrice = 0;
        int bestStartingHour = 0;
        for(int i = 0; i <= 23 - numberOfHours; i++) {
            for(int j = 0; j <= numberOfHours - 1; j++) {
                tempPrice += tempList.get(i+j).getValue();
            }
            if(tempPrice < lowestPrice){
                lowestPrice = tempPrice;
                bestStartingHour = i;
            }
            tempPrice = 0;
        }
        if(bestStartingHour <=9){
            if(bestStartingHour+numberOfHours <=9){
                System.out.println("Den bästa tiden för laddningen är kl 0" + bestStartingHour + " - 0" + (bestStartingHour+numberOfHours) + " \nsnittpriset för " + numberOfHours + " timmars laddning är " + (lowestPrice/4) + " öre per kWh");
            }else{
                System.out.println("Den bästa tiden för laddningen är kl 0" + bestStartingHour + " - " + (bestStartingHour+numberOfHours) + " \nsnittpriset för " + numberOfHours + " timmars laddning är " + (lowestPrice/4) + " öre per kWh");
            }
        }else{
            System.out.println("Den bästa tiden för laddningen är kl " + bestStartingHour + " - " + (bestStartingHour+numberOfHours) + " \nsnittpriset för " + numberOfHours + " timmars laddning är " + (lowestPrice/4) + " öre per kWh");
        }
    }

    private static String getMinPrice(Map<String, Integer> priceList) {
        String minKey = Collections.min(priceList.entrySet(),
                Map.Entry.comparingByValue()).getKey();
        Integer minValue = priceList.get(minKey);
        return minKey + ", " + minValue;
    }

    private static String getMaxPrice(Map<String, Integer> priceList) {
        String maxKey = Collections.max(priceList.entrySet(),
                Map.Entry.comparingByValue()).getKey();
        Integer maxValue = priceList.get(maxKey);
        return maxKey + ", " + maxValue;
    }

    private static Double getAveragePrice(Map<String, Integer> priceList) {
        return priceList.values()
                .stream().mapToDouble(integer -> integer)
                .average().orElse(0.0);
    }
}

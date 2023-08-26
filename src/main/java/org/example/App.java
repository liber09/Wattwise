package org.example;


import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        String userMenuInput;
        Map<String, Integer> priceList = new HashMap<>();

        do{
            userMenuInput = Menu.printMenu();

            switch (userMenuInput) {
                case "1" -> {
                    priceList = PriceData.getDataFromUser();
                    System.out.println(priceList);
                }
                case "2" -> Calculator.maxMinAverage(priceList);
                case "3" -> Calculator.getSortedPriceList(priceList);
                case "4" -> Calculator.bestChargingHours(4, priceList);
                case "5" -> priceList = PriceData.getDataFromFile();
            }
        }while(!userMenuInput.equalsIgnoreCase("e"));

    }
}

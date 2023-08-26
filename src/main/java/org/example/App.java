package org.example;


import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        String userMenuInput;
        boolean userWantsToExit = false;
        Map<String, Integer> priceList = new HashMap<>();

        do{
            userMenuInput = Menu.printMenu();

            switch (userMenuInput.toLowerCase()) {
                case "1" -> {
                    priceList = PriceData.getDataFromUser();
                    System.out.println(priceList);
                }
                case "2" -> Calculator.maxMinAverage(priceList);
                case "3" -> Calculator.getSortedPriceList(priceList);
                case "4" -> Calculator.bestChargingHours(4, priceList);
                case "5" -> priceList = PriceData.getDataFromFile();
                case "e" -> userWantsToExit = true;
                default -> System.out.println("Felaktigt val, försök igen!");
            }
        }while(!userWantsToExit);

    }
}

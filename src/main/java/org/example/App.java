package org.example;


import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        String userMenuInput;
        Map<String, Integer> userPriceList = new HashMap<>();

        do{
            userMenuInput = Menu.printMenu();

            switch (userMenuInput) {
                case "1" -> {
                    userPriceList = PriceData.getDataFromUser();
                    System.out.println(userPriceList);
                }
                case "2" -> Calculator.maxMinAverage(userPriceList);
                case "3" -> Calculator.getSortedPriceList(userPriceList);
                case "4" -> Calculator.bestChargingHours(4, userPriceList);
            }
        }while(!userMenuInput.equalsIgnoreCase("e"));

    }
}

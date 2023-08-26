package org.example;


import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                case "2" -> {
                    if(!priceList.isEmpty()){
                        Calculator.maxMinAverage(priceList);
                    }else{
                        System.out.println("Ojdå, vi verkar inte ha fått in några priser! Mata in priser eller läs in dem från fil");
                    }

                }
                case "3" -> {
                    if(!priceList.isEmpty()){
                        Calculator.getSortedPriceList(priceList);
                    }else{
                        System.out.println("Ojdå, vi verkar inte ha fått in några priser! Mata in priser eller läs in dem från fil");
                    }
                }
                case "4" -> {
                    if(!priceList.isEmpty()){
                        int numberOfHours = 0;
                        System.out.println("Ange hur många timmar vill du ladda: ");
                        boolean correctInput = false;
                        do {
                            try {
                                numberOfHours = scanner.nextInt();
                                if(numberOfHours > 0 && numberOfHours < 24){
                                    correctInput = true;
                                } else {
                                    System.out.println("\"" + numberOfHours + "\"" + " är en felaktig inmatning, ange endast ett heltal mellan 1 - 23");
                                    System.out.println("Ange hur många timmar vill du ladda: ");
                                }
                            } catch(InputMismatchException e) {
                                System.out.println("\"" + scanner.nextLine() + "\"" + " är en felaktig inmatning, ange endast ett heltal mellan 1 - 23");
                                System.out.println("Ange hur många timmar vill du ladda: ");
                            }
                        } while(!correctInput);
                        Calculator.bestChargingHours(numberOfHours, priceList);
                    }else{
                        System.out.println("Ojdå, vi verkar inte ha fått in några priser! Mata in priser eller läs in dem från fil");
                    }
                }
                case "5" -> priceList = PriceData.getDataFromFile();
                case "e" -> userWantsToExit = true;
                default -> System.out.println("Felaktigt val, försök igen!");
            }
        }while(!userWantsToExit);

    }
}

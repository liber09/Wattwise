package org.example;


import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        String userMenuInput;
        Map userPriceList = new HashMap<>();

        do{
            userMenuInput = Menu.printMenu();

            switch(userMenuInput){

                case "1":
                    userPriceList = PriceData.getDataFromUser();
                    System.out.println(userPriceList);
                    break;
                case "2":
                    Calculator.maxMinAverage(userPriceList);

                    break;
            }
        }while(!userMenuInput.equalsIgnoreCase("e"));

    }
}

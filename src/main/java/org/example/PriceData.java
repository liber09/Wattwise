package org.example;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PriceData {

    static Scanner scanner = new Scanner(System.in);

    public static Map getDataFromUser() {

        Map userPriceList = new HashMap<>();
        String timeInterval;

        for(int i = 0; i <= 23; i++) {
            if (i < 9) {
                timeInterval = "0" + i + " - 0" + (i + 1);
                System.out.println("Enter price for hours " + timeInterval);
            } else if (i == 9) {
                timeInterval = i + " - " + (i + 1);
                System.out.println("Enter price for hours 0" + timeInterval);
            }else if(i == 23) {
                timeInterval = i + " - 00";
                System.out.println("Enter price for hours " + timeInterval);
            }else {
                timeInterval = i + " - " + (i + 1);
                System.out.println("Enter price for hours " + timeInterval);
            }
            userPriceList.put(timeInterval, scanner.nextInt());
        }
        System.out.println("Thanks for your data..");
        return userPriceList;
    }
}

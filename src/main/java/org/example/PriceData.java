package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PriceData {

    static Scanner scanner = new Scanner(System.in);

    public static Map<String, Integer> getDataFromUser() {

        Map<String, Integer> userPriceList = new HashMap<>();
        String timeInterval;

        for(int i = 0; i <= 23; i++) {
            if (i < 9) {
                timeInterval = "0" + i + " - 0" + (i + 1);
                System.out.println("Ange pris kl: " + timeInterval);
            } else if (i == 9) {
                timeInterval = i + " - " + (i + 1);
                System.out.println("Ange pris kl: 0" + timeInterval);
            }else if(i == 23) {
                timeInterval = i + " - 00";
                System.out.println("Ange pris kl: " + timeInterval);
            }else {
                timeInterval = i + " - " + (i + 1);
                System.out.println("Ange pris kl: " + timeInterval);
            }
            userPriceList.put(timeInterval, scanner.nextInt());
        }
        System.out.println("Tack..");
        return userPriceList;
    }
}

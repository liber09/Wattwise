package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PriceData {



    public static Map<String, Integer> getDataFromUser() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> userPriceList = new HashMap<>();
        String timeInterval;

        for(int i = 0; i <= 23; i++) {
            if (i < 9) {
                timeInterval = createTimeInterval(i);
                System.out.println("Ange pris kl: " + timeInterval);
            } else if (i == 9) {
                timeInterval = createTimeInterval(i);
                System.out.println("Ange pris kl: 0" + timeInterval);
            }else if(i == 23) {
                timeInterval = createTimeInterval(i);
                System.out.println("Ange pris kl: " + timeInterval);
            }else {
                timeInterval = createTimeInterval(i);
                System.out.println("Ange pris kl: " + timeInterval);
            }
            userPriceList.put(timeInterval, scanner.nextInt());
        }
        System.out.println("Tack..");
        return userPriceList;
    }

    public static Map<String,Integer> getDataFromFile() {
        Map<String, Integer> filePriceList = new HashMap<>();
        Scanner scanner;
        try {
            File file = new File("priser.csv");
            scanner = new Scanner(file);
            scanner.useDelimiter(",");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int i = 0;
        String timeInterval;
        while (scanner.hasNext()) {
            if (i < 9) {
                timeInterval = createTimeInterval(i);
            } else if (i == 9) {
                timeInterval = createTimeInterval(i);
            } else if (i == 23) {
                timeInterval = createTimeInterval(i);
            } else {
                timeInterval = createTimeInterval(i);
            }
            i++;
            filePriceList.put(timeInterval, scanner.nextInt());
        }
        System.out.println("Priser inlästa..");
        return filePriceList;
    }

    private static String createTimeInterval(int i) {
        String timeInterval;
        if (i < 9) {
            timeInterval = "0" + i + " - 0" + (i + 1);
        } else if (i == 9) {
            timeInterval = "0" + i + " - " + (i + 1);
        } else if (i == 23) {
            timeInterval = i + " - 00";
        } else {
            timeInterval = i + " - " + (i + 1);
        }
        return timeInterval;
    }
}

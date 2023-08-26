package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PriceData {

    public static Map<String, Integer> getDataFromUser() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> userPriceList = new HashMap<>();
        String timeInterval;
        System.out.println("Ange pris i hela ören");
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

            boolean correctInput = false;
            do {
                try {
                    userPriceList.put(timeInterval, scanner.nextInt());
                    correctInput = true;
                } catch(InputMismatchException e) {
                    System.out.println("\"" + scanner.nextLine() + "\"" + " är en felaktig inmatning, ange endast ett pris i hela ören");
                    System.out.println("Ange pris kl: " + timeInterval);
                }
            } while(!correctInput);
        }
        System.out.println("Tack..");
        return userPriceList;
    }

    public static Map<String,Integer> getDataFromFile() {
        Map<String, Integer> filePriceList = new LinkedHashMap<>();
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
            if(i < 9) {
                timeInterval = createTimeInterval(i);
            } else if(i == 9) {
                timeInterval = createTimeInterval(i);
            } else if(i == 23) {
                timeInterval = createTimeInterval(i);
            } else {
                timeInterval = createTimeInterval(i);
            }
            i++;
            filePriceList.put(timeInterval, scanner.nextInt());
        }
        for(Map.Entry<String, Integer> entry : filePriceList.entrySet()) {
            System.out.println("Tid: " + entry.getKey() +
                    " : " + entry.getValue() + " öre per kWh");
        }
        return filePriceList;
    }

    private static String createTimeInterval(int i) {
        String timeInterval;
        if(i < 9) {
            timeInterval = "0" + i + " - 0" + (i + 1);
        } else if(i == 9) {
            timeInterval = "0" + i + " - " + (i + 1);
        } else if(i == 23) {
            timeInterval = i + " - 00";
        } else {
            timeInterval = i + " - " + (i + 1);
        }
        return timeInterval;
    }
}

package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class PriceData {

    static Scanner scanner = new Scanner(System.in);

    public static void getDataFromUser() {

        ArrayList<Integer> userPriceList = new ArrayList<Integer>();

        for(int i = 0; i <= 23; i++) {
            if (i < 9) {
                System.out.println("Enter price for hours 0" + i + " - 0" + (i + 1));
            } else if (i == 9) {
                System.out.println("Enter price for hours 0" + i + " - " + (i + 1));
            } else {
                System.out.println("Enter price for hours " + i + " - " + (i + 1));
            }
            userPriceList.add(scanner.nextInt());
        }
        System.out.println("Thanks for your data..");
    }
}

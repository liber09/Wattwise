package org.example;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static String printMenu() {

        System.out.println("Elpriser");
        System.out.println("========");
        System.out.println("1. Inmating");
        System.out.println("2. Min, Max, Medel");
        System.out.println("3. Sortera");
        System.out.println("4. Bästa Laddningstid (4h)");
        System.out.println("5. Läs in priser från fil");
        System.out.println("e. Avsluta");

        return scanner.nextLine();
    }
}

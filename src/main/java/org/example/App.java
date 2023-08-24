package org.example;


public class App {
    public static void main(String[] args) {

        String userMenuInput;

        do{
            userMenuInput = Menu.printMenu();

            switch(userMenuInput){

                case "1":
                    PriceData.getDataFromUser();
                    break;
            }
        }while(!userMenuInput.equalsIgnoreCase("e"));

    }
}

package com.techelevator;

import java.util.Locale;
import java.util.Scanner;

public class UserInput {

    Scanner scanner = new Scanner(System.in);
    UserOutput output = new UserOutput();
    public String getConversionType() {

        while(true) {
            output.promptForType();

            String type = scanner.nextLine().toLowerCase();
            if (type.equals("t") || type.equals("l") || type.equals("e"))
                return type;

            output.tellUserTheyAreWrong();
        }
    }

    public int displayMainMenu() {

        while (true) {

            output.displayMenu();
            String menu = scanner.nextLine();
            int choice = Integer.parseInt(menu);
            if(choice > 0 && choice < 4)
                return choice;
        }

    }

    public double getLength() {
        while(true) {
            output.promptForLength();

            String type = scanner.nextLine();
            Double from = Double.parseDouble(type);
            return from;
        }
    }

    public double getTemp() {
        while(true) {
            output.promptForTemp();

            String type = scanner.nextLine();
            double from = Double.parseDouble(type);
            return from;
        }
    }

    public int displayReportMenu() {

        while(true) {
            output.promptForReportMenu();

            String type = scanner.nextLine();
            int selected = Integer.parseInt(type);

            if(selected > 0 && selected < 5)
                return selected;
        }
    }
}

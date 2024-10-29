package com.techelevator;

public class UserOutput {

    public void openForBusiness() {
        System.out.println("===== Convert Shop is Open for Business =====");

        System.out.println(" ____                          __     ____  _                 ");
        System.out.println("/ ___| ___  _ ____   _____ _ __| |_  / ___|| |__   ___  _ __  ");
        System.out.println("| |   / _ \\| '_ \\ \\ / / _ \\ '__| __| \\___ \\| '_ \\ / _ \\| '_ \\ ");
        System.out.println("| |__| (_) | | | \\ V /  __/ |  | |_   ___) | | | | (_) | |_) |");
        System.out.println(" \\____\\___/|_| |_|\\_/ \\___|_|   \\__| |____/|_| |_|\\___/| .__/");
        System.out.println("                                                       |_|");
        System.out.println("");
    }

    public void promptForType() {
        System.out.print("Please enter Conversion type. Use [T] for temp, ot [L} for length or [E] to go back to the main menu:");
    }

    public void tellUserTheyAreWrong() {
        System.out.println("Invalid type. Please use 't' or 'T'  for temp or 'l' or 'L' for length!");
    }

    public void promptForLength() {
        System.out.print("Please enter length in M:");
    }

    public void promptForTemp() {
        System.out.print("Please enter temp in F:");
    }

    public void displayTempResult(Double result) {
        System.out.println(String.format("Converting Temperature => The result is %.2f C",result));
    }

    public void displayLengthResult(Double result) {
        System.out.println(String.format("Converting Length => The result is %.2f ft",result));
    }

    public void displayMenu() {

        System.out.println("");
        System.out.println("=== Main Menu ===");
        System.out.println("What do you want to do?");
        System.out.println("   1) Use Unit Convertor");
        System.out.println("   2) View Reports");
        System.out.println("   3) Exit");
        System.out.print("Please enter 1, 2 or 3: ");
    }

    public void sayGoodBye() {
        System.out.println("GoodBye! Please come again");
    }

    public void promptForReportMenu() {

        System.out.println("");
        System.out.println("=== Report Menu ===");
        System.out.println("What report you want to see?");
        System.out.println("   1) Show me all History records");
        System.out.println("   2) Highest Converted Temperature");
        System.out.println("   3) History by Year");
        System.out.println("   4) Exit");
        System.out.print("Please enter 1-4: ");
    }
}

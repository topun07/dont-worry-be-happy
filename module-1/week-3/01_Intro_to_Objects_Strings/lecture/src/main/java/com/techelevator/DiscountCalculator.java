package com.techelevator;

import java.util.Scanner;

public class DiscountCalculator {

    public static void main(String[] args) {


        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter Your Name:");

        String name = myScanner.nextLine();

        System.out.println("Your name is" + name );

        System.out.println("Were are you located?");

        String location = myScanner.nextLine();

        System.out.println("How is the weater in " + location);





        //region Book Examples
        Book book1 = new Book();
        book1.Title = "Gone with the wind";
        book1.Authors = "Some Authors";
        book1.NumberOfPages = 531;

        //book1.dispaly();

        Book book2 = new Book();
        book2.Title = "3 body Problem";
        book2.Authors = "Another Author";
        book2.NumberOfPages = 123;


        Book[] Shelf1 = new Book[20];
        Shelf1[0] = book1;
        Shelf1[1] = book2;

       /* for (int i = 0; i < Shelf1.length; i++) {
            Book b =Shelf1[i];
            if(b != null)
                b.dispaly();
        } */
        //endregion

        //Deals with display

        //System.out ===> Dispaly
        //Scanner =====> Get Input
        //String ===> Deal with strings
        //================================================================================
        System.out.println("Welcome to the Discount Calculator!");

        boolean finished = false;
        while (finished == false) {
            //Prompt user to enter price
            System.out.print("Please enter a list of prices, separated by spaces: ");
            Scanner input = new Scanner(System.in);
            String prices = input.nextLine();
            String[] priceArray = prices.split(" ");

            //Prompt user to enter discount percentage
            System.out.print("Please enter a discount percentage (20 for a 20% discount, for example): ");
            String discount = input.nextLine();

            //Calculate the total price
            double total = 0;
            for (int i = 0; i < priceArray.length; i++) {
                double undiscountedPrice = Double.parseDouble(priceArray[i]);
                total += undiscountedPrice;
            }

            //Calculate the discounted total
            int discountPercent = Integer.parseInt(discount);
            double discountAmount = total * (discountPercent / 100.0);
            double discountedTotal = total - discountAmount;

            //Print out the discounted price
            System.out.format("The total price is: $%.2f.\n", total);
            System.out.format("The discounted total is: $%.2f.\n", discountedTotal);

            System.out.print("Are you finished (y/n)? ");
            String response = input.nextLine();
            if (response.equals("y")) {
                finished = true;
            }
        }
        System.out.println("Thank you for using the Discount Calculator.");
    }


    //================================================================================
}

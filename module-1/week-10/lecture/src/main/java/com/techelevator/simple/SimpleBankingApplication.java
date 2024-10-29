package com.techelevator.simple;


public class SimpleBankingApplication {
    public static void main(String[] args) {

        doSomeWork();
        //doSomeTransfers();

    }

    public static void doSomeWork() {
        System.out.println("Application Start...");

        SomeFancyClass myWorker = new SomeFancyClass();

        System.out.println("Do some work...");

        try {
            //myWorker.doSomeMathWork();
            myWorker.doSomeArrayWork();
            myWorker.doClassWork();
            myWorker.doStringWork();
        }
        catch(ArithmeticException abcd) {
            System.out.println(abcd.getMessage());
        }
        catch(NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        catch(NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }


        System.out.println("Application End!");
    }


    public static void doSomeTransfers() {
        SimpleAccount account1 = new SimpleAccount("123456789", 100);
        SimpleAccount account2 = new SimpleAccount("987654321", 500);

        int result = account1.transfer(account2, 200);

        if (result < 0) {
            System.out.println("Transfer Failed!");

            if (result == -1)
                System.out.println("Destination account is invalid!");
            else if (result == -2)
                System.out.println("Source account does not have sufficient balance");
            else if (result == -3)
                System.out.println("Network error");
            else if (result == -4)
                System.out.println("Failed to withdraw");
            else
                System.out.println("Unknown Error");
        }
        else
            System.out.println("Transfer successful");

        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());
    }
}

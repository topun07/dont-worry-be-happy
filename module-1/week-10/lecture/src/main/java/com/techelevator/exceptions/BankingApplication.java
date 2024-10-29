package com.techelevator.exceptions;

public class BankingApplication {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("123456789", 100);
        BankAccount account2 = new BankAccount("987654321", 500);

        try {
            account1.transfer(account2, 200);
            System.out.println("Transfer successful");
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (InvalidAccountException e) {
            System.out.println(e.getMessage());
        } catch (NetworkException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Account 1 balance: " + account1.getBalance());
            System.out.println("Account 2 balance: " + account2.getBalance());
        }
    }
}

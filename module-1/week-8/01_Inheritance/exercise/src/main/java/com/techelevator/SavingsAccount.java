package com.techelevator;

public class SavingsAccount extends BankAccount {
    private static final int SERVICE_CHARGE = 2;
    private static final int MIN_BALANCE_AFTER_WITHDRAWAL = 150;

    // constructor
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    // override withdraw method
    @Override
    public int withdraw(int amountToWithdraw) {
        int currentBalance = getBalance();
        int newBalance = currentBalance - amountToWithdraw;

        // check if withdrawal would result in a negative balance
        if (newBalance < 0) {
            //System.out.println("Withdrawal failed, insuffectient funds.");
            return currentBalance;
        }

        // check if remaining is less than 150
        if (newBalance < MIN_BALANCE_AFTER_WITHDRAWAL) {
            newBalance -= SERVICE_CHARGE;
        }

        // check if resulting balance is still non-negative
        if (newBalance >= 0) {
            deposit(newBalance - currentBalance); //update balance
            return newBalance;
        } else {
            //System.out.println("Withdrawal failed. Insuffecient funds.");
            return currentBalance;
        }
    }
}
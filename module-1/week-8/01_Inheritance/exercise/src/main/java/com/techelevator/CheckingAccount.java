package com.techelevator;

public class CheckingAccount extends BankAccount {
    private static final int OVERDRAFT_FEE = 10;
    private static final int OVERDRAFT_LIMIT = -100;

    //constructor
    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    //override withdraw a method
    @Override
    public int withdraw(int amountToWithdraw) {
        //int currentBalance = getBalance() - amountToWithdraw;
        int newBalance = super.getBalance() - amountToWithdraw;

        //check if the withdrawal request exceeds the overdraft limit
        if (newBalance < OVERDRAFT_LIMIT - OVERDRAFT_FEE) {
            //System.out.println("Withdrawal failed: exceeds overdraft limit.");
            return getBalance();
        }

        //apply overdraft fee if the balance falls below $0
        if (newBalance < 0 && getBalance() >= OVERDRAFT_LIMIT) {
            newBalance = newBalance - OVERDRAFT_FEE;
            return newBalance;
        }

        //check if the resulting balance is still above or equal to the overdraft
        if (newBalance >= OVERDRAFT_LIMIT) {
            deposit(newBalance - getBalance());
            return newBalance;
        } else {
            //System.out.println("Withdrawal failed: Exceeds overdraft limit.");
            return getBalance();
        }
    }
}
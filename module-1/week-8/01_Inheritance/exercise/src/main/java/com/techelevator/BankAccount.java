package com.techelevator;

public class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    private int balance;

    //constructors
    public BankAccount(String accountHolderName, String accountNumber){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public BankAccount(String accountHolderName, String accountNumber, int balance){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //getters
    public String getAccountNumber(){
        return accountNumber;
    }

    public String getAccountHolderName(){
        return accountHolderName;
    }

    public int getBalance() {
        return balance;
    }

    //methods
    public int deposit(int amountToDeposit){
        if (amountToDeposit > 0){
            balance += amountToDeposit;
        }
        return balance;
    }

    public int withdraw(int amountToWithdraw){
        if (amountToWithdraw > 0 && amountToWithdraw <= balance){
            balance -= amountToWithdraw;
        }
        return balance;
    }
}

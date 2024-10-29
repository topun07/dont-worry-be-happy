package com.techelevator.simple;

public class SimpleAccount {

    private String accountNumber;
    private double balance;

    public SimpleAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public boolean withdraw(double amount){
        if (amount > balance) {
           return false;
        }
        balance -= amount;

        return true;
    }

    public int transfer(SimpleAccount toAccount, double amount)  {
        if (toAccount == null) {
           return -1;
        }
        if (amount > balance) {
           return -2;
        }
        if (Math.random() < 0.1) { // Simulating a 10% chance of network failure
            return -3;
        }

        boolean res = withdraw(amount);
        if(res == false)
            return -4;

        toAccount.deposit(amount);

        return 0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}


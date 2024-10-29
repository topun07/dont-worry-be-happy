package com.techelevator.exceptions;

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for account " + accountNumber);
        }
        balance -= amount;
    }

    public void transfer(BankAccount toAccount, double amount) throws InsufficientFundsException, InvalidAccountException, NetworkException {
        if (toAccount == null) {
            throw new InvalidAccountException("Invalid account number");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for account " + accountNumber);
        }
       /* if (Math.random() < 0.1) { // Simulating a 10% chance of network failure
            throw new NetworkException("Network error while transferring funds");
        }*/
        withdraw(amount);
        toAccount.deposit(amount);
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


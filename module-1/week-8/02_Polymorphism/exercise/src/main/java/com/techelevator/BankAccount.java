package com.techelevator;

public class BankAccount implements Accountable {

    private String accountHolderName;
    private String accountNumber;
    protected int balance;

    public BankAccount(String accountHolder, String accountNumber) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public BankAccount(String accountHolder, String accountNumber, int balance) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    public int deposit(int amountToDeposit) {
        if (amountToDeposit > 0) {
            balance += amountToDeposit;
        }
        return balance;
    }

    public int withdraw(int amountToWithdraw) {
        if (amountToWithdraw > 0) {
            balance = balance - amountToWithdraw;
        }
        return balance;
    }


    // Method to transfer funds to another BankAccount
    public int transferFunds(BankAccount destinationAccount, int transferAmount) {
        if (transferAmount > 0 && transferAmount <= balance) {
            withdraw(transferAmount); // Withdraw from this account
            destinationAccount.deposit(transferAmount); // Deposit into destination account
            return balance; // Return the new balance of the "from" account
        } else if (transferAmount < 0) {
            return balance; // Return current balance for negative transfer amounts
        } else if (this instanceof CheckingAccount && transferAmount > balance) {
            // Handling CheckingAccount overdraft
            int overdraftFee = CheckingAccount.OVERDRAFT_FEE;
            withdraw(transferAmount + overdraftFee); // Withdraw with overdraft fee
            destinationAccount.deposit(transferAmount); // Deposit into destination account
            return balance; // Return the new balance of the "from" account
        } else if (this instanceof SavingsAccount && transferAmount > balance - SavingsAccount.LOW_BALANCE) {
            // Handling SavingsAccount service charge
            int serviceCharge = SavingsAccount.SERVICE_CHARGE;
            withdraw(transferAmount + serviceCharge); // Withdraw with service charge
            destinationAccount.deposit(transferAmount); // Deposit into destination account
            return balance; // Return the new balance of the "from" account
        } else {
            return balance; // Return current balance if transfer cannot be completed
        }
    }
}
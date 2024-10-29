package com.techelevator;

public class CreditCardAccount implements Accountable {
    private String accountHolderName;
    private String cardNumber;
    private int debt;

    //constructor
    public CreditCardAccount(String accountHolderName, String cardNumber){
        this.accountHolderName = accountHolderName;
        this.cardNumber = cardNumber;
        this.debt = debt;
    }

    //getters
    public String getCardNumber(){
        return cardNumber;
    }

    public String getAccountHolderName(){
        return accountHolderName;
    }

    public int getDebt(){
        return debt;
    }

    @Override
    // implementation of the getBalance() method from the accountable interface
    public int getBalance() {
        return -debt;
    }

    //method for paying debt
    public int pay(int amountToPay) {
        if (amountToPay > 0 && amountToPay <= debt) {
            debt -= amountToPay;
        }
        return debt;
    }

    public int charge(int amountToCharge) {
        if (amountToCharge > 0) {
            debt += amountToCharge;
        }
        return debt;
    }

}

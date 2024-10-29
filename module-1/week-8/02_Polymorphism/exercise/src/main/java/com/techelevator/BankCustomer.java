package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer{
    public String name;
    public String address;
    public String phoneNumber;
    private List<Accountable> accounts; // list of accountable items

    // Default constructor
    public BankCustomer() {
        this.accounts = new ArrayList<>(); // initialize the list of accounts
    }

    //contsructor with parameters
    public BankCustomer(String name, String address, String phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accounts = new ArrayList<>(); // initialize the list of accounts
    }

    //setters

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public Accountable[] getAccounts(){
        return accounts.toArray(new Accountable[0]);
    }

    public void addAccount(Accountable newAccount){
        this.accounts.add(newAccount);
    }

    // Method to check if the customer is a VIP
    public boolean isVip() {
        int totalBalance = 0;

        // Calculate the total balance of all accounts
        for (Accountable account : accounts) {
            totalBalance += account.getBalance();
        }

        // Check if the total balance is at least $25,000
        return totalBalance >= 25000;
    }
}

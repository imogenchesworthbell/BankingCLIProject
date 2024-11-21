package org.BankingSystem;

public class Account {

    //Defining Attributes

    private int accountNumber;
    private double balance;
    private String accountName;

    // Constructor

    public Account(int accountNumber, double balance, String accountName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountName = accountName;
    }

    // Encapsulation i.e getters and setters

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    //Methods

    //Deposit Money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
//            System.out.printf("Deposit of £%.2f has been successful.%n", amount);
//        } else {
//            System.out.printf("Deposit of £%.2f is invalid, please try again.%n", amount);
        }
    }

    //Withdraw Money
    public void withdraw(double amount) {
        if (amount > 0) {
//            System.out.println("Amount must be greater than zero.");
//        } else if(balance < amount) {
//            System.out.println("Insufficient funds.");
//        } else {
            balance -= amount;
//            System.out.println("Withdrawal Successful.");
        }
    }
}

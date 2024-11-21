package org.BankingSystem;

public class Account {

    //Defining Attributes

    private int accountNumber;
    private double balance;
    private String accountName;

    // Constructor

    public Account(int accountNumber, double balance, String accountName) {
        //can add validation in the constructor
//        if (accountNumber <= 0) {
//            throw new IllegalArgumentException("Account number must be positive.");
//        }
//        if (balance < 0) {
//            throw new IllegalArgumentException("Balance cannot be negative.");
//        }
//        if (accountName == null || accountName.isBlank()) {
//            throw new IllegalArgumentException("Account name cannot be null or empty.");
//        }
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
            System.out.printf("Deposit of £%.2f has been successful, your new balance is £%.2f.%n", amount, balance);
        } else {
            System.out.printf("Deposit of £%.2f is invalid, please try again.%n", amount);
        }
    }

    //Withdraw Money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else if(balance < amount) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.printf("Successfully withdrew £%.2f. New balance: £%.2f.%n", amount, balance);
        }
    }
}

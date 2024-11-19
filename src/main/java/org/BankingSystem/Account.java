package org.BankingSystem;

public class Account {

    //Defining Attributes

    private int accountNumber;
    private double balance;
    private String accountName;

    // Constructor

    public Account(int accountNumber, double balance, String accountName){
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.accountName=accountName;
    }

    // Encapsulation i.e getters and setters

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public String getAccountName(){
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    //Methods

    //Deposit Money
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.printf("Deposit of £%.2f has been successful, your new balance is £%.2f.%n", amount, balance);
        }
        else{System.out.printf("Deposit of £%.2f is invalid, please try again.%n", amount);}
    }

    //Withdraw Money
    public void withdraw(double amount){
        if(amount > 0 && balance>amount){
            balance-= amount;
            System.out.printf("Withdrawal of £%.2f has been successful, your new balance is £%.2f .%n", amount, balance);
        } else if (amount > balance) {
            System.out.println("Insufficient Funds.");
            //could add overdraft option ?
        } else{System.out.printf("Withdrawal of £%.2f is invalid, please try again.%n", amount);}
    }
}

package org.BankingSystem;

// This class is to manage multiple accounts

import java.util.HashMap;

public class Bank {

    // using a hashmap which uses key value pairs
    private HashMap<Integer, Account> accounts;

    //constructor
    public Bank(){
        accounts = new HashMap<>();
    }

    //CRUD
    //Create
    public void createAccount(int accountNumber, double balance, String accountName){
        if(accounts.containsKey(accountNumber)){
           System.out.println("This account number already exists, try again.");
        }else{
            Account newAccount = new Account(accountNumber, balance, accountName);
            accounts.put(accountNumber, newAccount);
            System.out.println("Account number " + accountNumber + " successfully created.");
        }
    }

    //Read - Find all / display all
    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found");
        } else {
            //for each account number in the (accounts array keys) list of account numbers - For each accountNumber, you retrieve its associated Account object
            for (Integer accountNumber : accounts.keySet()) {
                Account account = accounts.get(accountNumber);
                System.out.printf(
                        "Account Number: %d, Balance: £%.2f, Account Name: %s%n",
                        account.getAccountNumber(),
                        account.getBalance(),
                        account.getAccountName()
                );
            }
        }
    }

    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }


    //Update Name
    public void updateAccountName(int accountNumber, String name) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            account.setAccountName(name);
            System.out.println("Account name updated: " + name);
        } else {
            System.out.println("Account with account number: " + accountNumber + " cannot be found.");
        }
    }


    //Delete an account
    public void removeAccount(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            accounts.remove(accountNumber);
            System.out.println("Account " + accountNumber + " removed successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    // Transfer Money
    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {
        // Check if both accounts exist
        if (accounts.containsKey(fromAccountNumber) && accounts.containsKey(toAccountNumber)) {
            //Get the accounts
            Account fromAccount = accounts.get(fromAccountNumber);
            Account toAccount = accounts.get(toAccountNumber);
            // Validate the transfer amount
            if (amount <= 0) {
                System.out.println("You can't transfer zero or a negative amount. Try again.");
            } else if (amount > fromAccount.getBalance()) {
                System.out.println("Insufficient Funds.");
            } else {
                // Perform the transfer
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
                System.out.printf("Successfully transferred £%.2f from Account %d to Account %d.%n", amount, fromAccountNumber, toAccountNumber);
            }
        } else {
            System.out.println("One or both account numbers are invalid. Transfer failed.");
        }
    }
}
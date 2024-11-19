package org.BankingSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank newBank = new Bank();


        //Menu for user interaction
        while(true){
            System.out.println("\nWelcome to the Bank");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Find Account");
            System.out.println("7. Update Account Name");
            System.out.println("8. Delete Account");
            System.out.println("9. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1: // Create
                System.out.println("Enter Account Number");
                int accountNumber = scanner.nextInt();

                System.out.println("Enter Starting Balance.");
                double balance = scanner.nextDouble();

                scanner.nextLine();

                System.out.println("Enter Account Name");
                String accountName = scanner.nextLine();
                newBank.createAccount(accountNumber, balance, accountName);
                    break;

                case 2: // Deposit
                System.out.print("Enter account number: ");
                int depositAccountNumber = scanner.nextInt();
                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();



                case 3: // Withdraw

                    break;

                case 4: // Transfer

                    break;

                case 5: // Display All

                    break;

                case 6: // Find Account

                    break;

                case 7: // Update

                    break;

                case 8: // Delete

                    break;

                case 9: // Exit
                    System.out.println("Exiting the bank.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

//        Account myAccount = new Account(12345, 1234.56, "Janice Taylor");
//        Bank myBank = new Bank();
//
//        System.out.println("Account Number: " + myAccount.getAccountNumber());
//        System.out.printf("Current Balance: £%.2f%n", myAccount.getBalance());
//
//        myAccount.deposit(10.05);
//        myAccount.deposit(0);
//        myAccount.withdraw(20.40);
//        myAccount.withdraw(0);
//        myAccount.withdraw(23450.40);
//        myAccount.withdraw(-23450.40);
//        myBank.createAccount(12, 100, "John");
//        myBank.createAccount(15, 78, "Holly");
//        myBank.createAccount(14,56,"Mike");
//        myBank.getAccount(15);
//        myBank.updateAccountName(12, "Bob");
//        myBank.removeAccount(12);
//        myBank.listAccounts();
//        myBank.transfer(14,15,5);
//        myBank.transfer(14,15,100);
//        myBank.transfer(13,14,20);
//        myBank.transfer(15,14,-10);
//        myBank.transfer(15,14,0);
//        myBank.listAccounts();

    }
}
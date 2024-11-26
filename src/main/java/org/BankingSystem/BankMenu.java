package org.BankingSystem;

import java.util.Scanner;

public class BankMenu {

    // Define Attributes
    private Bank bank;
    private Scanner scanner;

    // Constructor
    public BankMenu(Bank bank){
        this.bank = bank;
        this.scanner= new Scanner(System.in);
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            handleChoice(choice);

            System.out.print("\nWould you like to do anything else? (yes/no): ");
            String continueChoice= scanner.nextLine().toLowerCase();

            // If the user says no, exit the loop and end the program
            if (continueChoice.equals("no")) {
                System.out.println("Goodbye!");
                System.out.print("\033[0m");
                break;
            }
        }
    }

    //Menu for user interaction

    private void displayMenu() {
        System.out.println("\n\033[1;4;36mWelcome to the Bank\033[0m");
        System.out.println("Choose an option below:");
        System.out.println("\033[1;36m0.\033[0m Create Account");
        System.out.println("\033[1;36m1.\033[0m Balance Enquiry");
        System.out.println("\033[1;36m2.\033[0m Deposit Money");
        System.out.println("\033[1;36m3.\033[0m Withdraw Money");
        System.out.println("\033[1;36m4.\033[0m Transfer Money");
        System.out.println("\033[1;36m5.\033[0m Update Account Name");
        System.out.println("\033[1;36m6.\033[0m Find Account");
        System.out.println("\033[1;36m7.\033[0m Display All Accounts");
        System.out.println("\033[1;36m8.\033[0m Delete Account");
        System.out.println("\033[1;36m9.\033[0m Exit");
    }

    private void handleChoice(int choice){
        // Setting text to bold and cyan
        System.out.print("\033[1;36m");
        switch(choice) {
            case 0: // Create

                System.out.println("Enter Account Number:");
                int accountNumber = scanner.nextInt();

                System.out.println("Enter Starting Balance:");
                double balance = scanner.nextDouble();

                scanner.nextLine();

                System.out.println("Enter Account Name:");
                String accountName = scanner.nextLine();
                bank.createAccount(accountNumber, balance, accountName);
                break;

            case 1: // Find Balance

                System.out.print("Enter account number:");
                int accountNumberToCheckBalance = scanner.nextInt();
                scanner.nextLine();

                Account findBalance = bank.getAccount(accountNumberToCheckBalance);
                System.out.printf(
                        "Your balance is: £%.2f",
                        findBalance.getBalance()
                );
                break;

            case 2: // Deposit

                System.out.print("Enter account number: ");
                int depositAccountNumber = scanner.nextInt();

                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();

                scanner.nextLine();

                // Use the methods in the Bank class
                Account depositAccount = bank.getAccount(depositAccountNumber);
                if (depositAccount != null){
                    depositAccount.deposit(amount);
                    System.out.printf("Balance: £%.2f%n", depositAccount.getBalance());
                } else {
                    System.out.println("Account number not found.");
                }
                break;

            case 3: // Withdraw

                System.out.print("Enter account number: ");
                int withdrawAccountNumber = scanner.nextInt();

                System.out.print("Enter amount to withdraw: ");
                double withdrawalAmount = scanner.nextDouble();

                scanner.nextLine();

                // Use the methods in the Bank class
                Account withdrawAccount = bank.getAccount(withdrawAccountNumber);
                if (withdrawAccount != null) {
                    withdrawAccount.withdraw(withdrawalAmount);
                    System.out.printf("Balance: £%.2f%n", withdrawAccount.getBalance());
                } else {
                    System.out.println("Account number not found.");
                }
                break;

            case 4: // Transfer

                System.out.print("Enter sender account number: ");
                int senderAccountNumber = scanner.nextInt();

                System.out.print("Enter receiver account number: ");
                int receiverAccountNumber = scanner.nextInt();

                System.out.print("Enter amount to transfer: ");
                double transferAmount = scanner.nextDouble();

                scanner.nextLine();

                //Use the methods in the Bank class
                if (bank.getAccount(senderAccountNumber) != null && bank.getAccount(receiverAccountNumber) != null){
                    bank.transfer(senderAccountNumber, receiverAccountNumber, transferAmount);
                } else {
                    System.out.println("Account number not found.");
                }
                break;

            case 5: // Update

                System.out.print("Enter the account number: ");
                int accountNumberToUpdate = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter the new account name: ");
                String newAccountName = scanner.nextLine();

                bank.updateAccountName(accountNumberToUpdate, newAccountName);
                break;

            case 6: // Find Account

                System.out.print("Enter account number: ");
                int findAccountNumber = scanner.nextInt();
                scanner.nextLine();

                Account findAccount = bank.getAccount(findAccountNumber);
                System.out.printf(
                        "Account Number: %d, Balance: £%.2f, Account Name: %s%n",
                        findAccount.getAccountNumber(),
                        findAccount.getBalance(),
                        findAccount.getAccountName()
                );
                break;

            case 7: // Display All

                bank.listAccounts();
                break;

            case 8: // Delete Account

                System.out.print("Enter account number to delete:");
                int accountNumberToDelete = scanner.nextInt();

                scanner.nextLine();

                // Check if the account exists
                if (bank.getAccount(accountNumberToDelete) != null) {
                    // If the account exists, remove it
                    bank.removeAccount(accountNumberToDelete);
                } else {
                    // If the account does not exist, inform the user
                    System.out.println("Account not found. Cannot delete.");
                }
                break;

            case 9: // Exit

                System.out.println("Goodbye!");
                System.out.print("\033[0m");
                scanner.close();
                System.exit(0);

                return;

            default:

                System.out.println("Invalid choice, please try again.");


        }
    }
}
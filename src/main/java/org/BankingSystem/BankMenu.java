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
                break;
            }
        }
    }

    //Menu for user interaction

    private void displayMenu() {
        System.out.println("\n\033[1mWelcome to the Bank\033[0m");
        System.out.println("\nChoose an option:");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transfer Money");
        System.out.println("5. Display All Accounts");
        System.out.println("6. Find Account");
        System.out.println("7. Update Account Name");
        System.out.println("8. Delete Account");
        System.out.println("9. Exit");

    }

    private void handleChoice(int choice){
        switch(choice) {
            case 1: // Create
                System.out.println("Enter Account Number:");
                int accountNumber = scanner.nextInt();

                System.out.println("Enter Starting Balance:");
                double balance = scanner.nextDouble();

                scanner.nextLine();

                System.out.println("Enter Account Name:");
                String accountName = scanner.nextLine();
                bank.createAccount(accountNumber, balance, accountName);
                break;

            case 2: // Deposit

                System.out.print("Enter account number: ");
                int depositAccountNumber = scanner.nextInt();

                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();

                // Use the methods in the Bank class
                Account depositAccount = bank.getAccount(depositAccountNumber);
                if (depositAccount != null){
                    depositAccount.deposit(amount);
                    System.out.printf("Deposit successful. New balance: £%.2f%n", depositAccount.getBalance());
                } else {
                    System.out.println("Account number not found.");
                }
                break;

            case 3: // Withdraw
                System.out.print("Enter account number: ");
                int withdrawAccountNumber = scanner.nextInt();

                System.out.print("Enter amount to withdraw: ");
                double withdrawalAmount = scanner.nextDouble();

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

                //Use the methods in the Bank class
                if (bank.getAccount(senderAccountNumber) != null && bank.getAccount(receiverAccountNumber) != null){
                    bank.transfer(senderAccountNumber, receiverAccountNumber, transferAmount);
                    System.out.println("Transfer successful.");
                } else {
                    System.out.println("Account number not found.");
                }
                break;

            case 5: // Display All
                bank.listAccounts();
                break;

            case 6: // Find Account

                System.out.print("Enter account number: ");
                int findAccountNumber = scanner.nextInt();
                Account findAccount = bank.getAccount(findAccountNumber);
                System.out.printf(
                        "Account Number: %d, Balance: £%.2f, Account Name: %s%n",
                        findAccount.getAccountNumber(),
                        findAccount.getBalance(),
                        findAccount.getAccountName()
                );

                break;

            case 7: // Update
                System.out.print("Enter account number: ");
                int updateAccountNameWithAccountNumber = scanner.nextInt();

                scanner.nextLine();

                System.out.println("Enter Account Name:");
                String accountNameForUpdate = scanner.nextLine();

                Account updateAccount = bank.getAccount(updateAccountNameWithAccountNumber);

                updateAccount.setAccountName(accountNameForUpdate);

                System.out.printf(
                        "Account Number: %d, Balance: £%.2f, Account Name: %s%n",
                        updateAccount.getAccountNumber(),
                        updateAccount.getBalance(),
                        updateAccount.getAccountName()
                );

                break;

            case 8: // Delete Account
                System.out.print("Enter account number to delete:");
                int accountNumberToDelete = scanner.nextInt();

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
                System.out.println("Exiting the bank.");
                scanner.close();
                System.exit(0);
                return;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }
}
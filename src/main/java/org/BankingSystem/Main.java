package org.BankingSystem;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankMenu bankMenu = new BankMenu(bank);
        bankMenu.start();
    }
}
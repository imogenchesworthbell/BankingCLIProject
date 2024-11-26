package org.BankingSystem;

public class SeedData {

    public static void loadSeedData(Bank bank){
        bank.createAccount(1,1234, "Brian");
        bank.createAccount(2, 5478,"Fred");
        bank.createAccount(3, 4332, "Sophie");
        bank.createAccount(4, 1580, "Chloe");
        bank.createAccount(5, 3689, "Isabella");
        bank.createAccount(6,6421, "Derek");
        bank.createAccount(7,1346, "Linda");
        bank.createAccount(8,2346, "Tony");
        bank.createAccount(9,3450, "Millie");
        bank.createAccount(10,5323, "Tyler");
    }
}

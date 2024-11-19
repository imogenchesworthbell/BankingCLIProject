package org.BankingSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account(102938, 1234.56, "John Smith");
    }

    @Test
    public void depositMoneyPositiveAmountTest(){
        account.deposit(30);
        assertEquals(1264.56, account.getBalance(), "Deposit of £30.00 has been successful, your new balance is £1264.56.");
    }

    @Test
    public void depositMoneyExactly0Test(){
        account.deposit(0);
        assertEquals(1234.56, account.getBalance(), "Deposit of £0 is invalid, please try again.");
    }

    @Test
    public void depositMoneyNegativeAmountTest(){
        account.deposit(-2);
        assertEquals(1234.56, account.getBalance(), "Deposit of £-2 is invalid, please try again.");
    }

    @Test
    public void withdrawMoneyPositiveAmountTest(){
        account.withdraw(20);
        assertEquals(1214.56, account.getBalance(), "Withdrawal of £20 has been successful, your new balance is £1214.56");
    }

    @Test
    public void withdrawMoneyExactly0Test(){
        account.withdraw(0);
        assertEquals(1234.56, account.getBalance(), "Withdrawal of £0 is invalid, please try again.");
    }

    @Test
    public void withdrawMoneyNegativeAmountTest(){
        account.withdraw(-20);
        assertEquals(1234.56, account.getBalance(), "Withdrawal of £-20 is invalid, please try again.");
    }

    @Test
    public void withdrawMoreMoneyThanAllowedTest(){
        account.withdraw(2000);
        assertEquals(1234.56, account.getBalance(), "Insufficient Funds.");
    }
}

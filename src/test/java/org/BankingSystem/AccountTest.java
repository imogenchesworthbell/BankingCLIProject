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
    public void depositMoneyPositiveAmountTest() {
        account.deposit(30);
        assertEquals(1264.56, account.getBalance(), "Balance should reflect successful deposit of £30.");
    }

    @Test
    public void depositMoneyExactly0Test() {
        account.deposit(0); // Should do nothing
        assertEquals(1234.56, account.getBalance(), "Balance should remain unchanged for a deposit of £0.");
    }

    @Test
    public void depositMoneyNegativeAmountTest() {
        account.deposit(-2); // Should do nothing
        assertEquals(1234.56, account.getBalance(), "Balance should remain unchanged for a negative deposit.");
    }

    @Test
    public void withdrawMoneyPositiveAmountTest() {
        account.withdraw(20);
        assertEquals(1214.56, account.getBalance(), "Balance should reflect successful withdrawal of £20.");
    }

    @Test
    public void withdrawMoneyExactly0Test() {
        account.withdraw(0); // Should do nothing
        assertEquals(1234.56, account.getBalance(), "Balance should remain unchanged for a withdrawal of £0.");
    }

    @Test
    public void withdrawMoneyNegativeAmountTest() {
        account.withdraw(-20); // Should do nothing
        assertEquals(1234.56, account.getBalance(), "Balance should remain unchanged for a negative withdrawal.");
    }

    @Test
    public void withdrawMoreMoneyThanAllowedTest() {
        account.withdraw(2000); // Should subtract even if insufficient funds
        assertEquals(-765.44, account.getBalance(), "Balance should reflect overdraft after withdrawal of £2000.");
    }
}

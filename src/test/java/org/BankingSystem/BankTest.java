package org.BankingSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    private Bank bank;

    @BeforeEach
    public void setUp(){
        bank = new Bank();
    }

    //CREATE ACCOUNTS TESTS

    @Test
    public void createAccountAllValidInputsTest(){
    bank.createAccount(12,1000,"Tom");
    Account account = bank.getAccount(12);
    assertNotNull(account,"Account successfully created");
    assertEquals(12, account.getAccountNumber());
    assertEquals(1000.00,account.getBalance());
    assertEquals("Tom", account.getAccountName());
    }

    @Test
    public void createAccountInvalidAccountNumberInputTest(){
        bank.createAccount(-1,1000,"Tom");
        Account account = bank.getAccount(-1);
        assertNull(account, "Account has an invalid account number so can't be created.");
    }

    @Test
    public void createAccountWithAccountNumberThatAlreadyExistsTest(){
        bank.createAccount(12,1000,"Tom");
        bank.createAccount(12,400,"Billy");
        Account account = bank.getAccount(12);
        assertNotNull(account, "Account can't be duplicated.");
        assertEquals(1000.00, account.getBalance(), "Balance shouldn't change when a duplicate account is attempted.");
    }

    @Test
    public void createAccountInvalidBalanceNegativeNumberTest(){
        bank.createAccount(1,-1000,"Tom");
        Account account = bank.getAccount(1);
        assertNull(account, "Can't create an account with a negative balance.");
    }
    @Test
    public void createAccountInvalidNameTest(){
        bank.createAccount(1,1000,"");
        Account account = bank.getAccount(1);
        assertNull(account, "Must have an account name.");
    }

    //LIST ACCOUNTS TESTS
    @Test
    public void listAccountsTest(){
        bank.createAccount(1,1000,"Bob");
        Account account = bank.getAccount(1);
        assertNotNull(account, "Listing accounts shouldn't be null.");
    }

    @Test
    public void listAccountsWhenNoneExistTest(){
        Account account = bank.getAccount(1);
        assertNull(account, "When there are 0 accounts, listing accounts should be null.");
    }

    //GET ACCOUNTS TESTS
    @Test
    public void getAccountInvalidAccountNumberTest(){
        Account account = bank.getAccount(99);
        assertNull(account, "Account can't be as non-existent account number.");
    }

    //UPDATE ACCOUNT NAME TESTS
    @Test
    public void updateAccountNameTest(){
        bank.createAccount(1,1000,"Bob");
        bank.updateAccountName(1, "Bob");
        Account account = bank.getAccount(1);
        assertEquals("Bob", account.getAccountName(), "Account name should be updated.");
    }
    @Test
    public void updateAccountNameInvalidInputTest(){
        bank.createAccount(1, 1000, "Bob");
        bank.updateAccountName(1, "");  // Invalid name (empty)
        Account account = bank.getAccount(1);
        assertEquals("Bob", account.getAccountName(), "Account name shouldn't change.");
    }

    //REMOVE ACCOUNT TESTS
    @Test
    public void removeAccountTest(){
        bank.createAccount(1, 1000, "Bob");
        bank.removeAccount(1);
        Account account = bank.getAccount(1);
        assertNull(account, "Account should be removed.");
    }

    //TRANSFER TESTS
    @Test
    public void transferValidInputsTest(){
        bank.createAccount(1, 600.00, "Tom");
        bank.createAccount(2, 400.00, "Sam");
        bank.transfer(1, 2, 100.00);

        Account fromAccount = bank.getAccount(1);
        Account toAccount = bank.getAccount(2);

        assertEquals(500.00, fromAccount.getBalance(), "Balance should reflect the withdrawal.");
        assertEquals(500.00, toAccount.getBalance(), "Balance should reflect the deposit.");
    }
    @Test
    public void transferInvalidAccountNumberTest(){
        bank.createAccount(1, 600.00, "Tom");
        bank.createAccount(2, 400.00, "Sam");
        bank.transfer(1, 3, 100.00);

        Account fromAccount = bank.getAccount(1);
        Account toAccount = bank.getAccount(2);

        assertEquals(600.00, fromAccount.getBalance(), "Balance should stay unchanged.");
        assertEquals(400.00, toAccount.getBalance(), "Balance should stay unchanged.");
    }
    @Test
    public void transferInsufficientFundsTest(){
        bank.createAccount(1, 600.00, "Tom");
        bank.createAccount(2, 400.00, "Sam");
        bank.transfer(1, 2, 1000.00);

        Account fromAccount = bank.getAccount(1);
        Account toAccount = bank.getAccount(2);

        assertEquals(600.00, fromAccount.getBalance(), "Balance should stay unchanged.");
        assertEquals(400.00, toAccount.getBalance(), "Balance should stay unchanged.");
    }

    @Test
    public void transferNegativeAmountTest(){
        bank.createAccount(1, 600.00, "Tom");
        bank.createAccount(2, 400.00, "Sam");
        bank.transfer(1, 2, -100.00);

        Account fromAccount = bank.getAccount(1);
        Account toAccount = bank.getAccount(2);

        assertEquals(600.00, fromAccount.getBalance(), "Balance should stay unchanged.");
        assertEquals(400.00, toAccount.getBalance(), "Balance should stay unchanged.");
    }
    @Test
    public void transferZeroAmountTest(){
        bank.createAccount(1, 600.00, "Tom");
        bank.createAccount(2, 400.00, "Sam");
        bank.transfer(1, 2, 0.00);

        Account fromAccount = bank.getAccount(1);
        Account toAccount = bank.getAccount(2);

        assertEquals(600.00, fromAccount.getBalance(), "Balance should stay unchanged.");
        assertEquals(400.00, toAccount.getBalance(), "Balance should stay unchanged.");
    }
    @Test
    public void transferToTheSameAccountTest(){
        bank.createAccount(1, 600.00, "Tom");
        bank.transfer(1, 1, 1000.00);

        Account fromAccount = bank.getAccount(1);
        Account toAccount = bank.getAccount(1);

        assertEquals(600.00, fromAccount.getBalance(), "Balance should stay unchanged.");

    }



}


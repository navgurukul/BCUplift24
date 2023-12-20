package org.uplift.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uplift.Exceptions.InsufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    private SavingsAccount savingsAccount;
    private static final double ACCOUNT_BALANCE=124.9;
    private static final double OD_LIMIT=500;
    private User user;

    @BeforeEach
    void setUp() {
        user=new User("Nisha","59847984","nisha@gmail.com","umang","1243");
        savingsAccount=new SavingsAccount(user,ACCOUNT_BALANCE,"321431",new Date(),OD_LIMIT);
    }

    @Test
    void showBalance() {
       assertEquals(124.9,savingsAccount.showBalance());
    }

    @Test
    void deposit() {
        double expectedBalance=ACCOUNT_BALANCE+1000;
        savingsAccount.deposit(1000);
        assertEquals(expectedBalance,savingsAccount.showBalance());
    }

    @Test
    void withdraw() throws InsufficientBalanceException {
        double expectedBalance=ACCOUNT_BALANCE;
        assertEquals(expectedBalance,savingsAccount.withdraw(1000));
    }
    @Test
    public void withdrawOverdraftLimit() throws InsufficientBalanceException{
        double expectedBalance= -OD_LIMIT;
        assertEquals(expectedBalance,savingsAccount.withdraw(ACCOUNT_BALANCE+OD_LIMIT));
    }
    @Test
    void withdrawWithODLimitBreach() {
        assertThrows(InsufficientBalanceException.class,()->savingsAccount.withdraw(ACCOUNT_BALANCE+OD_LIMIT+1));
    }
}
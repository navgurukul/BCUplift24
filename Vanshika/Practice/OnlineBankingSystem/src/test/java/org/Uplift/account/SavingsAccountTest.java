package org.Uplift.account;

import org.Uplift.exception.InsufficientBalanceException;
import org.Uplift.user.User;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    private SavingsAccount sa;
    private User user;
    private static final double ACCOUNT_BALANCE = 12345.25;
    private static final double OVERDRAFT_LIMIT = 500;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        user = new User("Umang Doctor", "+91-8368041416", "umang@uplift.org", "umang", "Umang@123");
        sa = new SavingsAccount(user, "1234",ACCOUNT_BALANCE, new Date(),OVERDRAFT_LIMIT );
    }

    @org.junit.jupiter.api.Test
    void showBalance() {
        assertEquals(ACCOUNT_BALANCE, sa.showBalance());
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        double expectedBalance = ACCOUNT_BALANCE +1000;
        assertEquals(expectedBalance, sa.deposit(1000));
    }

    @org.junit.jupiter.api.Test
    void withdraw() throws InsufficientBalanceException {
        double expectedBalance = ACCOUNT_BALANCE - 1000;
        assertEquals(expectedBalance, sa.withdraw(1000));
    }

    @Test
    void withdrawWithODLimit() throws InsufficientBalanceException {
        assertEquals(-OVERDRAFT_LIMIT, sa.withdraw(ACCOUNT_BALANCE+OVERDRAFT_LIMIT));
    }

    @Test
    void withdrawWithODLimitBreach(){
        assertThrows(InsufficientBalanceException.class, ()-> sa.withdraw(ACCOUNT_BALANCE+OVERDRAFT_LIMIT+1));
    }
}
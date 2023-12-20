package org.uplift.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.uplift.exception.InsufficientAccountBalanceException;
import org.uplift.user.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    private SavingsAccount sa;
    private User user;
    private static final double ACCOUNT_BALANCE = 12345.25;
    private static final double OD_LIMIT = 500;

    @BeforeEach
    void setUp() {
        user = new User("user1", "9750923441", "user1@gmail.com",
                "us234", "123");

        sa = new SavingsAccount(user, "1234", ACCOUNT_BALANCE
                , new Date(), OD_LIMIT);
    }

    @Test
    void showBalance() {
        assertEquals(ACCOUNT_BALANCE, sa.showBalance());
    }

    @Test
    void deposit() {
        double expectedBalance = ACCOUNT_BALANCE + 1000;
        assertEquals(expectedBalance, sa.deposit(1000));
    }

    @Test
    void withdraw() throws InsufficientAccountBalanceException {
        double expectedBalance = ACCOUNT_BALANCE - 1000;
        assertEquals(expectedBalance, sa.withdraw(1000));
    }

    @Test
    void withdrawWithODLimit() throws InsufficientAccountBalanceException {
        assertEquals(-OD_LIMIT, sa.withdraw(ACCOUNT_BALANCE+ OD_LIMIT));
    }

    @Test
    void withdrawWithODLimitBreach() {
        assertThrows(InsufficientAccountBalanceException.class,
                ()->sa.withdraw(ACCOUNT_BALANCE + OD_LIMIT+1));
    }
}
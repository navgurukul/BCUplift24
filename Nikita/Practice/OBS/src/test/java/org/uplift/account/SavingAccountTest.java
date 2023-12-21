package org.uplift.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {
    private SavingAccount sa;
    private static final double ACCOUNT_BALANCE = 900000;
    private static final double OVERDRAFT_LIMIT = 12000;
    private User user = new User("nikita dagwar", "9307025958", "Ndgwar", "nk12345");

    @BeforeEach
    void setUp() {
        sa = new SavingAccount(user, "1234", ACCOUNT_BALANCE, new Date(), OVERDRAFT_LIMIT);
    }

    @Test
    void showBalance() {
        assertEquals(ACCOUNT_BALANCE, sa.showBalance());
    }

    @Test
    void deposit() {
        double expectedBalance = ACCOUNT_BALANCE + 10000;
        assertEquals(expectedBalance, sa.deposit(10000));
    }

    @Test
    void withdraw() throws InsufficientBalanceException {
        double expectedBalance = ACCOUNT_BALANCE - 10000;
        assertEquals(expectedBalance, sa.withdraw(10000));
    }

    @Test
    void withdrawWithOdLimit() throws InsufficientBalanceException {
        assertEquals(-OVERDRAFT_LIMIT, sa.withdraw(ACCOUNT_BALANCE + 12000));
    }

    @Test
    void withdrawWithODLimitBreach() {
        assertThrows(InsufficientBalanceException.class, () -> sa.withdraw(ACCOUNT_BALANCE + OVERDRAFT_LIMIT + 1));
    }
}
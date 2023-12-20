package org.uplift.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.User.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    private SavingsAccount sa;
    private User user;
    private static final double ACCOUNT_BALANCE = 1000.0;
    private static final double OD_LIMIT = 500.0;

    @BeforeEach
    void setup(){
        user = new User("Neha Dhore","9370838558","@neha","1234");
        sa = new SavingsAccount(user,"123",1000.0,new Date(),OD_LIMIT);

    }

    @Test
    void showBalance() {
        assertEquals(ACCOUNT_BALANCE,sa.showBalance());
    }

    @Test
    void deposit() {
        double expectedBalance = ACCOUNT_BALANCE+sa.showBalance();
        sa.deposit(1000.0);
        assertEquals(expectedBalance,sa.showBalance());
    }

    @Test
    void withdraw()throws InsufficientBalanceException {
        double expectedBalance = ACCOUNT_BALANCE - 100.0;
        assertEquals(expectedBalance,sa.withdraw(100.0));
    }
    @Test
    void withdrawawWithLimit()throws InsufficientBalanceException{
//        double expectedBalance = - 500.0;
        assertEquals(-500.0,sa.withdraw(ACCOUNT_BALANCE+OD_LIMIT));
    }
    @Test
    void withdrawawWithOverdraftLimitBreach() {
        assertThrows(InsufficientBalanceException.class,()->sa.withdraw(ACCOUNT_BALANCE+ OD_LIMIT+1));

    }
}
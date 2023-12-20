package org.uplift.account;

import org.junit.jupiter.api.Test;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {
    private User user;
    private SavingAccount sa;
    private static final double ACCOUNT_BALANCE= 2000;
    private static final double OD_LIMIT=500;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        user= new User("Harsha Chandurkar","9087654321","harsha@gamil.com","harsha","harsha123");

        sa= new SavingAccount(user,"123",ACCOUNT_BALANCE,new Date(), 500);
    }

    @org.junit.jupiter.api.Test
    void showBalance() {
        assertEquals(ACCOUNT_BALANCE,sa.showBalance());

    }

    @org.junit.jupiter.api.Test
    void deposit() {
        double expectedBalance=ACCOUNT_BALANCE +1000;
        assertEquals(expectedBalance,sa.deposit(1000));
    }

    @org.junit.jupiter.api.Test
    void withdraw() throws InsufficientBalanceException {
        double expectedBalance = ACCOUNT_BALANCE-1000;
        assertEquals(expectedBalance,sa.withdraw(1000));
    }

    @Test
    void withdrawWithOverdraftLimit() throws InsufficientBalanceException {
        double expectedBalance =-500;
        assertEquals(-500,sa.withdraw(ACCOUNT_BALANCE+500));
    }
    @Test
    void withdrawWithOverdraftLimitBreach(){
        assertThrows(InsufficientBalanceException.class,()->sa.withdraw(ACCOUNT_BALANCE + OD_LIMIT +1));
    }
}


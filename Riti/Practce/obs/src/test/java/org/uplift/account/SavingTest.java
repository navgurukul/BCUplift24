package org.uplift.account;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uplift.exceptions.InsuffucentBalanceException;
import org.uplift.user.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SavingTest {
    private Saving saving;
    private User user;
    private  static final double ACCOUNT_BALANCE=20000.0;
    private static final double OVERDRAFTLIMIT=500;
    @BeforeEach
    void setUp() {
        user=new User("Riti Sharma","ritisharma12@gmail.com","123456","riti_sharma","riti@12345");
        saving=new Saving(user,"1234",ACCOUNT_BALANCE,new Date(),OVERDRAFTLIMIT);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testShowBalance() {
        assertEquals(ACCOUNT_BALANCE,saving.getBalance());
    }

    @Test
    void deposit() {

        double amouunt=1000;
        double expected=ACCOUNT_BALANCE+amouunt;

        assertEquals(expected,saving.deposit(amouunt));
    }
    @Test
    void withdraw() throws InsuffucentBalanceException {
        double amouunt=1000;
        double expected=ACCOUNT_BALANCE-amouunt;
        assertEquals(expected,saving.withdraw(amouunt));
    }
    @Test
    void testWithdrowWithOverdraftLimit() throws InsuffucentBalanceException {
        assertEquals(-OVERDRAFTLIMIT,saving.withdraw(ACCOUNT_BALANCE+OVERDRAFTLIMIT));

    }
    @Test
    void testWithdrowWithOverdraftLimitBreach()throws InsuffucentBalanceException {
        assertThrows(InsuffucentBalanceException.class,()->saving.withdraw(ACCOUNT_BALANCE+OVERDRAFTLIMIT+1));

    }

}
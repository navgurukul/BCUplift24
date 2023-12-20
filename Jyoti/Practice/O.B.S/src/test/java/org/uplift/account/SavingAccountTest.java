package org.uplift.account;

import org.junit.jupiter.api.*;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.user.*;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {
    private SavingAccount sa;
    private User user;
    private static final double ACCOUNT_BALANCE =1200.20;
    private static final double OD_LIMIT =1200.20;

    @BeforeEach
    void setUp(){
        user = new User("jyoti","234564566","ashwini@gmail.com","ashwini12","ashwini@123");

        sa = new SavingAccount("1234","ashwini",ACCOUNT_BALANCE,new Date(),user, 500);

    }
    @Test
    void testShowBalance(){
        assertEquals(ACCOUNT_BALANCE,sa.showBalance());

    }

    @Test
    void testDeposit(){
        double exceptedBalance = ACCOUNT_BALANCE +1000;
        sa.deposit(1000);
        assertEquals(exceptedBalance,sa.showBalance());

    }
    @Test
    void testWithdraw() throws InsufficientBalanceException {
        double exceptionBalance = ACCOUNT_BALANCE - 1000;
        assertEquals(exceptionBalance ,sa.withdraw(1000));

    }
    @Test
    void testWithdrawWithODLimit() throws InsufficientBalanceException {
        assertEquals(-500,sa.withdraw(ACCOUNT_BALANCE +500));

    }
    @Test
    void withdrawWithODLimitBreach(){
        assertThrows(InsufficientBalanceException.class,()->sa.withdraw(ACCOUNT_BALANCE+OD_LIMIT+1));
    }
}
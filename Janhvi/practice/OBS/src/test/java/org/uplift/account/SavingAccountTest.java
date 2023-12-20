package org.uplift.account;

import org.junit.jupiter.api.Test;
import org.uplift.exception.InSufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {
    private SavingAccount sa;
    private User user;
    private static final double ACCOUNT_BALANCE = 12345.25;
    private static final double OD_LIMIT = 500;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        user = new User("janhvi","123456","janhvi@email.com","janhvishende","1234");
        sa = new SavingAccount(user,"1234",ACCOUNT_BALANCE,new Date(),OD_LIMIT );
    }

    @org.junit.jupiter.api.Test
    void testForShowingBalance() {
        assertEquals(ACCOUNT_BALANCE,sa.showBalance());
    }

    @org.junit.jupiter.api.Test
    void testForDeposit() {
        double expectedBalance = ACCOUNT_BALANCE + 1000;
        assertEquals(expectedBalance,sa.deposit(1000));

    }

    @org.junit.jupiter.api.Test
    void testForWithdraw()throws InSufficientBalanceException {
        double expectedBalance = ACCOUNT_BALANCE -1000;
        assertEquals(expectedBalance,sa.withdraw(1000));
    }

    @Test
    void withdrawWithODLimit() throws InSufficientBalanceException{
        double expectedBalance =- 500;
        assertEquals(-500,sa.withdraw(ACCOUNT_BALANCE+500));

    }

    @Test
    void withdrawWithODLimitBreach(){
        assertThrows(InSufficientBalanceException.class,()->sa.withdraw(ACCOUNT_BALANCE + OD_LIMIT + 1));
    }
}
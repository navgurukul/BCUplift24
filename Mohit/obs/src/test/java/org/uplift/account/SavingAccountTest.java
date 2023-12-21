package org.uplift.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uplift.exception.InSufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {
    private static final double ACCOUNT_BALANCE =90000 ;
    private static final double OD_LIMIT =500;
    private SavingAccount sa;
    private User user;

    @BeforeEach

    void setUp(){
        sa=new SavingAccount(user,ACCOUNT_BALANCE,"123",new Date(),OD_LIMIT);

        user=new User("mohit","987654","mohit@gmail.com","mohit raj","12");
    }
    @Test
    void showBalance() {
        assertEquals(2000,sa.showBalance());

    }

    @Test
    void deposite() {
        double expectedBalance=ACCOUNT_BALANCE+1000;
        assertEquals(expectedBalance,sa.deposite(1000));
    }

    @Test
    void withdraw() throws InSufficientBalanceException {
        double expectedBalance=ACCOUNT_BALANCE-1000;
        assertEquals(expectedBalance,sa.withdraw(1000));
    }
    @Test
    void withdrawOverLimit() throws InSufficientBalanceException {
        double exceptedBalance=ACCOUNT_BALANCE-OD_LIMIT;
        assertEquals(-OD_LIMIT,sa.withdraw(ACCOUNT_BALANCE+OD_LIMIT));
    }

    @Test
    void withDrawWithODLimitBreach(){
        assertThrows(InSufficientBalanceException.class,()->sa.withdraw(ACCOUNT_BALANCE+OD_LIMIT+1));

    }
}
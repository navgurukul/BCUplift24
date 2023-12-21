package org.uplift.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    private SavingsAccount sa;
    private User user;
    private static final double ACCOUNT_BALANCE=1000.0;
    private static final double OD_LIMIT=200;
    @BeforeEach
    void setUp(){
        user=new User("rakhi","12345","rakhi@22","rakhi12","ra23908");
        sa=new SavingsAccount(user,"12A",ACCOUNT_BALANCE,new Date(),OD_LIMIT );
    }

    @Test
    void deposit() {
        double expectedBalance=ACCOUNT_BALANCE+100;
        assertEquals(expectedBalance,sa.deposit(100));
    }

    @Test
    void showBalance() {
        assertEquals(1000.0,sa.showBalance());
    }

    @Test
    void withdraw() throws InsufficientBalanceException{
        double exceptedBalance=ACCOUNT_BALANCE-100;
        assertEquals(exceptedBalance,sa.withdraw(1000));
    }

    @Test
    void withdrawWithODLimit() throws InsufficientBalanceException{
//        double expectedBalance=ACCOUNT_BALANCE-200;
        assertEquals(-200,sa.withdraw(ACCOUNT_BALANCE+OD_LIMIT));

    }

    @Test
    void withdrawWithODLimitBreach(){
        assertThrows(InsufficientBalanceException.class,()->sa.withdraw(ACCOUNT_BALANCE+OD_LIMIT+1));
    }
}

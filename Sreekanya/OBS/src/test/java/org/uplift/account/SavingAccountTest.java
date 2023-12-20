package org.uplift.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uplift.exception.InvalidSufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {
    private SavingAccount sa;
    private User user;
    private static final double ACCOUNT_BALANCE=5000.0;
    private static final double OD_LIMIT=500.0;

    @BeforeEach
    void setup(){
        user=new User("name1","+91-59598752","email.com","username1","1234");
        sa=new SavingAccount(user,"1234",ACCOUNT_BALANCE,new Date(),OD_LIMIT );
    }
    @Test
    void testWithDraw() throws InvalidSufficientBalanceException {
        double expectedBalance=ACCOUNT_BALANCE-1000;
        assertEquals(expectedBalance,sa.withDraw(1000.0));


    }
    @Test
    void testDeposit(){
        double expectedBalance=ACCOUNT_BALANCE+1000;
        assertEquals(expectedBalance,sa.deposit(1000.0));


    }
    @Test

    void testShowBalance(){
        assertEquals(ACCOUNT_BALANCE,sa.showBalance());

    }
    @Test
    public void testWithDrawOverLimit() throws InvalidSufficientBalanceException {
        //double expextedBalance=-500;
        assertEquals(-OD_LIMIT,sa.withDraw(ACCOUNT_BALANCE+OD_LIMIT));

    }
    @Test
    public void testWithDrawWithODLimitBreach(){
        assertThrows(InvalidSufficientBalanceException.class,()->sa.withDraw(ACCOUNT_BALANCE+OD_LIMIT+1));

    }

}
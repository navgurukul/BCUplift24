package org.uplift.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


public class SavingsAccountTest {
    private SavingsAccount sa;
    private User user;
    private static final double ACCOUNT_BALANCE = 1000.0;
    private static final double OD_LIMIT = 500.0;

    @BeforeEach
    void setUp(){
        user= new User("Jainab","9999817598","jainab123@gmail.com","jainab_13","1303");
        sa=  new SavingsAccount( user,"Ac1234", ACCOUNT_BALANCE, new Date(),OD_LIMIT);
    }
    @Test
    public void withdraw() throws InsufficientBalanceException{
        double expectedBalance= ACCOUNT_BALANCE-700.0;
        assertEquals(expectedBalance,sa.withdraw(700.0));

    }
    @Test
    public void deposit(){
        double expectedBalance =ACCOUNT_BALANCE+500.0;
        sa.deposit(500.0);
        assertEquals(expectedBalance, sa.showBalance());

    }
    @Test
    public void showBalance(){
        assertEquals(ACCOUNT_BALANCE,sa.showBalance());
    }

    @Test
    public void withdrawWithOdLimit() throws InsufficientBalanceException {
        double expectedBalance = -500;
        assertEquals(expectedBalance, sa.withdraw(ACCOUNT_BALANCE+OD_LIMIT));
    }
    @Test
    public void withdrawWithODLimitBreach() throws InsufficientBalanceException{

        assertThrows(InsufficientBalanceException.class,
                ()-> sa.withdraw(ACCOUNT_BALANCE+OD_LIMIT+1));
    }



}
package com.uplift.account;

import com.uplift.exceptions.InsufficietBalanceException;
import com.uplift.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.InvalidPropertiesFormatException;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    private SavingsAccount sa;
    private User user;
    private static final double ACCOUNT_BALANCE=12345.25;

    private static final double OVERDRAFT_LIMIT= 500;
    @BeforeEach
    void setUp(){
        user = new User("Umang","+91-79782739232","umang@uplift123","Umang","umang@123");
        sa = new SavingsAccount(user,"1234",ACCOUNT_BALANCE,new Date(),OVERDRAFT_LIMIT );
    }

    @Test
    void showBalance(){
        assertEquals(12345.25,sa.showBalance());
    }

    @Test
    void deposit(){
        double expectedBalance = ACCOUNT_BALANCE+1000;
        assertEquals(expectedBalance,sa.deposit(1000));
    }

    @Test
    void withdraw() throws InsufficietBalanceException{
        double expectedBalance = ACCOUNT_BALANCE-1000;
        assertEquals(expectedBalance,sa.withdraw(1000));

    }

    @Test
    void withdrawWithOverdraftLimit() throws InsufficietBalanceException {
        assertEquals(-500,sa.withdraw(ACCOUNT_BALANCE+OVERDRAFT_LIMIT));
    }

    @Test
    void withdrawOverdraftLimitBreach(){
        assertThrows(InsufficietBalanceException.class,()->sa.withdraw(ACCOUNT_BALANCE+OVERDRAFT_LIMIT+1));
    }

}
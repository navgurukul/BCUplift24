package org.uplift.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uplift.User.User;
import org.uplift.exception.InsufficientBalanceException;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {
    private SavingAccount savingAccount;
    private User user ;
    private static final Double ACCOUNT_BALANCE = 10000.0;
    @BeforeEach
    void setUp(){
        user = new User("Ankit","ak","ak@12","8765345678","ankit@gmail.com");
        savingAccount=new SavingAccount(user,"1234567",ACCOUNT_BALANCE,new Date());
    }
    @Test
    void checkBalance() {
        assertEquals(ACCOUNT_BALANCE,savingAccount.checkBalance());
    }

    @Test
    void deposit() {
        double actualBalance = savingAccount.deposit(1000);
        double expectedBalance = ACCOUNT_BALANCE+1000;
        assertEquals(expectedBalance,actualBalance);
    }

    @Test
    void withdraw() throws InsufficientBalanceException {
        double actualBalance = savingAccount.withdraw(1000);
        double expectedBalance = ACCOUNT_BALANCE-1000;
        assertEquals(expectedBalance,actualBalance);
        assertThrows(InsufficientBalanceException.class,()-> savingAccount.withdraw(11000));

    }
}
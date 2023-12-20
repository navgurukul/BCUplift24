package org.uplift.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uplift.user.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {


    private SavingAccount sa;
    private User user;
    private static final double ACCOUNT_BALANCE = 12345.25;
    private  static final double OD_LIMIT = 500;

    @BeforeEach
    void setUp(){
        user = new User("Vaishnavi Hemane","9730246096","vaishnavihemane786@gmail.com", "vaishnavi","Vaish44");
        sa = new SavingAccount(user,"A1234",12345.25, new Date(),OD_LIMIT );

    }

    @Test
    void showBalance() {
        assertEquals(ACCOUNT_BALANCE,sa.showBalance());
    }

    @Test
    void deposit() {
        double expectedBalance = ACCOUNT_BALANCE + 1000;
        assertEquals(expectedBalance,sa.deposit(1000));
    }

    @Test
    void withdraw() throws  InsufficientBalanceException{
        double expectedBalance = ACCOUNT_BALANCE - 1000;
        assertEquals(expectedBalance,sa.withdraw(1000));
    }

    @Test
    void withdrawWithODLimit() throws InsufficientBalanceException{

        assertEquals(-OD_LIMIT,sa.withdraw(ACCOUNT_BALANCE + OD_LIMIT));

    }


    @Test
    void withdrawWithODLimitBreach(){
        assertThrows(InsufficientBalanceException.class,
                () -> sa.withdraw(ACCOUNT_BALANCE+OD_LIMIT+1));
    }
}
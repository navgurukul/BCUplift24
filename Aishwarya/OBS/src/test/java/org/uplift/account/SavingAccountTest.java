package org.uplift.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uplift.user.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {
    private SavingAccount sa;
    private User user;
    private static final double ACCOUNT_BALANCE = 12563.5;
    public static final double OD_LIMIT = 500;

    @BeforeEach
    void setUp(){
        user = new User("Aishwarya Harode", "9874523614", "aishwarya@gmail.com","Aish23", "1234" );

        sa = new SavingAccount(user, "125632", ACCOUNT_BALANCE, new Date(), 500);
    }

    @Test
    void showBalance(){
        assertEquals(ACCOUNT_BALANCE, sa.showBalance());
    }

    @Test
    void deposit(){
        double exceptedBalance = ACCOUNT_BALANCE + 1000;

        assertEquals( exceptedBalance, sa.deposit(1000 ) );
    }


    @Test
    void withdraw() throws InsufficientBalanceException {
        double expectedBalance  = ACCOUNT_BALANCE -1000;
        assertEquals( expectedBalance, sa.withdraw( 1000 ) );
    }


    @Test
    void withdrawWithOverDraftLimit() throws InsufficientBalanceException {

        double expectedBalance = -OD_LIMIT;
        assertEquals(expectedBalance, sa.withdraw( ACCOUNT_BALANCE+ OD_LIMIT ));

    }


    @Test
    void withdrawWithOverDraftLimitBreach(){
        assertThrows( InsufficientBalanceException.class, () -> sa.withdraw(ACCOUNT_BALANCE +OD_LIMIT+1) );
    }
}
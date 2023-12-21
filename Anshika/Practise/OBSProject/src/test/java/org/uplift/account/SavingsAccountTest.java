package org.uplift.account;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uplift.user.User;

import javax.naming.InsufficientResourcesException;
import java.util.Date;

class SavingsAccountTest {

    private SavingsAccount sa;
    private User user;
    private static final double OD_LIMIT=500;

    private static final double ACCOUNT_BALANCE=1234.25;
    @BeforeEach
    void setUp(){
        user=new User("Anshika","7042024614","anshikak22@navgurukul.org",
                "anshikakp05","anshikaKP@nav123");
        sa=new SavingsAccount(user,"A1234",ACCOUNT_BALANCE,new Date(),500 );
    }
    @Test
    void showBalance(){
        assertEquals(ACCOUNT_BALANCE,sa.showBalance());
    }

    @Test
    void deposit(){
        double expectedBalance=ACCOUNT_BALANCE+1000;
        sa.deposit(1000);
        assertEquals(expectedBalance,sa.deposit(1000));
    }

    @Test
    void withdraw()throws Exception{
        double expectedBalance=ACCOUNT_BALANCE-1000;
        sa.withdraw(1000);
        assertEquals(expectedBalance,sa.withdraw());
    }

    @Test
    void withdrawWithODLimit() throws Exception{
        double expectedBalance=-OD_LIMIT;
        assertEquals(-OD_LIMIT,sa.withdraw(ACCOUNT_BALANCE+500));
    }

    @Test
    void withdrawWithODLimitBreach(){
        assertThrows(InsufficientResourcesException.class,
                ()->sa.withdraw(OD_LIMIT) );
    }




}
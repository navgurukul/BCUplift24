package org.uplift.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uplift.exception.InvalidSufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SavingsAccountTest {
    private SavingsAccount sa;
    private User user;
    private static final double ACCOUNT_BALANCE=5000.0;
    private static final double OD_Limit= 500;

    @BeforeEach
    void setup() {
        user = new User("name1","630542573","rukku@mail.com","rukku@123","2221");
        sa = new SavingsAccount(user,"1234",ACCOUNT_BALANCE,new Date(),OD_Limit);

    }
    @Test
    void showBalance() {
        assertEquals(ACCOUNT_BALANCE,sa.showBalance());

    }
    @Test
    void deposit(){
        double expectedBalance = ACCOUNT_BALANCE+1000;
        assertEquals(expectedBalance,sa.deposit(1000));


    }
    @Test
    void withDraw() throws InvalidSufficientBalanceException {
        double expectedBalance = ACCOUNT_BALANCE-1000;
        assertEquals(expectedBalance,sa.withDraw(1000));

    }
    @Test
    void withdrawLimit() throws InvalidSufficientBalanceException {
        double expectedBalance=-500;
        assertEquals(-500,sa.withDraw(ACCOUNT_BALANCE+500));
    }
    @Test
    void withdrawWithODLimitBreach(){
        assertThrows(InvalidSufficientBalanceException.class,()->sa.withDraw(ACCOUNT_BALANCE+500+1));

    }


}
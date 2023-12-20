package org.uplift.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.uplift.account.exception.InsufficientBalanceException;
import org.uplift.account.user.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {
    private SavingAccount sa;
    private User user;
    private static final double Account_Balance = 50000.0;
    private static final double OD_Limit = 500;
    @BeforeEach
    void setup() {
        user = new User("priyanka","9075367109","priyankaadhomne@423","PriyankaDhomne","Priya@123");
        sa = new SavingAccount(user,"1233Ac",Account_Balance,new Date(),500.0 );
    }

    @Test
    void showBalance() {
        assertEquals(Account_Balance,sa.showBalance());
    }

    @Test
    void deposit() {
        double expectedBalance = Account_Balance + 1000;
        assertEquals(expectedBalance, sa.deposit(1000));
    }

    @Test
    void withdraw() throws InsufficientBalanceException {
        double expectedBalance = Account_Balance - 1000;
        assertEquals(expectedBalance,sa.withdraw(1000));
    }

    @Test
    void withdrawWithOverdraftLimit() throws InsufficientBalanceException {
        double expectedBalance = - 500;
        assertEquals(expectedBalance,sa.withdraw(Account_Balance+OD_Limit));
    }
    @Test
    void withdrawWithOOLimitBreach() {
        assertThrows(InsufficientBalanceException.class,()->sa.withdraw(Account_Balance+OD_Limit+1));
    }
}
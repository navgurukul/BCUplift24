package org.uplift.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uplift.user.User;

import java.util.Date;
import java.util.function.DoublePredicate;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    private SavingsAccount sa;
    private User user;
    private static final double ACCOUNT_BALANCE= 5000.0;
    private static final double OD_LIMIT= 1000.0;

    @BeforeEach

    void setup(){

        user=new User("gayatri","98222971259","gayatri23@gmail.com","gayuu2001","gayii@123");

        sa=new SavingsAccount(user,"2222",5000.0,new Date(),OD_LIMIT);

    }

    @Test

    void showBalance() {
        assertEquals(ACCOUNT_BALANCE,sa.showBalance());
    }

    @Test
    void deposit() {
        double amount =1000;
        double expected=ACCOUNT_BALANCE +amount;
        assertEquals(expected,sa.deposit(amount));

    }
    @Test

    void withdraw() throws InsufficientBalanceException {
       double amount=1000;
        double expectedBalance=ACCOUNT_BALANCE -amount;
        assertEquals(expectedBalance,sa.withdraw(amount));
    }
    @Test
    void withdrawWithOverDraftLimit() throws InsufficientBalanceException {
       assertEquals(OD_LIMIT,sa.withdraw(ACCOUNT_BALANCE+500));

    }
@Test
    void withdrawWithOverDraftLimitWithBreach(){// breach = cross

        assertThrows(InsufficientBalanceException.class,()->sa.withdraw(ACCOUNT_BALANCE+OD_LIMIT+1));
}
}
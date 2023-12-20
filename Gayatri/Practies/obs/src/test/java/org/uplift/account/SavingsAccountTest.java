package org.uplift.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {
    private static final double ACCOUNT_BALANCE=3000.0;
    private static final double OO_Limit=500;
    private SavingsAccount sa;
    private User user;
@BeforeEach

    void setup(){
        user =new User("gayatri Ganorkar","23782748","gayu@gmail","gayatriganorkar","gayu2001");
        sa= new SavingsAccount(user,"1234",3000.0,new Date(),500.0 );
    }

    @org.junit.jupiter.api.Test
    void showBalance() {
        assertEquals(3000.0,sa.showBalance());
    }
    @Test
    void withDrawlOverDraftLimit() throws InsufficientBalanceException {
    //double exceptedBalance=ACCOUNT_BALANCE-500;
    assertEquals(-OO_Limit,sa.withdraw(ACCOUNT_BALANCE+OO_Limit));
    }
   @Test
    void withDrawlOverDraftLimitBreach(){
    assertThrows(InsufficientBalanceException.class,()->sa.withdraw(ACCOUNT_BALANCE+OO_Limit+1));
    }
    @org.junit.jupiter.api.Test
    void deposit() {
        double exceptedBalance= ACCOUNT_BALANCE+1000;
        assertEquals(exceptedBalance,sa.deposit(1000));
    }

    @org.junit.jupiter.api.Test
    void withdraw()throws InsufficientBalanceException {
    double exceptedBalance=ACCOUNT_BALANCE-1000;
    assertEquals(exceptedBalance,sa.withdraw(1000));
    }
}
package org.example.account;

import org.example.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {
    private SavingAccount savingAccount;
    private User user;
    private static final double Account_BALANCE =12345.25;
    private static final double O_D_LIMIT =500;
    @BeforeEach
    void setUp(){
        user=new User("Neha","9999999999","nssss@gmail.com","neha123","12345");
        savingAccount=new SavingAccount(user,"12345",Account_BALANCE,new Date(),O_D_LIMIT);
    }


    @Test
    void testShowBalance() {
        assertEquals(Account_BALANCE,savingAccount.showBalance());
    }

    @Test
    void deposit() {
        double expectedBalance=Account_BALANCE+1000;
        assertEquals(expectedBalance, savingAccount.deposit(1000));

    }

    @Test
    void testWithdraw() throws InsufficientBalanceException {
        double expectedBalance=Account_BALANCE-1000;
        assertEquals(expectedBalance,savingAccount.withdraw(1000));

    }
    @Test
    void testWithdrawWithOverdraftLimit() throws InsufficientBalanceException {
        double expectedBalance=-500;
        assertEquals(-500,savingAccount.withdraw(Account_BALANCE+500));
    }
    @Test
    void testWithdrawWithOverdraftLimitBreach(){
        assertThrows(InsufficientBalanceException.class,()->savingAccount.withdraw(Account_BALANCE+O_D_LIMIT+1));
    }
}
package org.bankSystem.account;

import org.bankSystem.ExceptionHandling.InsufficientFundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;
    @BeforeEach
    public void setUp() {
        account = new Account("123456789");
        account.deposite(2000);
    }
    @Test
    public void checkBalance() throws InsufficientFundsException {
        account.deposite(100.0); // Deposit additional 100
        assertEquals(2100.0, account.getBalance());
        account.withdrawal(400); // Withdraw 400
        assertEquals(1700, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        InsufficientFundsException exception = assertThrows(
                InsufficientFundsException.class,
                () -> account.withdrawal(2500),
                "Insufficient funds in the account"
        );

        assertEquals("Insufficient funds in the account", exception.getMessage());
        assertEquals(2000.0, account.getBalance());
    }




}
package org.bankSystem.account;

import org.bankSystem.ExceptionHandling.InsufficientFundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountTest {
    private Account account;
    private CheckingAccount checkingAccount;

    @BeforeEach
    public void setUp() {
        account = new Account("a345");
        account.deposite(2000);
        checkingAccount  = new CheckingAccount("c23455", 500);
        checkingAccount.deposite(3000);
    }

    @Test
    public void checkBalance() throws InsufficientFundsException {
        assertEquals(3000, checkingAccount.getBalance());
        checkingAccount.withdrawal(3200);
        assertEquals(0, checkingAccount.getBalance());
    }

    @Test
    public void testWithdrawalInsufficientFunds() {
        InsufficientFundsException exception = assertThrows(
                InsufficientFundsException.class,
                () -> checkingAccount.withdrawal(4000),
                "Withdrawal amount exceeds overdraft limit"
        );

        assertEquals("Withdrawal amount exceeds overdraft limit", exception.getMessage());
        assertEquals(3000.0, checkingAccount.getBalance());
    }


}
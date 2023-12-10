package org.bankSystem.transaction;

import org.bankSystem.ExceptionHandling.InsufficientFundsException;
import org.bankSystem.account.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
    private Account sourceAccount;
    private Account targetAccount;

    @BeforeEach
    public void setUp() {
        sourceAccount = new Account("source123");
        targetAccount = new Account("target456");
        sourceAccount.deposite(3000);
        targetAccount.deposite(1000);
    }

    @Test
    public void testExecuteTransaction() throws InsufficientFundsException {
        double amount = 500;
        Transaction transaction = new Transaction(sourceAccount, targetAccount, amount);
        transaction.execute();

        assertEquals(2500, sourceAccount.getBalance());
        assertEquals(1500, targetAccount.getBalance());
    }
    /*@Test
    public void testInsufficientFundsException() {
        double amount = 4000; // Amount greater than source account balance
        Transaction transaction = new Transaction(sourceAccount, targetAccount, amount);

        InsufficientFundsException exception = assertThrows(
                InsufficientFundsException.class)


        }*/
}

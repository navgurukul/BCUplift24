package org.bankSystem.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {
    private SavingAccount savingAccount;
    @BeforeEach
    public void setUp() {
        savingAccount = new SavingAccount("123456789", 0.05);
        savingAccount.deposite(2000);
    }

    @Test
    public void testCalculateInterest() {
        assertEquals(100.0, savingAccount.calculateInterest(), 0.01);
    }

    @Test
    public void testInitialBalance() {
        assertEquals(2000.0, savingAccount.getBalance());
    }


}
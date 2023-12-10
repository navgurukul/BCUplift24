package org.bankSystem.transaction;

import org.bankSystem.account.Account;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class TransaferTransactionTest {
    private Account sourceAccount;
    private Account targetAccount;

    @BeforeEach
    public void setUp() {
        sourceAccount = new Account("a34556");
        targetAccount = new Account("p34555");

    }




}
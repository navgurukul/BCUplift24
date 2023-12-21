package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;

import static org.junit.jupiter.api.Assertions.*;

class AccountManagerTest {
    @Mock
    Account account;

    @InjectMocks
    AccountManager accountManager;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addAccount(){
        assertTrue(accountManager.addAccount(account));
    }

}
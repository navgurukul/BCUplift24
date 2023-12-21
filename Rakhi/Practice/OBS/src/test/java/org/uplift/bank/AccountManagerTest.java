package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import org.uplift.account.SavingsAccount;
import org.uplift.user.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AccountManagerTest {
    @Mock
    User user;
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
        when(account.getAccountNumber()).thenReturn("A123");
        when(account.getUser()).thenReturn(user);
        when(user.getMobile()).thenReturn("12345678");
        assertTrue(accountManager.addAccount(account));
        assertEquals(account,accountManager.findByAccountNumber(account.getAccountNumber()));
        assertEquals(account,accountManager.findByMobile("12345678"));
    }

}
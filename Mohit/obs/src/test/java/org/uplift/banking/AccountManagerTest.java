package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import org.uplift.security.AccountManager;
import org.uplift.user.User;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AccountManagerTest {
    @Mock
    private Account account;
    @InjectMocks
    private AccountManager accountManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addAccount(){
        User user = mock(User.class);
        when(account.getUser()).thenReturn(user);
        when(user.getMobile()).thenReturn("56789");
        when(account.getAccountNumber()).thenReturn("123");
        assertTrue(accountManager.addAccount(account));
        assertEquals(account,accountManager.findAccountNumber("123"));
        assertEquals(account,accountManager.findAccountByMobile("56789"));
    }
}
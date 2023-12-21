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
import static org.mockito.Mockito.*;

class AccountManagerTest {
    @Mock
    private SavingsAccount account;

    @InjectMocks
    private AccountManager am;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addAccount() {
        when(account.getAccountNumber()).thenReturn("A123");
        assertTrue(am.addAccount(account));
        assertEquals(account,am.findByAccountNumber("A123"));

    }

    @Test
    void findByMobile(){
        User user = mock(User.class);
        when(account.getUser()).thenReturn((user));
        when(user.getMobile()).thenReturn("+91-1234");
        am.addAccount(account);
        assertEquals(account,am.findMyMobile("+91-1234"));


    }
    @Test
    void findbyUserName(){
        User user = mock(User.class);
        when(account.getUser()).thenReturn((user));
        when(user.getUsername()).thenReturn("abc123");
        am.addAccount(account);
        assertEquals(account,am.findMyUsername("abc123"));


    }
}

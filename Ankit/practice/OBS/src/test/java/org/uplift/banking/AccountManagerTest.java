package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.User.User;
import org.uplift.account.Account;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AccountManagerTest {
    @Mock
    private Account account ;
    @InjectMocks
    private AccountManager accountManager;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void addAccount(){
        when(account.getAccountNumber()).thenReturn("12345");
        User user = mock(User.class);
        when(account.getUser()).thenReturn(user);
        when(user.getMobile()).thenReturn("8448077112");
        when(account.getUser()).thenReturn(user);
        when(user.getUserName()).thenReturn("a1234");
        assertTrue(accountManager.addAccount(account));
        assertEquals(account,accountManager.findAccountByAccountNumber("12345"));
        assertEquals(account,accountManager.findAccountByPhoneNumber("8448077112"));
        assertEquals(account,accountManager.findAccountByUserName("a1234"));
    }

}
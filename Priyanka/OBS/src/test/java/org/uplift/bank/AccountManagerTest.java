package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import org.uplift.account.SavingAccount;
import org.uplift.account.user.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AccountManagerTest {
    @Mock
    private SavingAccount account;

    @InjectMocks
    private AccountManager accountManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void addAccount() {
        when(account.getAccountNumber()).thenReturn("123AC");
        assertTrue(accountManager.addAccount(account));
        assertEquals(account,accountManager.findbyAccountNumber("123AC"));
    }
    @Test
    void findByPhoneNumbert() {
        User mockuser = mock(User.class);
        when(account.getUser()).thenReturn(mockuser);
        when(mockuser.getMobile()).thenReturn("9879878788");
        accountManager.addAccount(account);
        assertEquals(account,accountManager.findByMobileNumber("9879878788"));
    }
    @Test
    void findByUserName() {
        User mockuser = mock(User.class);
        when(account.getUser()).thenReturn(mockuser);
        when(mockuser.getUserName()).thenReturn("MitA");
        accountManager.addAccount(account);
        assertEquals(account,accountManager.findByUserName("MitA"));
    }
}
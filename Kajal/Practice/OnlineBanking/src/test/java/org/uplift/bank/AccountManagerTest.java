package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import static org.mockito.Mockito.*;

import org.uplift.user.User;

import static org.junit.jupiter.api.Assertions.*;

class AccountManagerTest {
    @Mock
    private Account account;

    @Mock
    private User user;

    @InjectMocks
    private AccountManager am;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addAccount(){
        when(account.getAccountNumber()).thenReturn("A123");
        assertTrue(am.addAccount(account));

        when(account.getUser()).thenReturn(user);
        when(user.getMobile()).thenReturn("+91-9734567512");

        assertEquals(account, am.findByAccountNumber("A123"));
        assertEquals(account,am.findByPhoneNumber("+91-9734567512"));

    }


}
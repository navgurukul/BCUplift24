package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import org.uplift.user.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class AccountManagerTest {

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
        when(account.getAccountNo()).thenReturn("A123");

        when(account.getUser()).thenReturn(user);
        when(user.getMobile()).thenReturn("989373920");

        assertTrue(am.addAccount(account));
        assertEquals(account,  am.findByAccountNumber(account.getAccountNo()));

        assertEquals(account, am.findByPhoneNumber("989373920"));

        when(account.getUser()).thenReturn(user);
        when(user.getUserName()).thenReturn("abc123");

        assertEquals(account, am.findByUserName("abc123"));
    }







}
package com.uplift.banking;

import com.uplift.account.SavingsAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
    void addAccount(){
        when(account.getAccountNumber()).thenReturn("A123");
        assertTrue(am.addAccount(account));
        assertEquals(account, am.findByAccountNumber("A123"));
    }

    @Test
    void findByPhoneNumber(){
        when(account.getPhoneNumber()).thenReturn("9899535374");
        assertTrue(am.addAccount(account));
        assertEquals(account, am.findByPhoneNumber("9899535374"));
    }

    @Test
    void findByUserName(){
        when(account.getUserName()).thenReturn("Alka Noor");
        assertTrue(am.addAccount(account));
        assertEquals(account, am.findByUserName("Alka Noor"));
    }

}
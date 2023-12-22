package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.User.User;
import org.uplift.account.Account;
import org.uplift.account.SavingsAccount;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AccountManagerTest {
    @Mock
    private User user;

    @Mock
    private SavingsAccount savingsAccount;
    @Mock
    private Account account;
    @InjectMocks
    private AccountManager am;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addAccount(){
        when(account.getAccountNumber()).thenReturn("A123");
        assertTrue(am.addAccount(account));
        assertEquals(account,am.findByAccountnumber("A123"));

    }
    @Test
    void findByMobile(){
        when(account.getMobile()).thenReturn("123456789");
        assertTrue(am.addAccount(account));
        assertEquals(account,am.findByMobile("123456789"));


    }
    @Test
    void findByUsername(){
        when(account.getUser().getUsername()).thenReturn("Neha");
        assertTrue(am.addAccount(account));
        assertEquals(account,am.findByUsername("Neha"));

    }

}
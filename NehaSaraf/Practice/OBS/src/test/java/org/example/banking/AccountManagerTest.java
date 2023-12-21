package org.example.banking;

import org.example.account.SavingAccount;
import org.example.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AccountManagerTest {
    @Mock
    private SavingAccount account;
    @Mock
    private User user;
    @InjectMocks
    private AccountManager accountManager;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }
    @Test
    void testAddAccount(){
        when(account.getAccountNumber()).thenReturn("A123");
        assertTrue(accountManager.addAccount(account));
        assertEquals(account,accountManager.findByAccountNumber("A123"));
    }
    @Test
    void testFindByMobile(){
        User user=mock(User.class);
        when(account.getUser()).thenReturn(user);
        when(user.getMobileNumber()).thenReturn("+91-9090909090");
        accountManager.addAccount(account);
        assertEquals(account,accountManager.findByMobile("+91-9090909090"));

    }
    @Test
    void testFindByUsername(){
        User user=mock(User.class);
        when(account.getUser()).thenReturn(user);
        when(user.getUserName()).thenReturn("A123");
        accountManager.addAccount(account);
        assertEquals(account,accountManager.findByUsername("A123"));

    }
}
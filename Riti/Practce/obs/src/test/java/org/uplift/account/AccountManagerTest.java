package org.uplift.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.user.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AccountManagerTest {
    @Mock
    private Saving account;
    @InjectMocks
    private  AccountManager accountManager;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void addAccount(){
        when(account.getAccountNumber()).thenReturn("123");
        assertTrue(accountManager.addManager(account));
        assertEquals(account,accountManager.findByAccountNumber("123"));

    }
    @Test
    void findByMobileNoumber(){
        User user= mock(User.class);
        when(account.getUser()).thenReturn(user);
        when(user.getPhone()).thenReturn("1234567");
        accountManager.addManager(account);
        assertEquals(account,accountManager.findByMobileNumber("1234567"));
//        assertTrue(accountManager.addManager(account));
//        Account a=accountManager.findByMobileNumber("1234567");
    }
    @Test
    void findByUserName(){
        User user= mock(User.class);
        when(account.getUser()).thenReturn(user);
        when(user.getUserName()).thenReturn("1234567");
//        when(user.ge)
        assertTrue(accountManager.addManager(account));
        Account a=accountManager.findByUserName("1234567");
    }


}
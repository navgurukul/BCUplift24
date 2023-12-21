package org.uplift.bankpackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import org.uplift.account.SavingAccount;
import org.uplift.user.User;

import static org.junit.jupiter.api.Assertions.*;
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

    void  testAddAccount(){
        when(account.getAccountNumber()).thenReturn("A123");

        assertTrue(accountManager.addAccount(account));
        assertEquals(account,accountManager.findByAccountNumber("A123"));

    }
    @Test
    void testfindByUserMobileNo(){
        User userMock = mock(User.class);
        when (account.getUser()).thenReturn(userMock);
        when(userMock.getMobile()).thenReturn("287655433");
        accountManager.addAccount(account);
        //when(account.getUser()).thenReturn(userMock);
        assertEquals(account,accountManager.findByUserMobileNo("287655433"));



    }
    @Test
    void testFindByUserName(){
        User userMock = mock(User.class);
        when (account.getUser()).thenReturn(userMock);
        when(userMock.getUserName()).thenReturn("jyoti122");
        accountManager.addAccount(account);
        //when(account.getUser()).thenReturn(userMock);
        assertEquals(account,accountManager.findByUserName("jyoti122"));

    }
}
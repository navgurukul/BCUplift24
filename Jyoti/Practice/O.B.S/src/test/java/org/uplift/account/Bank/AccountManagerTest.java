package org.uplift.account.Bank;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.uplift.account.*;
import org.uplift.user.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        assertEquals(account,accountManager.findByUserMobileNo("287655433"));

    }
    @Test
    void testFindByUserName(){
        User userMock = mock(User.class);
        when (account.getUser()).thenReturn(userMock);
        when(userMock.getUserName()).thenReturn("jyoti122");
        accountManager.addAccount(account);
        assertEquals(account,accountManager.findByUserName("jyoti122"));
    }
}
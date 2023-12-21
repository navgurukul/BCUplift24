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
    private SavingAccount account;

    @InjectMocks
    private AccountManager am;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks( this );
    }

    @Test
    void addAccount(){
        when(account.getAccountNumber()).thenReturn("1235");
        assertTrue( am.addManager(account) );
        Account a = am.findByAccountNumber("1235");
    }



    @Test
    void findByPhoneNumbert() {
        User mockuser = mock(User.class);
        when(account.getUser()).thenReturn(mockuser);
        when(mockuser.getMobile()).thenReturn("9879878788");
        am.addManager(account);
        assertEquals(account,am.findByMobileNumber("9879878788"));
    }


}
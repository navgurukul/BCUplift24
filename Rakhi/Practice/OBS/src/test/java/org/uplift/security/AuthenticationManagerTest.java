package org.uplift.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.bank.AccountManager;
import org.uplift.bank.security.AuthenticationManager;
import org.uplift.user.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AuthenticationManagerTest {
    @Mock
    User user;

    @Mock
    AccountManager bank;

    @InjectMocks
    AuthenticationManager authenticationManger;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void logIn() {
        when(user.getUserName()).thenReturn("abc22");
        when(user.getPassword()).thenReturn("pswd00");
        assertEquals(true,authenticationManger.logIn("abc22","pswd22"));

    }
}
package org.uplift.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.bank.security.Security;
import org.uplift.exception.UserNotFoundException;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SecurityTest {

    @Mock
    private Random random;

    @InjectMocks
    private Security security;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        security = new Security(random);

    }

    @Test
    void verifyUser() throws UserNotFoundException {
        Security.getUsernamePasswordMap().put("user123", "2345");
        assertTrue(security.verifyUser("user123", "2345"));
        assertFalse(security.verifyUser("user123", "3452"));
    }

    @Test
    void verifyUserForException(){
        assertThrows(UserNotFoundException.class, ()->security.verifyUser("user234", "7890"));
    }

    @Test
    void generateOTP(){
        int randomNumber = 1220;
        when(random.nextInt(100000, 1000000000)).thenReturn(randomNumber);
        security.generateOTP();

//        verify(security, times(1)).generateOTP();
        assertEquals(randomNumber, security.generateOTP());
    }
}
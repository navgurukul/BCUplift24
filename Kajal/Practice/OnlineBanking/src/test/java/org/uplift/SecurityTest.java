package org.uplift;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.bank.security.Security;
import org.uplift.exception.UserDoesNotExistException;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SecurityTest {

    @Mock
    private Random random;
    @InjectMocks
    private Security security;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        security.getUserpasswordMap().put("kajal123", "kajal@123");
    }

    @Test
    void verifyUser(){
        try {
            assertTrue(security.verityUser("kajal123", "kajal@123"));
        }
        catch (UserDoesNotExistException e){}
    }

    @Test
    void testUserDoesnotExist(){
        assertThrows(UserDoesNotExistException.class, ()->security.verityUser("Musharrat", "musharrat@123"));
        assertThrows(UserDoesNotExistException.class, ()->security.verityUser("Kajal", "musharrat@123"));
    }

    @Test
    void testGenerateOTP(){
        int otp = 1220;
        when(random.nextInt(1000, 10000)).thenReturn(otp);
        security.generateOPT();
    }

}
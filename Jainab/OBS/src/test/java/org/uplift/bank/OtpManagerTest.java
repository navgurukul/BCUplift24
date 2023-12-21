package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.exception.OtpExpireException;

import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OtpManagerTest {
    @Mock
    private Random random;
    @Mock
    private Scanner scanner;
    @Mock
    private Timer timer;

    @InjectMocks
    private OtpManager otpManager;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void generateOtp(){
        when(random.nextInt(1000,100000)).thenReturn(1000);
        assertEquals(1000, otpManager.generateOtp());
        verify(random,times(1)).nextInt(1000,100000);
    }

    @Test
    void validateOtp() throws OtpExpireException {

        when(random.nextInt(1000, 100000)).thenReturn(1000);
        when(scanner.next()).thenReturn("1000");
        assertTrue(otpManager.validateOtp());
        verify(scanner, times(1)).next();
        InOrder io = inOrder(random, scanner);
        io.verify(random).nextInt(1000, 100000);
        io.verify(scanner).next();
    }
    @Test
    void validateOtpMaxRetries() throws OtpExpireException {
        assertFalse(otpManager.validateOtp());
        verify(scanner,times(3)).next();
        verify(random,times(1)).nextInt(1000,100000);

    }

    @Test
    void validateOtpTimeout(){
        when(timer.getCurrentTime()).thenReturn(100l,70000l);
        assertThrows(OtpExpireException.class,() -> otpManager.validateOtp());
    }
}
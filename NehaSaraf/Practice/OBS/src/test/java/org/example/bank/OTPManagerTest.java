package org.example.bank;

import org.example.exception.OTPExpiredException;
import org.example.security.OTPManager;
import org.example.security.Timer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OTPManagerTest {
    @Mock

    private Random random;
    @InjectMocks
    private OTPManager otpManager;
    @Mock
    private Scanner scanner;
    @Mock
    private Timer timer;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testGenerateOTP(){
        when(random.nextInt(1000,100000)).thenReturn(1000);
        assertEquals("1000", otpManager.generateOTP());
        verify(random,times(1)).nextInt(1000,100000);
    }
    @Test
    void testValidateOTP() throws OTPExpiredException {
        when(random.nextInt(1000,100000)).thenReturn(1000);
        when(scanner.next()).thenReturn("1000");
        assertTrue(otpManager.validateOTP());
        verify(scanner,times(1)).next();
        InOrder io=inOrder(random,scanner);
        io.verify(random).nextInt(1000,100000);
        io.verify(scanner).next();
    }
    @Test
    void testValidateOTPMaxRetries() throws OTPExpiredException {
        assertFalse(otpManager.validateOTP());
        verify(scanner,times(3)).next();
        verify(random,times(1)).nextInt(1000,100000);
    }
    @Test
    void testValidateOtpTimeout(){
        when(timer.getCurrentTime()).thenReturn(100l,70000l);
        assertThrows(OTPExpiredException.class,()->otpManager.validateOTP());
    }
}
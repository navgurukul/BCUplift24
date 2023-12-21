package org.Uplift.Bank;

import org.Uplift.Bank.security.OtpManager;
import org.Uplift.Bank.security.Timer;
import org.Uplift.exception.OtpExpiredException;
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

class OtpManagerTest {
    @Mock
    private Random random;
    @InjectMocks
    private OtpManager otpManager;
    @Mock
    private Scanner scanner;

    @Mock
    private Timer timer;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void generateOtp(){
        when((random.nextInt(1000, 100000))).thenReturn(1000);
        String otp = otpManager.generateOtp();
        assertEquals("1000", otp);
        verify(random, times(1)).nextInt(1000, 100000);
    }
    @Test
    void validateOtp() throws OtpExpiredException {
        when(random.nextInt(1000,100000)).thenReturn(1000);
        when(scanner.next()).thenReturn("1000");
        assertTrue(otpManager.validateOtp());
        verify(scanner, times(1)).next();
        InOrder io = inOrder(random, scanner);
        io.verify(random).nextInt(1000,100000);
        io.verify(scanner).next();
    }

    @Test
    void validateOtpMaxRetries() throws OtpExpiredException {
        assertFalse(otpManager.validateOtp());
        verify(scanner, times(3)).next();
        verify(random, times(1)).nextInt(1000, 100000);
    }
    @Test
    void validateOtpTimeOut(){
        when(timer.getCurrentTime()).thenReturn(100L, 70000L);
        assertThrows(OtpExpiredException.class,()-> otpManager.validateOtp());
    }
}
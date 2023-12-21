package org.uplift.OTPManager;
import  org.mockito.verification.VerificationMode;
import java.util.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.uplifte.exceptionhandling.OtpExpiredException;

import java.util.Random;
import java.util.Scanner;
import org.uplift.account.Timer;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OtpManagerTest {
    @Mock
    private Random random;
    @Mock
    private Timer timer;
    @InjectMocks
    private OtpManager otpManager;
    @Mock
    private Scanner scanner;
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
        when(timer.getCurrentTime()).thenReturn(1001L,7000001L);
        assertThrows(OtpExpiredException.class,()->otpManager.validateOtp());
    }


}
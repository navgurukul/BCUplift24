package org.example.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.banking.security.OtpManager;
import org.uplift.banking.security.Timer;
import org.uplift.exception.OtpExpiredException;

import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OtpManagerTest {

    @Mock
    private Random random;

    @Mock
    private Timer timer;
    @Mock
    private Scanner scanner;

    @InjectMocks
    private OtpManager otpManager;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void generateOtp(){
        int randomNumber = 1023;
        when(random.nextInt(10000, 10000000)).thenReturn(randomNumber);
        assertEquals(""+randomNumber, otpManager.generateOtp());
        verify(random, times(1)).nextInt(10000, 10000000);
    }

    @Test
    void validateOtp() throws OtpExpiredException {

        when(random.nextInt(10000, 10000000)).thenReturn(1000);
        when(scanner.next()).thenReturn("1000");
        assertTrue(otpManager.validateOtp());
        verify(scanner, times(1)).next();

        InOrder io = inOrder(random, scanner);
        io.verify(random).nextInt(10000, 10000000);
        io.verify(scanner).next();
    }

    @Test
    void testValidateOtpMaxTimes()throws OtpExpiredException {
        assertFalse(otpManager.validateOtp());
        verify(scanner, times(3)).next();
        verify(random, times(1)).nextInt(10000, 10000000);
    }

    @Test
    void validateOtpTimeout() {
        when(timer.getCurrentTime()).thenReturn(100L, 70000L);
        assertThrows(OtpExpiredException.class, () -> otpManager.validateOtp());
    }


}
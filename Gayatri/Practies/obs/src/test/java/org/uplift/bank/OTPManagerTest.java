package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.security.OTPManager;
import org.uplift.security.Timer;
import org.uplift.exception.OtpExpiredException;

import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OTPManagerTest {
    @Mock
    private Random random;
    @Mock
    private Scanner scanner;
    @InjectMocks
    private OTPManager otpManager;
    @Mock
    private Timer timer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void generateOtp() {
        when(random.nextInt(1000, 10000)).thenReturn(1000);

        assertEquals("1000", otpManager.generateOtp());

        verify(random, times(1)).nextInt(1000,10000);
    }

    @Test
    void validateOtp() throws OtpExpiredException {
        when(random.nextInt(1000, 10000)).thenReturn(1000);
        when(scanner.next()).thenReturn("1000");

        assertTrue(otpManager.validateOtp());

        verify(scanner, times(1)).next();
        verify(random,times(1)).nextInt(1000,10000);
        InOrder io = inOrder(random, scanner);
        io.verify(random).nextInt(1000, 10000);
        io.verify(scanner).next();
    }

    @Test
    void testValidateOtpMaxRetries() throws OtpExpiredException {
       assertFalse( otpManager.validateOtp());
        verify(scanner,times(3)).next();
        verify(random,times(1)).nextInt(1000,10000);
    }
    @Test

    void validateOtpTimeout() {
     when(timer.getCurrentTime()).thenReturn(1000l,700000l);
     assertThrows(OtpExpiredException.class,()->otpManager.validateOtp());
    }

}

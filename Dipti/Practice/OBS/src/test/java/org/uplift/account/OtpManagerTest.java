package org.uplift.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.security.OtpExpiredException;
import org.uplift.security.OtpManager;
import org.uplift.security.Timer;

import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

// from 1 jan 1970 the date is counted in millisecconds

class OtpManagerTest {
    @Mock
    private Random random;
    @Mock
    private Scanner scanner;
    @Mock
    private Timer timer;

    @InjectMocks
   private OtpManager otpgen;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testOtpManager(){
        when(random.nextInt(1000,100000)).thenReturn(1000);
        assertEquals("1000",otpgen.generateOtp());
        verify(random,times(1)).nextInt(1000,100000);

    }

    @Test
    void testValidateOtp()throws OtpExpiredException{
        when(random.nextInt(1000,100000)).thenReturn(1000);
        when(scanner.next()).thenReturn("1000");

        assertTrue(otpgen.validateOtp());
        verify(scanner,times(1)).next();
        verify(random,times(1)).nextInt(1000,100000);
        InOrder io= inOrder(random,scanner);
        io.verify(random).nextInt(1000,100000);
        io.verify(scanner).next();
    }


    @Test
    void validateOtpMaxRetries()throws OtpExpiredException{
        assertFalse(otpgen.validateOtp());
        verify(scanner,times(3)).next();
        verify(random,times(1)).nextInt(1000,100000);

    }

    @Test
    void validateOtpTimeout() {
        when(timer.getCurrentTime()).thenReturn(100l,70000l);
        assertThrows(OtpExpiredException.class,()->otpgen.validateOtp());

    }

}
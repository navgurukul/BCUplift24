package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.bank.security.OtpManager;
import org.uplift.exception.OtpExpiredException;

import java.util.Random;
import java.util.Scanner;
import org.uplift.bank.security.Timer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OtpManagerTest {
    @Mock
    Random random;

    @Mock
    Scanner scanner;

    @Mock
    Timer timer;

    @InjectMocks
    private OtpManager otpManager;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void generateOtp(){
        int randomNumber=1023;
        when(random.nextInt(1000,100000)).thenReturn(randomNumber);
        assertEquals(""+randomNumber, otpManager.otpGenerator());
        verify(random,times(1)).nextInt(1000,100000);
    }

    @Test
    void validateOtp(String otp)throws OtpExpiredException{
        when(random.nextInt(1000,100000)).thenReturn(1023);
        when(scanner.next()).thenReturn("1023");
        assertTrue(otpManager.validateOtp());
        verify(scanner,times(1)).next();
        InOrder io=inOrder(random,scanner);
        io.verify(random).nextInt(1000,100000);
        io.verify(scanner).next();
    }

    @Test
    void validateOtpMaxRetries()throws OtpExpiredException{
        assertFalse(otpManager.validateOtp());
        verify(scanner,times(3)).next();
        verify(random,times(1)).nextInt(1000,100000);

    }

    @Test
    void validateOtpTimeout(){
        when(timer.getCurrentTime()).thenReturn(100l,700000l);
        assertThrows(OtpExpiredException.class,()-> otpManager.validateOtp());
    }

}
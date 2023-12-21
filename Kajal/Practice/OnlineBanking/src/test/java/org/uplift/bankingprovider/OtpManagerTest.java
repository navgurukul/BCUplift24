package org.uplift.bankingprovider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.bankingprovider.security.OtpManager;
import org.uplift.bankingprovider.security.Timer;
import org.uplift.exception.OtpExpiredException;

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
    private OtpManager otgen;
    @BeforeEach
    void setUo(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void generateOtp(){
        int randonNumber = 1023;
        when(random.nextInt(1000, 10000)).thenReturn(randonNumber);
        assertEquals(""+randonNumber, otgen.generateOTP());
        verify(random, times(1)).nextInt(1000, 10000);
    }

    @Test
    void validateOTP() throws OtpExpiredException {
        when(random.nextInt(1000, 10000)).thenReturn(1000);
        when(scanner.next()).thenReturn("1000");
        assertTrue(otgen.validateOtp());
        verify(scanner, times(1)).next();

        InOrder io = inOrder( random, scanner);
        io.verify(random).nextInt(1000, 10000);
        io.verify(scanner).next();
    }

    @Test
    void testValidateMaxTime() throws OtpExpiredException {
        assertFalse(otgen.validateOtp());
        verify(scanner, times(3)).next();
        verify(random, times(1)).nextInt(1000,10000);


    }

    @Test
    void validateOtpTimeout(){
        when(timer.getCurrentTime()).thenReturn(100L, 70000L);
        assertThrows(OtpExpiredException.class, ()->otgen.validateOtp());
    }




}
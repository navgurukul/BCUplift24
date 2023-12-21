package org.uplift.Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.Bank.security.OtpExpiredException;
import org.uplift.Bank.security.OtpManager;
import org.uplift.Bank.security.Timer;

import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OtpManagerTest {
    @Mock
    private Random random;
    @Mock
    private Scanner scanner;
    @InjectMocks
    private OtpManager otpmanager;
    @Mock
    private Timer timer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void generateOtp(){
        when(random.nextInt(1000,10000)).thenReturn(1000);
        assertEquals("1000", otpmanager.generateOtp());
        verify(random,times(1)).nextInt(1000,10000);
    }
    @Test
    void validateOtp() throws OtpExpiredException { //stubbing
        when(random.nextInt(1000,10000)).thenReturn(1000);
        when(scanner.next()).thenReturn("1000");
        assertTrue(otpmanager.validateOtp());
        verify(scanner,times(1)).next();
        InOrder io=inOrder(random,scanner);
        io.verify(random).nextInt(1000,10000);
        io.verify(scanner).next();
    }

    @Test
    void validateOtpMaxRetries()throws OtpExpiredException{
        assertFalse(otpmanager.validateOtp());
        verify(scanner,times(3)).next();
        verify(random,times(1)).nextInt(1000,10000);
    }

    @Test
    void validateOtpTimeout(){
        when(timer.getCurrentTime()).thenReturn(100l,70000l);
        assertThrows(OtpExpiredException.class,()->otpmanager.validateOtp());

    }

}
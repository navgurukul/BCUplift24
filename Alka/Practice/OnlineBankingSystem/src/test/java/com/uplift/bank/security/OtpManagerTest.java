package com.uplift.bank.security;

import com.uplift.exceptions.OtpExpiredException;
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

    @Mock
    private Scanner scanner;

    @Mock
    private Timer timer;

    @InjectMocks
    private OtpManager otpManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void generateOtpTest(){
        when(random.nextInt(1000,100000)).thenReturn(1000);
        String otp = otpManager.generateOtp();
        assertEquals("1000", otp);
        verify(random,times(1)).nextInt(1000,100000);
    }

    @Test
    void validiateOtpTest() throws OtpExpiredException {
        when(random.nextInt(1000,100000)).thenReturn(1000);
        when(scanner.next()).thenReturn("1000");
        assertTrue(otpManager.validiateOtp());
        verify(scanner,times(1)).next();
        InOrder io = inOrder(random,scanner);
        io.verify(random).nextInt(1000,100000);
        io.verify(scanner).next();
    }

    @Test
    void validiateOtpMaxRetries() throws OtpExpiredException {
        assertFalse(otpManager.validiateOtp());
        verify(scanner,times(3)).next();
        verify(random,times(1)).nextInt(1000,100000);
    }

    @Test
    void validiateOtpTimeOut(){
        when(timer.getCurrentTime()).thenReturn(100l,70000l);
        assertThrows(OtpExpiredException.class, () -> otpManager.validiateOtp());
    }

}
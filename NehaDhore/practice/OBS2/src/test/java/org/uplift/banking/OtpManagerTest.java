package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.verification.VerificationMode;
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
    private OtpManager otpgen;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void generateOtp(){
        when(random.nextInt(1000,100000)).thenReturn(1000);
        assertEquals("1000", otpgen.generateOtp());
        Mockito.verify(random,times(1)).nextInt(1000,100000);

    }
    @Test
    void ValidateOtp(String otp) throws OtpExpiredException {
        when(scanner.next()).thenReturn("1000");
        when(random.nextInt(1000,100000)).thenReturn(1000);

        assertTrue(otpgen.validateOtp());
        verify(scanner, times(1)).next();
        InOrder io = inOrder(random,scanner);
        io.verify(random).nextInt(1000,100000);
        io.verify(scanner).next();




    }
    @Test
    void validateOtpMaxRetries() throws OtpExpiredException {
        assertFalse(otpgen.validateOtp());
        verify(scanner,times(3)).next();
        verify(random,times(1)).nextInt(1000,100000);
    }
    @Test
    void validateOtpTimeout(){
        when(timer.getCurrentTime()).thenReturn(100L,70000L);
        assertThrows(OtpExpiredException.class,() -> otpgen.validateOtp());

    }



}

//Date ka Api padho

package org.uplift.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.bank.security.OTPManager;
import org.uplift.bank.security.OtpExpiredException;
import org.uplift.bank.security.Timer;

import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OTPManagerTest {

    @Mock
    private Random random;
    @Mock
    private Scanner scanner;
    @Mock
    private Timer timer;

    @InjectMocks
    private OTPManager otpManager;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks( this );
    }


    @Test
    void generateOTP(){
        int otp = 1000;
        when(random.nextInt(1000, 100000)).thenReturn(otp);
        assertEquals(""+ otp, otpManager.generateOTP());
        verify(random, times(1)).nextInt(1000, 100000);

    }

//    @Test
//    void checkingLengthOfOtp(){
//        int otp = 1000000;
//        when(random.nextInt( 100000, 900000 )).thenReturn( otp );
//
//        String strOtp = "" + otp;
//
//        //assertEquals( strOtp.length(), otpGen.generateOTP().length() );
//    }


    @Test
    void validateOtp(){
        when(scanner.next()).thenReturn( "1000" );
        when(random.nextInt( 1000, 100000 )).thenReturn( 1000 );
        assertTrue(otpManager.validateOtp());
        verify(scanner, times(1)).next();
        InOrder io = inOrder(random, scanner);
        io.verify(random) .nextInt(1000, 100000);
        io.verify(scanner).next();
    }

    @Test
    void validateOtpMaxRetries() {
        assertFalse(otpManager.validateOtp());
        verify( scanner, times(3)).next();
        verify(random, times(1)).nextInt(1000, 100000);

    }


    @Test
    void validateOtpTimeOut(){
        when(timer.getCurrentTime()).thenReturn(100l,700000l);
        assertThrows( OtpExpiredException.class, () ->otpManager.validateOtp() );
    }
}
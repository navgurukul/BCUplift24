package org.uplift.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OTPGeneratorTest {

    @Mock
    private Random random;

    @InjectMocks
    private OTPGenerator otpGenerator;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks( this );
    }


    @Test
    void checkingOTP(){
        int otp = 100000;
        when(random.nextInt(100000, 900000)).thenReturn(otp);
        assertEquals("" + otp, otpGenerator.generateOTP());

    }

    @Test
    void checkingLengthOfOtp(){
        int otp = 1000000;
        when(random.nextInt( 100000, 900000 )).thenReturn( otp );

        String strOtp = "" + otp;

        assertEquals( strOtp.length(), otpGenerator.generateOTP().length() );
    }
}
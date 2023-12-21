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

class OtpGenerateTest {
    @Mock
    private Random random;
    @Mock
    private Scanner scanner;
    @InjectMocks
    private OtpGenerate otpGenerate;
    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);

    }
    @Test
    void testgenerateTest(){
        when(random.nextInt(1000,1000000)).thenReturn(1000);
        assertEquals("1000",otpGenerate.generateOtp());
        verify(random,times(1)).nextInt(1000,1000000);
    }
    @Test
    void validateOtp(){
        when(random.nextInt(1000,1000000)).thenReturn(1000);
        when(scanner.next()).thenReturn("1000");
        assertTrue(otpGenerate.validateOtp());
        verify(scanner,times(1)).next();
        InOrder io=inOrder(random,scanner);
        io.verify(random).nextInt(1000,1000000);
        io.verify(scanner).next();
    }
    @Test
    void testvalidateotpmaxRetries(){
        assertFalse(otpGenerate.validateOtp());
        verify(scanner,times(3)).next();
        verify(random,times(1)).nextInt(1000,1000000);



    }
    @Test
    void getCurrentTime() {
        long ct = new Date().getime();
        long answer = timer.getCurrentTime();
        assertEquals(answer > ct);
    }
    @Test
    void validationaOtpTimeout(){
        when(timer.getCurrentTime()).thenReturn()























    }
}

//package org.uplift.bank;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InOrder;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Random;
//import java.util.Scanner;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.inOrder;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//class OtpManagerTest {
//
//    @Mock
//    private Random random;
//
//    @Mock
//    private Scanner scanner;
//
//    @InjectMocks
//    private OtpManager otpManager;
//
//    @BeforeEach
//    void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testGenerateOtp() {
//        when(random.nextInt(1000, 10000)).thenReturn(1000);
//        assertEquals("1000", otpManager.generateOtp());
//        verify(random, times(1)).nextInt(1000, 10000);
//    }
//
//    @Test
//    void validateOtpWithScanner() {
//        when(random.nextInt(1000, 10000)).thenReturn(1000);
//        when(scanner.next()).thenReturn("1000");
//
//        // Assuming validateOtp takes an argument for the OTP
//        boolean isValid = otpManager.validateOtp(scanner.next());
//
//        assertEquals(true, isValid);
//
//        verify(random, times(1)).nextInt(1000, 10000);
//        verify(scanner, times(1)).next();
//
//        InOrder io = inOrder(random, scanner);
//        io.verify(random).nextInt(1000, 10000);
//        io.verify(scanner).next();
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////package org.uplift.bank;
////
////import org.junit.jupiter.api.BeforeEach;
////import org.junit.jupiter.api.Test;
////import org.mockito.InOrder;
////import org.mockito.InjectMocks;
////import org.mockito.Mock;
////import org.mockito.MockitoAnnotations;
////
////import java.util.Random;
////import java.util.Scanner;  // Import Scanner
////
////import static org.junit.jupiter.api.Assertions.assertEquals;
////import static org.mockito.Mockito.inOrder;
////import static org.mockito.Mockito.times;
////import static org.mockito.Mockito.verify;
////import static org.mockito.Mockito.when;
////
////class OtpManagerTest {
////
////    @Mock
////    private Random random;
////
////    @Mock
////    private Scanner scanner;  // Change Object to Scanner
////
////    @InjectMocks
////    private OtpManager otpManager;
////
////    @BeforeEach
////    void setup() {
////        MockitoAnnotations.openMocks(this);
////    }
////
////    @Test
////    void testGenerateOtp() {
////        when(random.nextInt(1000, 10000)).thenReturn(1000);
////        assertEquals("1000", otpManager.generateOtp());
////        verify(random, times(1)).nextInt(1000, 10000);
////    }
////
////    @Test
////    void validateOtpWithScanner() {
////        when(random.nextInt(1000, 10000)).thenReturn(1000);
////        when(scanner.next()).thenReturn("1000");
////
////        // Assuming validateOtp takes an argument for the OTP
////        boolean isValid = otpManager.validateOtp(scanner.next());
////
////        assertEquals(true, isValid);
////
////        verify(random, times(1)).nextInt(1000, 10000);
////        verify(scanner, times(1)).next();
////
////        InOrder io = inOrder(random, scanner);
////        io.verify(random).nextInt(1000, 10000);
////        io.verify(scanner).next();
////    }
////}































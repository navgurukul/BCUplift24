package org.uplift.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.bank.security.OTPManager;
import org.uplift.bank.security.Timer;
import org.uplift.exceptions.OTPExpiredException;

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
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void generateOTP() {
        when(random.nextInt(1000,100000)).thenReturn(1000);
        assertEquals(""+1000, otpManager.generateOTP());
        verify(random,times(1)).nextInt(1000,100000);

    }
    @Test
    void testValidateOTP() throws OTPExpiredException {
        when(scanner.next()).thenReturn("1000");
        when(random.nextInt(1000,100000)).thenReturn(1000);
        assertTrue(otpManager.validOTP());
        verify(scanner,times(1)).next();
        InOrder io=inOrder(random,scanner);
        io.verify(random).nextInt(1000,100000);
        io.verify(scanner).next();

    }
    @Test
    void validateOTPMAXRetrys() throws OTPExpiredException {
        assertFalse(otpManager.validOTP());
        verify(scanner,times(3)).next();
        verify(random,times(1)).nextInt(1000,100000);
    }
    @Test
    void validateOTPTomeout() {
        //1sec=1000msec
        //1min=60sec
        //1h=60min
        /*The Date API in Java provides functionalities to work with dates, times, and related operations. Specifically, it includes the `java.util.Date` class that represents a specific instant in time with millisecond precision.On January 1, 1970, at 00:00:00 UTC, starts the epoch time for the Date API in Java. However, if you mentioned "January 1, 1979," this date falls within the range of the `java.util.Date` class. It's important to note that Java's `Date` class represents a point in time, including both date and time components.For instance, to obtain a `Date` object representing January 1, 1979, you can use `java.util.Date` as follows:```java

//        import java.util.Date;
//
//        public class DateExample {
//            public static void main(String[] args) {
//                Date januaryFirst1979 = new Date(79, 0, 1); // January 1, 1979 (year is 79 because 1900 is subtracted)
//                System.out.println("Date: " + januaryFirst1979);
//            }
//        }
The `Date` object created in the above code represents January 1, 1979, using the `Date` constructor that takes year, month, and day as arguments. However, it's important to mention that the `java.util.Date` class has been largely replaced by the newer `java.time` API introduced in Java 8, which offers better features for handling dates, times, and related operations with improved clarity and functionality.

*/
        when(timer.getCurrentTime()).thenReturn(100l,70000l);//first time return 100 and secend time return 70000
        assertThrows(OTPExpiredException.class,()->otpManager.validOTP());





    }
}
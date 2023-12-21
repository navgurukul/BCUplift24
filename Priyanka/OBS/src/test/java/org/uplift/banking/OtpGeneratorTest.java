package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.user.User;
import org.uplift.banking.security.Timer;

import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OtpGeneratorTest {
    @Mock
    private Random random;
    @Mock
    private User user;
    @Mock
    private Scanner scanner;
    @Mock
    private Timer timer;
    @InjectMocks
    private OtpGenerator otpGenerator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void generateOtp() {
        when(random.nextInt(1000,100000)).thenReturn(1000);
        assertEquals("1000",otpGenerator.generateOtp());
        verify(random,times(1)).nextInt(1000,100000);
    }
    @Test
    void validateOtp() throws OtpExpiredException {
        when(random.nextInt(1000,100000)).thenReturn(1000);
        when(scanner.next()).thenReturn("1000");
        assertTrue(otpGenerator.validateOtp());
        verify(scanner,times(1)).next();
        InOrder io = inOrder(random,scanner);
        io.verify(random).nextInt(1000,100000);
        io.verify(scanner).next();
    }
    @Test
    void validateOtpMaxRetries() throws OtpExpiredException {
        assertFalse(otpGenerator.validateOtp());
        verify(scanner,times(3)).next();
        verify(random,times(1)).nextInt(1000,100000);
    }
    @Test
    void validateOtpTimeout() {
        when(timer.getcurrentTime()).thenReturn(100l,70000l);
        assertThrows(OtpExpiredException.class,()->otpGenerator.validateOtp());
    }
}
package org.uplift.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserVerificationTest {
    @Mock
    private Scanner scanner;
    @Mock
    private User user;
    @InjectMocks
    private UserVerification userVerification;

    @BeforeEach
    void setUp() {
//        user=new User("mohit","876543","mohit22@gmail.com","mohit","12");
        MockitoAnnotations.openMocks(this);

    }
    @Test
    void userVerification(){
        when(scanner.next()).thenReturn("123");
        assertEquals("123",userVerification.verifyUser(user));

    }
}
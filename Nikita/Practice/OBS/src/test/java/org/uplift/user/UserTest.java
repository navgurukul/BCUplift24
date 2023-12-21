package org.uplift.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserTest {

        @Mock
        private Scanner scanner;
        @InjectMocks
        private User user;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
        }
        @Test
        void testCaptureUserName() {
            when(scanner.next()).thenReturn("Meena");
            assertEquals("Meena",user.captureEmail());
        }
        @Test
        void testCaptureUSerNameByMocking() {
            user.captureEmail();
            verify(scanner,times(1)).next();
        }
        @Test
        public void testPasswordInput() {
            InputStream inputStream = new ByteArrayInputStream("dummy".getBytes());
            System.setIn(inputStream);
            assertEquals("dummy",user.capturePassword());
        }

}
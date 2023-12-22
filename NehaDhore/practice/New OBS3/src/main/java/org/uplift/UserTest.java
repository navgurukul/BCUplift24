package org.onlinebanking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

class UserTest {
    @Mock
    private Scanner scanner;
    @Mock
    private Dependancy1 d1;

    @Mock
    private Dependancy2 d2;
    @InjectMocks
    private User user;


    @BeforeEach
    void init_Mock(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    Object captureUserInput() {
        when(scanner.nextLine()).thenReturn("ankit");
        assertEquals("ankit",user.captureUserInput());
        return null;
    }
    @Test
    public void testPasswordInput(){
        InputStream ips = new ByteArrayInputStream("dummy".getBytes());
        System.setIn(ips);
        assertEquals("dummy",user.capturePassword());
    }

    @Test
    void testCaptureUserInputWithMocking(){
        user.captureUserInput();
        Mockito.verify(scanner,times(1)).nextLine();
    }
    @Test
    public void testValidateFirstAttempt(){
        user.givePin("123");
        when(scanner.next()).thenReturn("123");
        assertTrue(user.validatePin());
        Mockito.verify(scanner,times(1)).next();
    }
    @Test
     void  testDependancy(){
         InOrder o = inOrder(d1,d2);

        user.invokeDependencies();
        o.verify(d1).invoke1();
        o.verify(d2).invoke2();

    }

}
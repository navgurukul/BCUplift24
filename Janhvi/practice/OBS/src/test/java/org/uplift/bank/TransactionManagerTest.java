package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import org.uplift.account.SavingAccount;
import org.uplift.account.Transaction;
import org.uplift.exception.InSufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionManagerTest {


    private Account source;

    private Account target;
    private User sourceUser;
    private User targetUser;
    private User user;
    @Mock
    private Random random;

    @InjectMocks
    private TransactionManager tm;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
//       sourceUser = new User("Janhvi","1234","janhvi12@gmail.com","janhvi12","janu123");
//       targetUser = new User("Sanika","2324","sanika@gmail.com","sanu@12","sanu123");
//       source = new SavingAccount(sourceUser,"J12345",100000,new Date(),1000);
//       target = new SavingAccount(targetUser,"S1234",20000,new Date(),2000);
    }

    @Test
    void transfer() throws InSufficientBalanceException {
        int randomNumber = 10000001;//this is a stubb.
        when(random.nextInt(100000,100000000)).thenReturn(randomNumber);
        //assertEquals(""+randomNumber,tm.transfer(source,target,1000).getTransactionId());
        Account sa = mock(SavingAccount.class);//on the basis of saving account we create mocks manually by mock method.
        Account ta = mock(SavingAccount.class);
        InOrder io = inOrder(sa,ta);
        //tm.transfer(sa,ta,1000);
        Transaction t = tm.transfer(sa,ta,1000);
        assertEquals(""+randomNumber,t.getTransactionId());
        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposit(1000);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);
        assertEquals(t,tm.findByTransactionID(""+randomNumber));



    }
}
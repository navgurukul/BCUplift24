package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.User.User;
import org.uplift.account.Account;
import org.uplift.account.SavingsAccount;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientBalanceException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionManagerTest {
    private Account source;
    private Account target;
    private User targetUser;
    private User sourceUser;
    @Mock
    private Random random;

    @InjectMocks
    private TransactionManager tm;

    @BeforeEach
    void setup(){
//        source = new SavingsAccount("A123");
        MockitoAnnotations.openMocks(this);
//        sourceUser = new User("Neha","1223454321","@neha","123");
//        targetUser = new User("Harsha","12234541","@Harsha","1234");
//        source = new SavingsAccount(sourceUser,"12",1000.0,new Date(),500.0);
//        target = new SavingsAccount(targetUser,"13",2000.0,new Date(),500.0);
    }
    @Test
    void transfer() throws InsufficientBalanceException {
        int randomNumber = 10000001;
        when(random.nextInt(1000000,1000000000)).thenReturn(randomNumber);

       Account sa = mock(SavingsAccount.class);
       Account ta = mock(SavingsAccount.class);

         InOrder io = inOrder(sa,ta);
        Transaction t = tm.transfer(sa,ta,1000);
        assertEquals(""+randomNumber,t.getTransactionId());
        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposit(1000);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);
       assertEquals(t,tm.findByTransactionId(""+randomNumber));

    }


}
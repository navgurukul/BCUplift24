package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import org.uplift.account.SavingsAccount;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientBalanceException;
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
    @Mock
    private Random random;
    @InjectMocks
    private TransactionManager tm;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        source= new SavingsAccount(new User("ads","367646","gdsdg@gamil","fgygf","egdhg@186"),"123",3000.0,new Date(),500);
        target= new SavingsAccount(new User("ghgj","47586","fgjkj@gamil","fgheu","egdhg@16"),"456",2000.0,new Date(),500);

    }
    @Test
   void transfer() throws InsufficientBalanceException {
        int randomNumber =10000001;
        when(random.nextInt(1000000,1000000000)).thenReturn(randomNumber);
        //String txnId=" "+ Objects.hash(source,target,new Date());
        //Transaction expectedTransaction = new Transaction(source,target,new Date(),1000.0,"123");

        Account sa = mock(SavingsAccount.class);
        Account ta = mock(SavingsAccount.class);
        InOrder io = inOrder(sa,ta);
        Transaction t =tm.transfer(sa,ta,1000);
       // tm.transfer(sa,ta,1000);
        assertEquals(""+randomNumber,t.getId());
        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposit(1000);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);

        assertEquals(t,tm.findByTransactionId(""+randomNumber));
    }


}
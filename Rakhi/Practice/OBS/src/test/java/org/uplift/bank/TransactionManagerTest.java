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
    private TransactionManager transactionManager;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        sourceUser=new User("ABC","12345","rakhi@123","rk23","rakhik@90");
        targetUser=new User("CDE","67890","nisha@123","nn23","nisha@90");
        source=new SavingsAccount(sourceUser,"123ABC",5000.0,new Date(),2000);
        target=new SavingsAccount(targetUser,"123CDE",5000.0,new Date(),2000.0);
    }

    @Test
    void transfer() throws InsufficientBalanceException {
        int randomNumber=100000001;
        when(random.nextInt(100000,100000000)).thenReturn(randomNumber);
//        Date date=new Date();
//        String txnId=""+ Objects.hash(source,target,new Date());
//        Transaction expectedTransaction=new Transaction(source,target,new Date(),100,txnId);
        Account sa= mock(SavingsAccount.class);
        Account ta=mock(SavingsAccount.class);
        Transaction t=transactionManager.transfer(sa,ta,1000);
        InOrder io=inOrder(sa,ta);
        assertEquals(""+randomNumber,t.getId());
//        transactionManager.transfer(sa,ta,1000);
        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposit(1000);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);
        assertEquals(t,transactionManager.findByTransactionId(""+randomNumber));

    }


}
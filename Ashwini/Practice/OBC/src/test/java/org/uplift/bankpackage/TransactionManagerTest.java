package org.uplift.bankpackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import org.uplift.account.SavingAccount;
import org.uplift.account.Transaction;
import org.uplift.uplifte.exceptionhandling.InsufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;
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
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sourceUser = new User("Jyoti","67543223456567","jyoti@gmaol.com","Jyoti12","Jyoti@123");
        targetUser = new User("Priti","786543479","priti@gmail.com","priti122","Priti@123");
        source = new SavingAccount("SA9877654335","Jyoti",100000,new Date(),sourceUser,10000);
        target = new SavingAccount("SA9877654335","Priti",100,new Date(),targetUser,1000);


    }
    @Test
    void transfer() throws InsufficientBalanceException {
        int randomNumer =10000001;
        when(random.nextInt(1000000,100000000)).thenReturn(randomNumer);
       // Date date = new Date();
       // String txnid = " "+ Objects.hash(source,target,new Date());
        //Transaction exceptedTransaction = new Transaction(source,target,new Date(),1000,"123");
        //assertEquals(exceptedTransaction,tm.transfer(source,target,1000).getTransactionId());
        //assertEquals(""+randomNumer,tm.transfer(source,target,1000).getTransactionId());
        Account sa = mock(SavingAccount.class);
        Account ta = mock(SavingAccount.class);
        InOrder io = inOrder(sa,ta);
        Transaction t = tm.transfer(sa,ta,1000);
        assertEquals(""+randomNumer,t.getTransactionId());

        //tm.transfer(sa,ta,1000);
        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposit(1000);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);
        assertEquals(t, tm.findByTransactionId(""+randomNumer));




    }

}
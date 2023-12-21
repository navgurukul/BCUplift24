package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import org.uplift.account.InsufficientBalanceException;
import org.uplift.account.SavingAccount;
import org.uplift.account.Transaction;
import org.uplift.user.User;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionManagerTest {

    @Mock
    private Account source;

    @Mock
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
        sourceUser = new User("AlkaNoor","6234634674","alkanoor74@gmail.com","alka","alka123");
        targetUser = new User("VanshikaKaran","7245645634","vanshikakaran23@gmail.com","vanshika","vanshika53w");

        source = new SavingAccount(sourceUser,"f2345",100000,new Date(),10000);
        target = new SavingAccount(targetUser,"52344",10000,new Date(),500);
    }



    @Test
    public void transfer() throws InsufficientBalanceException {

        int randomNumber = 10000001;
        when(random.nextInt(1000000,1000000000)).thenReturn(randomNumber);
       // assertEquals(""+randomNumber,tm.transfer(source,target,1000).getId());


        Account sa = mock(SavingAccount.class);
        Account ta = mock(SavingAccount.class);

        InOrder io = inOrder(sa,ta);
        Transaction t = tm.transfer(sa,ta,1000);

        assertEquals(""+randomNumber,tm.transfer(sa,ta,1000).getId());
        io.verify(sa,times(1)).withdraw(1000);
        io.verify(ta,times(1)).deposit(1000);

        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);

        assertEquals(t,tm.findByTransactionId(""+randomNumber));

    }


}


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
import org.uplift.exception.InvalidSufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionManagementTest {

    private Account source;
    private Account target;
    private User sourceuser;
    private User targetuser;
    @Mock
    private Random random;
    @InjectMocks
    private TransactionManagement tm;

    //private User transactionManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sourceuser=new User("user1","54765923","email.com","username1","121");
        targetuser=new User("user2","5379792","van@gmail.com","username2","132");
        source=new SavingAccount(sourceuser,"1544994",5000,new Date(),500.0);
        target=new SavingAccount(targetuser,"127057",5000,new Date(),500.0);

    }
    @Test

    void testTransfer() throws InvalidSufficientBalanceException {
        int randomNumber=1000001;
        when(random.nextInt(1000000,1000000000)).thenReturn(randomNumber);

        Account sa=mock(SavingAccount.class);
        Account ta=mock(SavingAccount.class);
        InOrder io=inOrder(sa,ta);
        Transaction ts=tm.transfer(sa,ta,1000);
        //assertEquals(""+randomNumber,tm.transfer(sa,ta,1000).getTransactionId());
       // tm.transfer(sa,ta,1000);
        verify(sa,times(1)).withDraw(1000);
        verify(ta,times(1)).deposit(1000);
        io.verify(sa).withDraw(1000);
        io.verify(ta).deposit(1000);
        //Transaction t=tm.findByTransactionId(""+randomNumber);
        assertEquals(ts,tm.findByTransactionId(""+randomNumber));

    }
}
package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.User.User;
import org.uplift.account.Account;
import org.uplift.account.SavingAccount;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientBalanceException;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class TransactionManagerTest {
    private Account sourceAccount;
    private Account targetAccount;
    private User sourceUser;
    private User targetUser;
    @Mock
    private Random random;
    @InjectMocks
    private TransactionManager transactionManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        /*sourceUser = new User("Ankit","ak","ak@12","8765345687","ankit@gmail.com");
        targetUser = new User("Mohit","mk","mk@12","5678345687","mohit@gmail.com");
        sourceAccount = new SavingAccount(sourceUser,"1234",10000,new Date());
        targetAccount = new SavingAccount(targetUser,"5678",5000,new Date());*/
    }
    @Test
    void transfer() throws InsufficientBalanceException{


        int randomNum = 1000001 ;
        when(random.nextInt(1000000,1000000000)).thenReturn(randomNum);

        Account sa =  mock(SavingAccount.class);
        Account ta =  mock(SavingAccount.class);

        Transaction actualTransactionObj = transactionManager.transfer(sa,ta,1000);
        assertEquals(""+randomNum,actualTransactionObj.getTransactionId());

        InOrder io = inOrder(sa,ta);
        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposit(1000);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);

        assertEquals(actualTransactionObj,transactionManager.findTransactionByTransactionId(""+ randomNum));
    }

}
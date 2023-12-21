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

import static org.junit.Assert.assertEquals;
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

        sourceUser=new User("Ankit","8448","ankit@gmail.com","ankit_27","7654");
        targetUser=new User("Mohit","7654","mohit@gmail.com","mohit_04","4638");

        sourceAccount = new SavingsAccount(sourceUser,"123456",6000.0,new Date(),500.0);
        targetAccount = new SavingsAccount(targetUser,"753896",3000.0,new Date(),700.0);

    }

    @Test
    void transfer() throws InsufficientBalanceException {
        int randomNumber = 1000001;
        when(random.nextInt(1000000,10000000)).thenReturn(randomNumber);
        Transaction actualTransasctionObj = transactionManager.transfer(sourceAccount,targetAccount,1000);
        Transaction expectedTransaction= transactionManager.transfer(sourceAccount,targetAccount,3000);
        assertEquals(""+randomNumber,expectedTransaction.getId() );

        Account sa = mock(SavingsAccount.class);
        Account ta = mock(SavingsAccount.class);
        InOrder io = inOrder(sa,ta);

        Transaction t = transactionManager.transfer(sa,ta,1000);
        assertEquals(""+ randomNumber, t.getId());

        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposit(1000);

        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);

        assertEquals(t,transactionManager.findByTransaction(""+ randomNumber));
    }


}
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
import org.uplift.account.exception.InsufficientBalanceException;
import org.uplift.account.user.User;
import org.uplift.bank.security.TransactionManager;

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
//        sourceUser = new User("Priya","9038534222","Priya@123","PriyaMeena","Pri@1");
//        targetUser = new User("Alice","9878986786","Alice@123","AliceBob","aliBo12");
//        source = new SavingAccount(sourceUser,"21234AC",50000.0,new Date(),500.0);
//        target = new SavingAccount(targetUser,"24343Ac",50000.0,new Date(),500.0);
    }
    @Test
    void transfer() throws InsufficientBalanceException {
        int randomNumber = 10000001;
        when(random.nextInt(100000,100000000)).thenReturn(randomNumber);
        Account sa = mock(SavingAccount.class);
        Account ta = mock(SavingAccount.class);
        InOrder in = inOrder(sa,ta);
        Transaction t = tm.transfer(sa,ta,1000);
        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposit(1000);
        in.verify(sa).withdraw(1000);
        in.verify(ta).deposit(1000);
        assertEquals(t,tm.findByTransctionId(""+randomNumber));
    }
}
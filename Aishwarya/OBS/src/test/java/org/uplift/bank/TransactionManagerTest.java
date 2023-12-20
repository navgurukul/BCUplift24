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
    private Account target;
    @Mock
    private Account source;
    private User sourceUser;
    private User targetUser;

    @Mock
    private Random random;

    @InjectMocks
    private TransactionManager tm;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        sourceUser = new User("Alka Noor", "4586621", "alka95@gmail.com", "alka3","4565");
        targetUser = new User("Vanshika karan", "4286211", "vanshikakaran@gmail.com", "vanshika","3686");
        source = new SavingAccount(sourceUser,"f5d185565", 1000000, new Date(), 10000 );
        target = new SavingAccount(targetUser, "485ds2as5", 10005421, new Date(), 23240);

    }

    @Test
    void transfer() throws InsufficientBalanceException {
        int randomNumber = 10000001;
        when(random.nextInt(1000000,1000000000)).thenReturn(randomNumber);

        Account sa = mock(SavingAccount.class);
        Account ta = mock(SavingAccount.class);
        InOrder io = inOrder(sa, ta);
        Transaction t = tm.transfer(sa, ta, 1000);
        assertEquals(""+randomNumber, t.getId() );

        verify(sa, times(1)).withdraw(1000);
        verify(ta, times( 1 )).deposit(1000);


        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);

        assertEquals(t, tm.findByTransactionId("" + randomNumber));

    }

}
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
import org.uplift.exception.InsufficientAccountBalanceException;
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
        sourceUser = new User("user1", "938752094", "us@gmail.com",
                "use12", "1234");
        targetUser = new User("user2", "25987433", "us2@gmail.com",
                "us23", "7800");

        source = new SavingsAccount(sourceUser, "123523", 100000,
                new Date(), 5000);

        target = new SavingsAccount(targetUser, "0987634", 200000,
                new Date(), 5000);
    }

    @Test
    void transfer() throws InsufficientAccountBalanceException {
        int randomNumber = 10000001;
        when(random.nextInt(100000, 1000000000)).thenReturn(randomNumber);

        Account sa = mock(SavingsAccount.class);
        Account ta = mock(SavingsAccount.class);

        InOrder io = inOrder(sa, ta);

        Transaction t = tm.transfer(sa, ta, 1000);

        assertEquals(""+randomNumber, t.getId());

        verify(sa, times(1)).withdraw(1000);
        verify(ta, times(1)).deposit(1000);

        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);

        assertEquals(t, tm.findByTransactionId(""+randomNumber));

    }
}
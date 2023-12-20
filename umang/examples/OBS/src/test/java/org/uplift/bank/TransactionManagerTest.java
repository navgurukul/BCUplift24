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
    void setUp() {
        MockitoAnnotations.openMocks(this);
        /*sourceUser = new User("Alka Noor", "02343345",
                "alkanoor3754@gmail.com", "alka", "alka123");
        targetUser = new User("Vanshika Karan", "02343345123",
                "vanshikakaran67@gmail.com", "vanshika", "vanshika123");
        source = new SavingsAccount(sourceUser, "A1235", 1000000, new Date(), 10000);
        target = new SavingsAccount(targetUser, "V1234", 2000000, new Date(), 20000);*/
    }

    @Test
    void transfer() throws InsufficientBalanceException {
        int randomNumber = 10000001;
        when(random.nextInt(1000000, 1000000000)).thenReturn(randomNumber);
        Account sa = mock(SavingsAccount.class);
        Account ta = mock(SavingsAccount.class);
        InOrder io = inOrder(sa, ta);
        Transaction t = tm.transfer(sa, ta, 1000);
        assertEquals("" + randomNumber, t.getId());
        verify(sa, times(1)).withdraw(1000);
        verify(ta, times(1)).deposit(1000);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);
        assertEquals(t, tm.findByTransactionId("" + randomNumber));
    }

}
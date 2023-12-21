package org.Uplift.Bank;

import org.Uplift.account.Account;
import org.Uplift.account.SavingsAccount;
import org.Uplift.account.Transaction;
import org.Uplift.exception.InsufficientBalanceException;
import org.Uplift.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
        sourceUser = new User("Vanshika", "9971819718", "vanshika@nuplift.org", "vanshika22", "1234");
        targetUser = new User("AlkaNoor", "9899535374", "alkanoor@uplift.org", "alka22", "5678" );
        source = new SavingsAccount(sourceUser, "225", 100000.0, new Date(), 10000);
        target = new SavingsAccount(sourceUser, "226", 200000.0, new Date(), 20000);
    }
    @Test
    void transfer() throws InsufficientBalanceException {
        int randomNumber = 10000001;
        when(random.nextInt(1000000, 1000000000)).thenReturn(randomNumber);
        Account sa = mock(SavingsAccount.class);
        Account ta = mock(SavingsAccount.class);
        Transaction t = tm.transfer(sa, ta, 1000);
        assertEquals("" + randomNumber, t.getId());
        InOrder io = inOrder(sa, ta);
        verify(sa, times(1)).withdraw(1000);
        verify(ta, times(1)).deposit(1000);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);
        assertEquals(t, tm.findByTransactionId("" + randomNumber));

    }
}
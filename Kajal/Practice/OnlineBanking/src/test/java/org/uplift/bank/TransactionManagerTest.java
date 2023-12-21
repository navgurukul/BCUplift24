package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import org.uplift.account.SavingsAccount;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientAccountBalanceException;
import org.uplift.user.User;
import org.mockito.Mock;
import java.util.Date;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionManagerTest {

    private User sourceUser;
    private User targetUser;

    @Mock
    private Random random;

    @Mock
    private AccountManager accountManager;

    @InjectMocks
    private TransactionManager tm;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testTransfer() throws InsufficientAccountBalanceException {
        int randomNumber = 100000001;
        when(random.nextInt(1000000, 1000000000)).thenReturn(randomNumber);

        Account sa = mock(SavingsAccount.class);
        Account ta = mock(SavingsAccount.class);

        InOrder io = inOrder(sa, ta);
        Transaction t =  tm.transfer(sa, ta,1000.0);

        assertEquals(""+randomNumber,t.getId());

        verify(sa, times(1)).withdraw(1000);
        verify(ta, times(1)).deposit(1000);

        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);

        assertEquals(t , tm.findByTransactionId(""+randomNumber));
    }

    @Test
    void makePayment() throws InsufficientAccountBalanceException {
        int randomNumber = 100000001;
        when(random.nextInt(1000000, 1000000000)).thenReturn(randomNumber);

        Account sa = mock(SavingsAccount.class);
        Account ta = mock(SavingsAccount.class);

        when(accountManager.findByAccountNumber("a1234")).thenReturn(sa);
        when(accountManager.findByPhoneNumber("+91-7866533299")).thenReturn(ta);


        assertEquals(""+randomNumber ,
                tm.makePayment("a1234", TransferType.ACCOUNT_ID, "+91-7866533299",
                        TransferType.MOBILE,1450.0).getId());
    }

}
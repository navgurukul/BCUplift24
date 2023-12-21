package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.uplift.account.Account;
import org.uplift.account.SavingAccount;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.user.User;

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
    private  TransactionManager tm;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
//        sourceUser = new User("nikita dagwar", "9307025958", "Ndgwar", "nk12345");
//       targetUser = new User("prajkta dagwar", "9527192982", "pdgwar", "pj12345");
//
//        source = new SavingAccount(sourceUser, "1234", 5000000, new Date(), 12000);
//        target= new SavingAccount(targetUser, "46546", 6000000, new Date(), 22000);

    }

    @Test
    void transfer() throws InsufficientBalanceException {
        int randomNumber=1000001;
        when(random.nextInt(1000000,1000000000)).thenReturn(randomNumber);
        Account  sa=mock(SavingAccount.class);
        Account ta=mock(SavingAccount.class);

        InOrder io= inOrder(sa,ta);
        Transaction t=tm.transfer(sa,ta,10000);
        assertEquals(""+randomNumber,t.getId());

        verify(sa,times(1)).withdraw(10000);
        verify(ta,times(1)).deposit(10000);

        io.verify(sa).withdraw(10000);
        io.verify(ta).deposit(10000);

        assertEquals(t,tm.findByTransactionId(""+randomNumber));

    }


}
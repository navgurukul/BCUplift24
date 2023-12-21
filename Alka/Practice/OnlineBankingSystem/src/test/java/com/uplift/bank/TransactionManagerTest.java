package com.uplift.bank;

import com.sun.source.tree.UsesTree;
import com.uplift.account.Account;
import com.uplift.account.SavingsAccount;
import com.uplift.account.Transaction;
import com.uplift.exceptions.InsufficietBalanceException;
import com.uplift.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionManagerTest {

    private Account source;
    private Account target;

    private User sourceUser;
    private User targetUser;

    @Mock
    private Random random;

    @Mock
    private Set<Transaction> transactionHistory=new HashSet<>();

    @InjectMocks
    private TransactionManager tm;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
//        sourceUser = new User("Alka Noor","89284201032","alkanoor3754@gmail.com","Alka","alka@noor111");
//        targetUser = new User("Vanshika","739241032","vanshikak3754@gmail.com","Vanshika","vanshika@111");
//        source = new SavingsAccount(sourceUser,"A1234563",1000000,new Date(),10000);
//        target = new SavingsAccount(targetUser,"A133232",2000000,new Date(),20000);
    }

    @Test
    void transfer() throws InsufficietBalanceException {
        int randomNumber = 10000001;
        when(random.nextInt(1000000,1000000000)).thenReturn(randomNumber);
        Account sa = mock(SavingsAccount.class);
        Account ta = mock(SavingsAccount.class);
        InOrder io = inOrder(sa,ta);
        Transaction t = tm.transfer(sa,ta,1000);
        assertEquals(""+randomNumber,t.getId());
        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposit(1000);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);
        assertEquals(t,tm.findByTransactionId(""+randomNumber));
    }
}
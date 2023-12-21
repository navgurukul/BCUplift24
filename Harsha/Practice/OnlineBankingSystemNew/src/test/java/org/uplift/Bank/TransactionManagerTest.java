package org.uplift.Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.uplift.account.Account;
import org.uplift.account.SavingAccount;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

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
        sourceUser = new User("Harsha","9870654321","abc@gmail","harsha","pass");
        targetUser = new User("Priya","9870654322","priya@gmail","priya","priya123");
        source = new SavingAccount(sourceUser,"A12",5000.0,new Date(),1000);
        target = new SavingAccount(targetUser,"B12",3000.0,new Date(),500);


    }

    @Test
    void transfer() throws InsufficientBalanceException {
        int randomNumber = 10000001;
        when(random.nextInt(1000000,100000000)).thenReturn(randomNumber);
        //Date date= new Date();
        //String txnId = " "+ Objects.hash(source,target,new Date());
        //Transaction expectedTransaction = new Transaction(source,target,new Date(),1000,"123");
        Account sa= mock(SavingAccount.class);
        Account ta=mock(SavingAccount.class);
        InOrder io= inOrder(sa,ta);
        Transaction t= tm.transfer(sa,ta,1000);
        assertEquals(""+randomNumber,t.getId());
        //assertEquals(""+randomNumber,tm.transfer(sa,ta,1000).getId());
        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposit(1000);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);
        assertEquals(t, tm.findByTransactionId(""+randomNumber));
    }
}
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
import org.uplift.exception.InSufficientBalanceException;
import org.uplift.user.User;

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
      /* sourceUser=new User("mohit","9876543","mohit22@gmail.com","raj","12");
       targetUser=new User("nilkita","9873","nikita22@gmail.com","danwar","13");
       source=new SavingAccount(sourceUser,10000,"21",new Date(),1000);
        target=new SavingAccount(targetUser,100000,"213",new Date(),1000);*/

    }
    @Test
    void testForransafer() throws InSufficientBalanceException {
        int randomNumber=10000001;
        when(random.nextInt(100000,100000000)).thenReturn(randomNumber);
        Account sa=mock(SavingAccount.class);
        Account ta=mock(SavingAccount.class);
        InOrder io=inOrder(sa,ta);
//        tm.transfer(sa,ta,1000);
        Transaction t=tm.transfer(sa,ta,1000);
        assertEquals(""+randomNumber,t.getId());
        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposite(1000);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposite(1000);
        assertEquals(t,tm.findByTransactionId(""+randomNumber));

    }

    @Test
    void testOTP(){
        int randomNumber=100000;
        when(random.nextInt(100000,900000)).thenReturn(randomNumber);
        assertEquals(randomNumber,tm.generateOtp());
    }

    @Test

    void verifyTransaction(){

    }


}
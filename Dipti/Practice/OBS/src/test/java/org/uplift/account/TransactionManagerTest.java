package org.uplift.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.user.User;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class TransactionManagerTest {

    private Account sourceUser;
    private Account targetUser;

    private Account source;
    private Account target;
    @Mock
    private Random random;
    @InjectMocks
    private TransactionManager tm;
    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    User sourceUser =new User("dipti thakre","7666623646","thakre123dipti@gail.com","thakre123dipti","miss@123");
   User  targetUser =new User("trupit thakre","99923646","trupt123@gail.com","trupti123","pass@123");
    source=new SavingsAccount(sourceUser,"A344",7000.0,new Date(),1000);
    target=new SavingsAccount(targetUser,"B99",4000.0,new Date(),500.0);
    }

    @Test
    void transfer() throws InsufficientBalanceException {
        int randomNumber=10000001;
        when(random.nextInt(1000000,1000000000)).thenReturn(randomNumber);
       // Transaction ExpectedTransaction= new Transaction(source,target,new Date(),"12");

        Account sa= mock(SavingsAccount.class); //manually generating mock
        Account ta=mock(SavingsAccount.class);
        InOrder io=inOrder(sa,ta);
        Transaction t= tm.transfer(sa,ta,1000);
        assertEquals("" + randomNumber,t.getId());


        verify(sa,times(1)).withdraw(1000.0);
        verify(ta,times(1)).deposit(1000.0);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);

        assertEquals(t,tm.findByTransaction(""+ randomNumber));


    }
}
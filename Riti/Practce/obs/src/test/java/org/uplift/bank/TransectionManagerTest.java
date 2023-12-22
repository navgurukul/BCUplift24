package org.uplift.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import org.uplift.account.Saving;
import org.uplift.account.Transection;
import org.uplift.exceptions.InsuffucentBalanceException;
import org.uplift.user.User;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransectionManagerTest {
    private Account source;
    private Account target;

    private User sourceUser;
    private User targetUser;
    @Mock
    private Random random;
    @InjectMocks
    private TransectionManager transectionManager;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
//        sourceUser=new User("Riti Sharma","ritisharma@123gmail.com","1234567","riti_sharma","riti@12345");
//        targetUser= new User("Mayank","mayank@bhardwaj@2001.gmail.com","734237922","mayank_bhardwaj","riti_bhardwaj");
//        source=new Saving(sourceUser,"xxxx",200000,new Date(),10000);
//        target=new Saving(targetUser,"yyyy",100000,new Date(),20000);


    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void testTransfer() throws InsuffucentBalanceException {
        int randomeNumber=1000001;
        when(random.nextInt(10000000,100000001)).thenReturn(randomeNumber);
        Account sa=mock(Saving.class);
        Account ta=mock(Saving.class);
        InOrder io=inOrder(sa,ta);
        Transection t=transectionManager.transfer(sa,ta,1000.0);
        assertEquals(""+randomeNumber,t.getId());;

       verify(sa,times(1)).withdraw(1000);
       verify(ta,times(1)).deposit(1000);

        //it is diciding the order of mocking
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);
        assertEquals(t,transectionManager.findByTransectionId(""+randomeNumber));

    }

}
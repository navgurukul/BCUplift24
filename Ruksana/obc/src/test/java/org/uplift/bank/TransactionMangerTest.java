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
import org.uplift.exception.InvalidSufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TransactionMangerTest {

    private Account source;

    private Account target;
    private User sourceUser;
    private User targetUser;
    @Mock
    private Random random;

    @InjectMocks

    private TransactionManger tm;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        //source = new SavingsAccount("A123",23445);
        sourceUser = new User("ruksana", "63056322", "rukku@gmail.com", "rukku123", "2024");
        targetUser = new User("user2", "63482636", "sreekanya@gmail.com", "pandu11", "2343");
        source = new SavingsAccount(sourceUser, "23457432", 1000.0, new Date(), 10000);
        target = new SavingsAccount(targetUser, "243546", 2938.0, new Date(), 98273);


    }

    //@Test
//void transfer(){

//
//        Transaction exceptedTransaction= new TransactionManger.target(source,target,new Date(),1000,"123");
//        assertEquals(exceptedTransaction,TransactionManger,transfer(source,target,1000));
//
//    }



//    void testTransaction() throws InvalidSufficientBalanceException {
////        transaction.transfer(source,target,1000);
////    }
//        //void test
////        Transaction expectedTransaction = new Transaction(source, target, new Date(), 1000, "123");
////        TransactionManger TransactionManager = null;
////        assertEquals(expectedTransaction, TransactionManager.transfer(source, target, 1000));
//        Date date = new Date();
//        String txnId = "" + Objects.hash(source,target,date);
//
//        Transaction expectedTransaction=new Transaction(source,target,new Date(),1000,"123");
//        assertEquals(expectedTransaction,TransactionManger.transfer(source,target,1000));


    @Test
    void testTransfer() throws InvalidSufficientBalanceException {
        int randomNumber = 10000001;
        when(random.nextInt(100000, 100000000)).thenReturn(randomNumber);
//  Date date=new Date();
//  String transactionId=""+ Objects.hash(source,target,new Date());Transaction expectedTransaction=new Transaction(source,target,new Date(),1000,"123");
        //assertEquals("" + randomNumber, tm.transfer(source, target, 1000).getId());
        Account sa = mock(SavingsAccount.class);
        Account ta = mock(SavingsAccount.class);
        InOrder io= inOrder(sa,ta);
        Transaction ts = tm.transfer(sa,ta, 1000);
       // tm.transfer(sa,ta,1000);
        verify(sa,times(1)).withDraw(1000);
        verify(ta,times(1)).deposit(1000);
        io.verify(sa).withDraw(1000);
        io.verify(ta).deposit(1000);
        //Transaction ts= tm,findByTransactionId(""+randomNumber){
        assertEquals(ts,tm.findByTransactionId(""+randomNumber));

      }


    }


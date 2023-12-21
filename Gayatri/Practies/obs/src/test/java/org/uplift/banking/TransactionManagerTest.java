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
import org.uplift.exception.OtpExpiredException;
import org.uplift.security.OTPManager;
import org.uplift.user.User;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionManagerTest {
    private Account sourceUser;
    private Account targetUser;

    private Account source;
    private Account target;


    @Mock
    private Random random;
    @Mock
    OTPManager otpManager;
    @InjectMocks
    private TransactionManager tm;
    @Mock
    private AccountManager am;
    private static final int Random_Number = 10000001;
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


        // Transaction ExpectedTransaction= new Transaction(source,target,new Date(),"12");

        Account sa= mock(SavingsAccount.class); //manually generating mock
        Account ta=mock(SavingsAccount.class);
        InOrder io=inOrder(sa,ta);
        Transaction t= tm.transfer(sa,ta,1000);
        assertEquals("" + Random_Number,t.getId());


        verify(sa,times(1)).withdraw(1000.0);
        verify(ta,times(1)).deposit(1000.0);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);

        assertEquals(t,tm.findByTransaction(""+ Random_Number));

    }
    @Test
    void makePayment() throws InsufficientBalanceException, OtpExpiredException {
        Account sa = mock(SavingsAccount.class);
        Account ta = mock(SavingsAccount.class);

        //int randomNumber = 10000001;//         this is a stubb.
        when(random.nextInt(1000000,100000000)).thenReturn(Random_Number);
        when(am.findByAccountNumber("A12")).thenReturn(sa);
        when(am.findMyMobile("+91-1234")).thenReturn(ta);
        when(otpManager.validateOtp()).thenReturn(true);
        assertEquals("" + Random_Number,tm.makePayment("A12",TransferType.ACCOUNTID,"+91-1234",TransferType.MOBILE,1450.5).getTransactionId());
        verify(otpManager,times(1)).validateOtp();

    }

}
package org.example.banking;

import org.example.account.Account;
import org.example.banking.security.OTPManager;
import org.example.exception.InsufficientBalanceException;
import org.example.account.SavingAccount;
import org.example.account.Transaction;
import org.example.exception.InvalidOtpException;
import org.example.exception.OTPExpiredException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

import static org.example.banking.TransferType.ACCOUNT_NUMBER;
import static org.example.banking.TransferType.MOBILE_NUMBER;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionManagerTest {

    private Account source;
    private Account target;
    private static final int RANDOM_NUMBER =10000001;
    private static final String ACCOUNT_NO ="A1234";
    private static final String MOBILE_NO ="+91-9090909090";

    @Mock
    private Account sa;
    @Mock
    private Account ta;
    @Mock
    AccountManager accountManager;
    @Mock
    OTPManager otpManager;
    @Mock
    private Random random;
    @InjectMocks
    private TransactionManager tm;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Account sa=mock(SavingAccount.class);
        Account ta=mock(SavingAccount.class);
        when(accountManager.findByAccountNumber(ACCOUNT_NO)).thenReturn(sa);
        when(accountManager.findByMobile(MOBILE_NO)).thenReturn(ta);
//        sourceUser=new User("Neha Saraf","9999999999","nehasaraf@gmail.com","nehasaraf","12345");
//        tragetUser=new User("Janhvi Shende","88888888","janvhishende@gmail.com","janvhishende","54321");
//        source=new SavingAccount(sourceUser,"12345678",200000,new Date(),1000);
//        target=new SavingAccount(tragetUser,"23456789",50000,new Date(),20000);


    }
    @Test
    void transfer() throws InsufficientBalanceException {
        //int randomNumber=10000001;
        when(random.nextInt(1000000,100000000)).thenReturn(RANDOM_NUMBER);
        Date date=new Date();
        String txnId=""+Objects.hash(source,target,new Date());
        Transaction expectedTransaction=new Transaction(source,target,new Date(),100,"123");
        //assertEquals(""+randomNumber,tm.transfer(source,target,1000).getId());
//        Account sa=mock(SavingAccount.class);//on the basis of account we created mocks manually by mock method.
//        Account ta=mock(SavingAccount.class);
        //tm.transfer(sa,ta,1000);
        InOrder io=inOrder(sa,ta);
        Transaction t=tm.transfer(sa,ta,1000);
        assertEquals(""+RANDOM_NUMBER,t.getId());
        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposit(1000);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);
        assertEquals(t,tm.findByTransactionId(""+RANDOM_NUMBER));

    }
    @Test
    void testMakePayment() throws InsufficientBalanceException, OTPExpiredException, InvalidOtpException {
        //int randomNumber=1000001;
        when(random.nextInt(1000000,100000000)).thenReturn(RANDOM_NUMBER);//change randomNumber to RANDOM_NUMBER
//        Account sa=mock(SavingAccount.class);
//        Account ta=mock(SavingAccount.class);
//        when(accountManager.findByAccountNumber("A1234")).thenReturn(sa);
//        when(accountManager.findByMobile("+91-9090909090")).thenReturn(ta);
        when(otpManager.validateOTP()).thenReturn(true);
        assertEquals("" + RANDOM_NUMBER,
                tm.makePayment(ACCOUNT_NO, ACCOUNT_NUMBER,MOBILE_NO, MOBILE_NUMBER,1450.25).getId());
        //tm.makePayment("A1234", TransferType.ACCOUNT_NUMBER,"+91-9090909090",TransferType.MOBILE_NUMBER,1450.25);
        verify(otpManager,times(1)).validateOTP();
    }

    @Test
    void testMakePaymentThrowsInvalidOtpException() throws InvalidOtpException, OTPExpiredException {
        when(otpManager.validateOTP()).thenReturn(false);
        assertThrows(InvalidOtpException.class,
                ()->tm.makePayment(ACCOUNT_NO, ACCOUNT_NUMBER,MOBILE_NO, MOBILE_NUMBER,1450.25));
    }
}
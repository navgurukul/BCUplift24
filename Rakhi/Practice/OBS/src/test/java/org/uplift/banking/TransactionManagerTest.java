package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import org.uplift.account.SavingsAccount;
import org.uplift.account.Transaction;
import org.uplift.banking.security.OtpManager;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.exception.InvalidOtpException;
import org.uplift.exception.OtpExpiredException;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionManagerTest {
    @Mock
    private Random random;

    @Mock
    AccountManager accountManager;

    @Mock
    OtpManager otpManager;

    @Mock
    Account sa;
    @Mock
    Account ta;


    public static final int RANDOM_NUMBER=100000001;
    public static final String MOBILE="123456";
    public static final String ACCOUNT_ID="A123";


    @InjectMocks
    private TransactionManager transactionManager;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        Account sa=mock(SavingsAccount.class);
        Account ta=mock(SavingsAccount.class);
        when(random.nextInt(100000,100000000)).thenReturn(100000001);
        when(accountManager.findByAccountNumber(ACCOUNT_ID)).thenReturn(sa);
        when(accountManager.findByMobile(MOBILE)).thenReturn(ta);
    }

    @Test
    void transfer() throws InsufficientBalanceException {
//        when(random.nextInt(100000,100000000)).thenReturn(RANDOM_NUMBER);
//        Date date=new Date();
//        String txnId=""+ Objects.hash(source,target,new Date());
//        Transaction expectedTransaction=new Transaction(source,target,new Date(),100,txnId);
        InOrder io=inOrder(sa,ta);

        Transaction t=transactionManager.transfer(sa,ta,1000);

        assertEquals(""+RANDOM_NUMBER,t.getId());
//        transactionManager.transfer(sa,ta,1000);
        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposit(1000);

        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);

        assertEquals(t,transactionManager.findByTransactionId(""+RANDOM_NUMBER));

    }


    @Test
    void makePayment() throws InsufficientBalanceException, OtpExpiredException, InvalidOtpException {
        when(otpManager.validateOtp()).thenReturn(true);
        assertEquals(""+RANDOM_NUMBER,
                transactionManager.makePayment("A123", TransferType.ACCOUNT_ID,"123456",
                        TransferType.MOBILE,10000.0).getId());

        verify(otpManager,times(1)).validateOtp();
    }

    @Test
    void makePaymentThrowsInvalidException()throws OtpExpiredException{
        when(otpManager.validateOtp()).thenReturn(false);
        assertThrows(InvalidOtpException.class,()->transactionManager.makePayment("A123", TransferType.ACCOUNT_ID,"123456",
                TransferType.MOBILE,10000.0).getId());
    }
}
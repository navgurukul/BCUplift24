package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exception.InSufficientBalanceException;
import org.uplift.security.AccountManager;
import org.uplift.security.OtpExpireException;
import org.uplift.security.OtpManager;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.uplift.banking.Transfertype.MOBILE;

class TransactionManagerTest {
    @Mock
   private Account sa;
    @Mock
    private Account ta;
//    private User sourceUser;
//    private User targetUser;
    @Mock
    private AccountManager accountManager;
    @Mock
    private OtpManager otpManager;

    @Mock
    private Random random;
    @InjectMocks
    private TransactionManager tm;
    private static final int RANDOM_NUMBER=100000;
    private static final String MOBILE_NUMBER="876543";
    private static final String ACCOUNT_NUMBER="a1234";


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(random.nextInt(100000,100000000)).thenReturn(RANDOM_NUMBER);
        when(accountManager.findAccountByMobile(MOBILE_NUMBER)).thenReturn(ta);
        when(accountManager.findAccountNumber(ACCOUNT_NUMBER)).thenReturn(sa);



    }
    @Test
    void transafer() throws InSufficientBalanceException {
//        int randomNumber=10000001;
//        when(random.nextInt(100000,100000000)).thenReturn(randomNumber);
        InOrder io=inOrder(sa,ta);
        Transaction t=tm.transfer(sa,ta,1000);
        assertEquals(""+RANDOM_NUMBER,t.getId());
        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposite(1000);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposite(1000);
        assertEquals(t,tm.findByTransactionId(""+RANDOM_NUMBER));

    }
    @Test
    void makePayment() throws InSufficientBalanceException, OtpExpireException, InvalidOtpException {

        when(otpManager.validateOtp()).thenReturn(true);
        assertEquals("" +
                ""+RANDOM_NUMBER,tm.makePayment(ACCOUNT_NUMBER,Transfertype.ACCOUNT,MOBILE_NUMBER, MOBILE,1000).getId());
        verify(otpManager,times(1)).validateOtp();
    }
    @Test
    void makePaymentThrowInvalidOtpException() throws OtpExpireException {
        when(otpManager.validateOtp()).thenReturn(false);
        assertThrows(InvalidOtpException.class,()->tm.makePayment(ACCOUNT_NUMBER,Transfertype.ACCOUNT,MOBILE_NUMBER,Transfertype.MOBILE,100));
    }
}
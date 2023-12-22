package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.User.User;
import org.uplift.account.Account;
import org.uplift.account.SavingsAccount;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.exception.InvalidOtpException;
import org.uplift.exception.OtpExpiredException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionManagerTest {
    private Account source;
    private Account target;
    private User targetUser;
    private User sourceUser;
    private OtpManager otpManager;
    @Mock
    private Account sa;
    @Mock
    private Account ta;

    @Mock
    private OtpManager otpmanager;
    @Mock
    private AccountManager accountManager;
    @Mock
    private Random random;

    @InjectMocks
    private TransactionManager tm;
    private static final String ACCOUNT_NUMBER = "100002";
    private static final String MOBILE = "123456789";

private static final int RANDOM_NUMBER = 1000001;
    @BeforeEach
    void setup(){

        MockitoAnnotations.openMocks(this);
        when(random.nextInt(1000000,1000000000)).thenReturn(RANDOM_NUMBER);
        when(accountManager.findByAccountnumber("a1234")).thenReturn(sa);
        when(accountManager.findByMobile("123456789")).thenReturn(ta);
     }
    @Test
    void transfer() throws InsufficientBalanceException {

        when(random.nextInt(1000000,1000000000)).thenReturn(RANDOM_NUMBER);



         InOrder io = inOrder(sa,ta);
        Transaction t = tm.transfer(sa,ta,1000);
        assertEquals(""+RANDOM_NUMBER,t.getTransactionId());
        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposit(1000);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);
       assertEquals(t,tm.findByTransactionId(""+RANDOM_NUMBER));

    }

@Test
// third when se baki hai;
    void makePayment() throws InsufficientBalanceException, InvalidOtpException, OtpExpiredException {

        when(random.nextInt(1000000,1000000000)).thenReturn(RANDOM_NUMBER);
        when(accountManager.findByAccountnumber("a1234")).thenReturn(sa);
        when(accountManager.findByMobile("123456789")).thenReturn(ta);
        when(otpmanager.validateOtp()).thenReturn(true);
        assertEquals(""+RANDOM_NUMBER,
                tm.makePayment("a1234",TransferType.ACCOUNT, TransferType.MOBILE,"123456789",15155.7).getTransactionId());
        verify(otpmanager, times(1)).validateOtp();
    }

    @Test
    void makePaymentThrowsInvalidOtpException()
            throws InsufficientBalanceException, InvalidOtpException, OtpExpiredException {
        when(otpmanager.validateOtp()).thenReturn(false);
        assertThrows(InvalidOtpException.class,() -> tm.makePayment(ACCOUNT_NUMBER,TransferType.ACCOUNT,TransferType.MOBILE,MOBILE,1000.0));

    }
}
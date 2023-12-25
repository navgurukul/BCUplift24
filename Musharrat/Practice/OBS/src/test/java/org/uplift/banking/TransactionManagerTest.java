package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.banking.security.OtpManager;
import org.uplift.exception.InsufficientAccountBalanceException;
import org.uplift.exception.InvalidOtpException;
import org.uplift.exception.OtpExpiredException;


import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionManagerTest {

    @Mock
    private Random random;

    @Mock
    private AccountManager accountManager;
    @Mock
    private OtpManager otpManager;
    @Mock
    private Account sa;
    @Mock
    private Account ta;
    @InjectMocks
    private TransactionManager tm;

    private static final int RANDOM_NUMBER = 10000001;
    private static final String ACCOUNT_NUMBER = "a1234";
    private static final String MOBILE_NUMBER = "+91-582430953";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


        when(random.nextInt(100000, 1000000000)).thenReturn(RANDOM_NUMBER);

        when(accountManager.findByAccountNumber(ACCOUNT_NUMBER)).thenReturn(sa);
        when(accountManager.findByPhoneNumber(MOBILE_NUMBER)).thenReturn(ta);
    }

    @Test
    void transfer() throws InsufficientAccountBalanceException {


        InOrder io = inOrder(sa, ta);

        Transaction t = tm.transfer(sa, ta, 1000);

        assertEquals(""+RANDOM_NUMBER, t.getId());

        verify(sa, times(1)).withdraw(1000);
        verify(ta, times(1)).deposit(1000);

        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);

        assertEquals(t, tm.findByTransactionId(""+RANDOM_NUMBER));

    }

    @Test
    void makePayment() throws InsufficientAccountBalanceException, OtpExpiredException, InvalidOtpException {

        when(otpManager.validateOtp()).thenReturn(true);

        assertEquals(""+RANDOM_NUMBER, tm.makePayment("a1234", TransferType.ACCOUNT_ID,
                "+91-582430953", TransferType.MOBILE, 4769.49).getId());

        verify(otpManager, times(1)).validateOtp();
    }

    @Test
    void makePaymentThrowsInvalidOtpException() throws OtpExpiredException {
        when(otpManager.validateOtp()).thenReturn(false);

        assertThrows(InvalidOtpException.class, () -> tm.makePayment("a1234", TransferType.ACCOUNT_ID,
                "+91-582430953", TransferType.MOBILE, 4769.49).getId());

    }
}
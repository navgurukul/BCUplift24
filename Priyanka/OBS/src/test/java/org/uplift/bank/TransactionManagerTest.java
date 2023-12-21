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
import org.uplift.account.exception.InsufficientBalanceException;
import org.uplift.account.exception.InvalidOtpException;
import org.uplift.account.user.User;
import org.uplift.bank.security.TransactionManager;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionManagerTest {
    @Mock
    private Account sa;
    @Mock
    private Account ta;
    private User sourceUser;
    private User targetUser;
    @Mock
    private Random random;
    @Mock
    private AccountManager accountManager;
    @Mock
    private OtpGenerator otpGenerator;
    @InjectMocks
    private TransactionManager tm;
    private static final int RANDOM_NUMBER = 10000001;
    private static final String  ACCOUNT_NUMBER = "123Ac";
    private static final String MOBILE_NUMBER = "998877899";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(random.nextInt(100000,100000000)).thenReturn(RANDOM_NUMBER);
        when(accountManager.findbyAccountNumber(ACCOUNT_NUMBER)).thenReturn(sa);
        when(accountManager.findByMobileNumber(MOBILE_NUMBER)).thenReturn(ta);
    }
    @Test
    void transfer() throws InsufficientBalanceException {
        Account sa = mock(SavingAccount.class);
        Account ta = mock(SavingAccount.class);
        InOrder in = inOrder(sa,ta);
        Transaction t = tm.transfer(sa,ta,1000);
        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposit(1000);
        in.verify(sa).withdraw(1000);
        in.verify(ta).deposit(1000);
        assertEquals(t,tm.findByTransctionId(""+RANDOM_NUMBER));
    }
    @Test
    void makePayment() throws InsufficientBalanceException, OtpExpiredException, InvalidOtpException {
        when(otpGenerator.validateOtp()).thenReturn(true);
        assertEquals(""+RANDOM_NUMBER,tm.makePayment(ACCOUNT_NUMBER,TransferType.account,MOBILE_NUMBER,TransferType.mobile,1200.0).getId());
        verify(otpGenerator,times(1)).validateOtp();

    }

    @Test
    void makePaymentThrowInvalidOtpException() {

    }
}
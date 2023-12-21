package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import org.uplift.account.SavingAccount;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.exception.OtpExpiredException;
import org.uplift.exception.OtpMismatchedException;
import org.uplift.security.OtpManager;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class TransactionManagerTest {
    public static final int RANDOM_NUMBER = 1000001;
    public Account sourceAccount;
    public Account targetAccount;
    @Mock
    private Random random;
    @Mock
    private AccountManager accountManager;
    @Mock
    private OtpManager otpManager;
    @InjectMocks
    private TransactionManager transactionManager;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        when(random.nextInt(1000000,1000000000)).thenReturn(RANDOM_NUMBER);
        sourceAccount = mock(SavingAccount.class);
        targetAccount = mock(SavingAccount.class);
        when(accountManager.findAccountByAccountNumber("a1234")).thenReturn(sourceAccount);
        when(accountManager.findAccountByPhoneNumber("+91 45678678")).thenReturn(targetAccount);
    }
    @Test
    void transfer() throws InsufficientBalanceException{

        Transaction actualTransactionObj = transactionManager.transfer(sourceAccount,targetAccount,1000);
        assertEquals(""+RANDOM_NUMBER,actualTransactionObj.getTransactionId());

        InOrder io = inOrder(sourceAccount,targetAccount);
        verify(sourceAccount,times(1)).withdraw(1000);
        verify(targetAccount,times(1)).deposit(1000);
        io.verify(sourceAccount).withdraw(1000);
        io.verify(targetAccount).deposit(1000);

        assertEquals(actualTransactionObj,transactionManager.findTransactionByTransactionId(""+ RANDOM_NUMBER));
    }
    @Test
    void makePayment() throws InsufficientBalanceException, OtpExpiredException, OtpMismatchedException {
        when(otpManager.validateOtp()).thenReturn(true);
        assertEquals("" + RANDOM_NUMBER , transactionManager.makePayment("a1234",TransferType.ACCOUNTNUMBER,"+91 45678678", TransferType.MOBILE,1000).getTransactionId());
        verify(otpManager,times(1)).validateOtp();
    }
    @Test
    void makePaymentThrowsOtpMismatchedException() throws  OtpExpiredException {
        when(otpManager.validateOtp()).thenReturn(false);
        assertThrows(OtpMismatchedException.class,()->transactionManager.makePayment("a1234",TransferType.ACCOUNTNUMBER,"+91 45678678", TransferType.MOBILE,1000));
    }

}
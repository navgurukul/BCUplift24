package org.uplift.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.mockito.*;
import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exceptions.InsufficietBalanceException;
import org.uplift.exceptions.InvalidOtpException;
import org.uplift.exceptions.OtpExpiredException;
import org.uplift.security.OtpManager;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionManagerTest {

    @Mock
    private Account sa;
    @Mock
    private  Account ta;

    @Mock
    private Random random;

//    @Mock
//    private Set<Transaction> transactionHistory=new HashSet<>();

    @Mock
    private AccountManager accountManager;

    @Mock
    private OtpManager otpManager;

    @InjectMocks
    private TransactionManager tm;

    private  static  final int RANDOM_NUMBER = 10000001;
    private static final String ACCOUNT_NUMBER = "12345677";

    private static final String MOBILE = "91+ 728129281728";


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(random.nextInt(1000000,1000000000)).thenReturn(RANDOM_NUMBER);
        when(accountManager.findByAccountNumber(ACCOUNT_NUMBER)).thenReturn(sa);
        when(accountManager.findByPhoneNumber(MOBILE)).thenReturn(ta);
    }

    @Test
    void transfer() throws InsufficietBalanceException {
        //when(random.nextInt(1000000,1000000000)).thenReturn(RANDOM_NUMBER);
        InOrder io = inOrder(sa,ta);
        Transaction t = tm.transfer(sa,ta,1000);
        assertEquals(""+RANDOM_NUMBER,t.getId());
        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposit(1000);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);
        assertEquals(t,tm.findByTransactionId(""+RANDOM_NUMBER));
    }

    @Test
    void makePayment() throws InsufficietBalanceException, OtpExpiredException, InvalidOtpException {
        when(otpManager.validiateOtp()).thenReturn(true);
        assertEquals("" + RANDOM_NUMBER,tm.makePayment(ACCOUNT_NUMBER,
                TransferType.ACCOUNT_ID, MOBILE,TransferType.MOBILE,1450.5).getId());
        verify(otpManager,times(1)).validiateOtp();
    }

    @Test
    void makePaymentThrowsInvalidOtpEXception() throws InsufficietBalanceException, OtpExpiredException, OtpExpiredException{
        when(otpManager.validiateOtp()).thenReturn(false);
        assertThrows(InvalidOtpException.class, ()-> tm.makePayment(ACCOUNT_NUMBER,
                TransferType.ACCOUNT_ID,MOBILE,TransferType.MOBILE,1234.0));
    }


}
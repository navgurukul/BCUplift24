package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.banking.security.OTPManager;
import org.uplift.exception.InSufficientBalanceException;
import org.uplift.exception.InvalidOTPException;
import org.uplift.exception.OTPExpiredException;
import org.uplift.user.User;

import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionManagerTest {

    @Mock
    public AccountManager am;


    @Mock
    private Account sa;

    @Mock
    private Account ta;
    private User sourceUser;
    private User targetUser;
    private User user;

    @Mock
    private OTPManager otp;


    @Mock
    private  Random random;

    @InjectMocks
    private TransactionManager tm;
    private Scanner scanner;

    private static final int RANDOM_NUMBER = 10000001;
    private static final String ACCOUNT_NUMBER = "a12";
    private static final String MOBILE = "+91-1234";


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
//       sourceUser = new User("Janhvi","1234","janhvi12@gmail.com","janhvi12","janu123");
//       targetUser = new User("Sanika","2324","sanika@gmail.com","sanu@12","sanu123");
//       source = new SavingAccount(sourceUser,"J12345",100000,new Date(),1000);
//       target = new SavingAccount(targetUser,"S1234",20000,new Date(),2000);

        when(random.nextInt(100000,100000000)).thenReturn(RANDOM_NUMBER);
        when(am.finByAccountNumber(ACCOUNT_NUMBER)).thenReturn(sa);
        when(am.findMyMobile(MOBILE)).thenReturn(ta);

    }

    @Test
    void transfer() throws InSufficientBalanceException {

        //assertEquals(""+randomNumber,tm.transfer(source,target,1000).getTransactionId());
        //Account sa = mock(SavingAccount.class);//on the basis of saving account we create mocks manually by mock method.
        //Account ta = mock(SavingAccount.class);
        InOrder io = inOrder(sa,ta);
        //tm.transfer(sa,ta,1000);
        Transaction t = tm.transfer(sa,ta,1000);
        assertEquals("" + RANDOM_NUMBER,t.getTransactionId());
        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposit(1000);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);
        assertEquals(t,tm.findByTransactionID(""+RANDOM_NUMBER));

    }


    @Test
    void makePayment() throws InSufficientBalanceException, OTPExpiredException, InvalidOTPException {
        when(otp.validateOTP()).thenReturn(true);
        assertEquals("" + RANDOM_NUMBER ,tm.makePayment(ACCOUNT_NUMBER,TransferType.ACCOUNT_ID,MOBILE,TransferType.MOBILE,1450.5).getTransactionId());
        verify(otp,times(1)).validateOTP();

    }

    @Test
    void makePaymentIfThrowsInvalidOtpException()  throws InSufficientBalanceException, OTPExpiredException, InvalidOTPException {
        when(otp.validateOTP()).thenReturn(false);
        assertThrows(InvalidOTPException.class ,() -> tm.makePayment(ACCOUNT_NUMBER,TransferType.ACCOUNT_ID,MOBILE,TransferType.MOBILE,1450.5));

    }

}
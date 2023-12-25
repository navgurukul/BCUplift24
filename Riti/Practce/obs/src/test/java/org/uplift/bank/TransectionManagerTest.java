package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import org.uplift.account.AccountManager;
import org.uplift.account.Saving;
import org.uplift.account.Transection;
import org.uplift.bank.OTPExpiredException;
import org.uplift.bank.TransectionManager;
import org.uplift.bank.security.OTPManager;
import org.uplift.exceptions.InsuffucentBalanceException;
import org.uplift.exceptions.InvalidOTPException;
import org.uplift.bank.TransferType;
import org.uplift.user.User;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransectionManagerTest {

    @Mock
    private Saving sourceAccount;

    @Mock
    private Account targetAccount;

    @Mock
    private AccountManager accountManager;

    @Mock
    private OTPManager otpManager;

    @InjectMocks
    private TransectionManager transectionManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(accountManager.findByAccountNumber(anyString())).thenReturn(sourceAccount);
        when(accountManager.findByMobileNumber(anyString())).thenReturn(targetAccount);


        transectionManager = new TransectionManager(new Random(), accountManager, otpManager);
    }

    @Test
    void testTransfer() throws InsuffucentBalanceException {
        when(sourceAccount.getAccountNumber()).thenReturn("SourceAccount");
        when(targetAccount.getAccountNumber()).thenReturn("TargetAccount");

        double amount = 1000.0;
        Transection t = transectionManager.transfer(sourceAccount, targetAccount, amount);

        assertNotNull(t.getId());
        verify(sourceAccount, times(1)).withdraw(amount);
        verify(targetAccount, times(1)).deposit(amount);
        assertEquals(t, transectionManager.findByTransectionId(t.getId()));
    }

    @Test
    void makePayment_ValidOTP_SuccessfulTransaction() throws InsuffucentBalanceException, OTPExpiredException, InvalidOTPException{
        when(otpManager.validOTP()).thenReturn(true);

        Transection transection = transectionManager.makePayment(
                "SourceAccountId", TransferType.ACCOUNT_ID, "MobileNumber", TransferType.MOBILE, 2000);

        assertNotNull(transection.getId());
        verify(otpManager, times(1)).validOTP();
    }

    @Test
    void makePayment_InvalidOTP_ThrowsInvalidOTPException() throws InsuffucentBalanceException, OTPExpiredException {
        when(otpManager.validOTP()).thenReturn(false);

        assertThrows(InvalidOTPException.class, () ->
                transectionManager.makePayment("SourceAccountId", TransferType.ACCOUNT_ID, "MobileNumber",
                        TransferType.MOBILE, 2000));

        verify(otpManager, times(1)).validOTP();
    }
}

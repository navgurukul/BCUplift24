package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.exception.InsufficientAccountBalanceException;
import org.uplift.exception.InvalidOtpException;
import org.uplift.exception.OtpExpiredException;

import java.util.Scanner;

import static org.mockito.Mockito.*;

class RetailBankingProviderTest {

    public static final String USER_NAME = "abcdef";
    private static final String SOURCE_ACC_ID = "A12234";
    @Mock
    private TransactionManager tm;

    @Mock
    private Scanner scanner;
    @InjectMocks
    private RetailBankingProvider rbp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void makePayment() throws InvalidOtpException, InsufficientAccountBalanceException, OtpExpiredException {
        rbp.makePayment(SOURCE_ACC_ID, TransferType.ACCOUNT_ID, USER_NAME,
                TransferType.USERNAME, 3435);
        verify(tm, times(1)).makePayment(SOURCE_ACC_ID, TransferType.ACCOUNT_ID, USER_NAME,
                TransferType.USERNAME, 3435);
    }

    @Test
    void makePaymentHandlesOtpExpirations() throws Exception {
        when(tm.makePayment(SOURCE_ACC_ID, TransferType.ACCOUNT_ID, USER_NAME,
                TransferType.USERNAME, 3435)).thenThrow(OtpExpiredException.class);

        when(scanner.next()).thenReturn(Attempt.YES.toString());
        rbp.makePayment(SOURCE_ACC_ID, TransferType.ACCOUNT_ID, USER_NAME,
                TransferType.USERNAME, 3435);
        verify(tm, atLeast(2)).makePayment(SOURCE_ACC_ID, TransferType.ACCOUNT_ID, USER_NAME,
                TransferType.USERNAME, 3435);
    }

}
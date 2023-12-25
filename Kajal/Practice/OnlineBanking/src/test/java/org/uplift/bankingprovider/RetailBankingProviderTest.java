package org.uplift.bankingprovider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.exception.OtpExpiredException;

import java.util.Scanner;

import static org.mockito.Mockito.*;

class RetailBankingProviderTest {
    private static final String USER_NAME = "a12345";
    public static final String SOURCE_ACC_ID = "A12345";
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
    void makingPayment() throws Exception {
        rbp.makePayment(SOURCE_ACC_ID, TransferType.ACCOUNT_ID, USER_NAME, TransferType.USERNAME,
                3435);
        verify(tm, times(1)).makePayment(SOURCE_ACC_ID, TransferType.ACCOUNT_ID,
                USER_NAME, TransferType.USERNAME, 3435);
    }

    @Test
    void makePaymentHandlesOtpException()throws Exception{
        when(tm.makePayment(SOURCE_ACC_ID, TransferType.ACCOUNT_ID, USER_NAME,
                TransferType.USERNAME, 3435)).thenThrow(OtpExpiredException.class);

        when(scanner.next()).thenReturn(Attempt.YES.toString());
        rbp.makePayment(SOURCE_ACC_ID, TransferType.ACCOUNT_ID, USER_NAME, TransferType.USERNAME,
                3435);
        verify(tm, atLeast(2)).makePayment(SOURCE_ACC_ID, TransferType.ACCOUNT_ID,
                USER_NAME, TransferType.USERNAME, 3435);
    }

}
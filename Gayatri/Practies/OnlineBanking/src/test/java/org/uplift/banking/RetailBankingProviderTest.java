package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.uplift.exception.OTPExpiredException;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RetailBankingProviderTest {


    private static final String SOURCE_ACC_ID = "A1234";
    private static final String USERNAME = "abcd";
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
    void makePayment() throws Exception {
        rbp.makePayment(SOURCE_ACC_ID,TransferType.ACCOUNT_ID, USERNAME,TransferType.USERNAME,34365);
        verify(tm,times(1)).makePayment("A1234",TransferType.ACCOUNT_ID,USERNAME,TransferType.USERNAME,34365);

    }


    @Test
    void makePaymentHandledOtpException() throws Exception {
        when(scanner.next()).thenReturn(Attempt.YES.toString());
        when(tm.makePayment(SOURCE_ACC_ID,TransferType.ACCOUNT_ID, USERNAME,TransferType.USERNAME,34365)).thenThrow(OTPExpiredException.class);
        rbp.makePayment(SOURCE_ACC_ID,TransferType.ACCOUNT_ID, USERNAME,TransferType.USERNAME,34365);
        verify(tm,atLeast(2)).makePayment(SOURCE_ACC_ID,TransferType.ACCOUNT_ID, USERNAME,TransferType.USERNAME,34365);

    }
}
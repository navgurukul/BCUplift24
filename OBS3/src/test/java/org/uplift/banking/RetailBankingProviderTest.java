package org.uplift.banking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.exceptions.OtpExpiredException;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RetailBankingProviderTest {

    private static final String SOURCE_ACC_ID ="a12334";
    private static final String MOBILE ="8899012334";

    private static final String USERNAME ="alka";

    @Mock
    private TransactionManager tm;


    @InjectMocks
    private RetailBankingProvider rbp;

    @Mock
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void makePayment() throws Exception{
        rbp.makePayment(SOURCE_ACC_ID,
                TransferType.ACCOUNT_ID,USERNAME, TransferType.USERNAME,1387.0);
        verify(tm, times(1)).makePayment(SOURCE_ACC_ID,
                TransferType.ACCOUNT_ID,USERNAME, TransferType.USERNAME,1387.0);
    }

    @Test
    void makePaymentHandlesOtpExpiration() throws Exception{
        when(tm.makePayment(SOURCE_ACC_ID,
                TransferType.ACCOUNT_ID,USERNAME,
                TransferType.USERNAME,1387.0)).thenThrow(OtpExpiredException.class);
        when(scanner.next()).thenReturn(String.valueOf(Attempt.YES));
        rbp.makePayment(SOURCE_ACC_ID,
                TransferType.ACCOUNT_ID,USERNAME, TransferType.USERNAME,1387.0);
        verify(tm,atLeast(2)).makePayment(SOURCE_ACC_ID,
                TransferType.ACCOUNT_ID,USERNAME, TransferType.USERNAME,1387.0);
    }




}

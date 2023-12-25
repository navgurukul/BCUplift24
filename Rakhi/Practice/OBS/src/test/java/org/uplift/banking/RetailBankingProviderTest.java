package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.exception.OtpExpiredException;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RetailBankingProviderTest {

    private static final String Source_ACCOUNT_NUMBER = "A123";
    private static final String USER_NAME = "B123";
    @Mock
    TransactionManager tm;

    @Mock
    Scanner scanner;

    @InjectMocks
    RetailBankingProvider rbp;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void makePayment()throws Exception{
        rbp.makePayment(Source_ACCOUNT_NUMBER,TransferType.ACCOUNT_ID,
                USER_NAME,TransferType.USERNAME,1000);
        verify(tm,times(1))
                .makePayment(Source_ACCOUNT_NUMBER,TransferType.ACCOUNT_ID,USER_NAME
                        ,TransferType.USERNAME,1000);
    }

    @Test
    void makePaymentHandlesOtpExpiration()throws Exception{
        when(tm.makePayment(Source_ACCOUNT_NUMBER,TransferType.ACCOUNT_ID,
                USER_NAME,TransferType.USERNAME,1000))
                .thenThrow(OtpExpiredException.class);
        when(scanner.next()).thenReturn(Attempt.YES.toString());
        rbp.makePayment(Source_ACCOUNT_NUMBER,TransferType.ACCOUNT_ID,
                USER_NAME,TransferType.USERNAME,1000);
        verify(tm,atLeast(2)).makePayment(Source_ACCOUNT_NUMBER,TransferType.ACCOUNT_ID,
                USER_NAME,TransferType.USERNAME,1000);
    }
}
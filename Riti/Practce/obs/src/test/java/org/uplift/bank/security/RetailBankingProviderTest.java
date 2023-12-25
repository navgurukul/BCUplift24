package org.uplift.bank.security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.bank.Attepmt;
import org.uplift.bank.OTPExpiredException;
import org.uplift.bank.TransectionManager;
import org.uplift.bank.TransferType;
import org.uplift.exceptions.InsuffucentBalanceException;
import org.uplift.exceptions.InvalidOTPException;

import java.util.Scanner;

import static org.mockito.Mockito.*;

class RetailBankingProviderTest {
    @Mock
    private Scanner scanner;
    private static final String SOURCE_ACCOUNT_NUMBER = "A1234";
    private static final String USER_NAME = "X1234";
    @Mock
    private TransectionManager transectionManager;
    @InjectMocks
    private RetailBankingProvider retailBankingProvider;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void makePayment() throws InsuffucentBalanceException, InvalidOTPException, OTPExpiredException {
        retailBankingProvider.makePayment(SOURCE_ACCOUNT_NUMBER, TransferType.ACCOUNT_ID, USER_NAME,TransferType.USERNAME,2000);
        verify(transectionManager,times(1)).makePayment(SOURCE_ACCOUNT_NUMBER, TransferType.ACCOUNT_ID,USER_NAME,TransferType.USERNAME,2000);
    }

    @Test
    void makePaymentHandlesOTPException()throws Exception{
        when(transectionManager.makePayment(SOURCE_ACCOUNT_NUMBER, TransferType.ACCOUNT_ID, USER_NAME,TransferType.USERNAME,2000)).thenThrow(OTPExpiredException.class);
        when(scanner.next()).thenReturn(Attepmt.YES.toString());
        retailBankingProvider.makePayment(SOURCE_ACCOUNT_NUMBER, TransferType.ACCOUNT_ID, USER_NAME,TransferType.USERNAME,2000);
        verify(transectionManager,atLeast(2)).makePayment(SOURCE_ACCOUNT_NUMBER, TransferType.ACCOUNT_ID, USER_NAME,TransferType.USERNAME,2000);
        //static type chaking


    }
}
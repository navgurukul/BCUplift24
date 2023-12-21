package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.exception.OtpExpiredException;
import org.uplift.exception.OtpMismatchedException;
import org.uplift.security.OtpManager;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RetailBankingProviderTest {
    private static final String SOURCE_ID = "A1234";
    private static final String TARGET_ID = "9876567";
    private static final int AMOUNT = 1000;
    @Mock
    private TransactionManager transactionManager;
    @Mock
    private Scanner scanner;
    @Mock
    private OtpManager otpManager;
    @InjectMocks
    private RetailBankingProvider retailBankingProvider;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void makePayment() throws Exception {
        retailBankingProvider.makePayment(SOURCE_ID,TransferType.ACCOUNTNUMBER, TARGET_ID,TransferType.MOBILE, AMOUNT);
        verify(transactionManager,times(1)).makePayment(SOURCE_ID,TransferType.ACCOUNTNUMBER, TARGET_ID,TransferType.MOBILE, AMOUNT);

    }
    @Test
    void makePaymentHandlingOtpExpiredException() throws Exception{
        when(scanner.next()).thenReturn(Choice.Yes.toString());
        when(transactionManager.makePayment(SOURCE_ID,TransferType.ACCOUNTNUMBER,TARGET_ID,TransferType.MOBILE,AMOUNT)).thenThrow(OtpExpiredException.class);
        retailBankingProvider.makePayment(SOURCE_ID,TransferType.ACCOUNTNUMBER, TARGET_ID,TransferType.MOBILE, AMOUNT);
        verify(transactionManager,atLeast(2)).makePayment(SOURCE_ID,TransferType.ACCOUNTNUMBER, TARGET_ID,TransferType.MOBILE, AMOUNT);

    }
    @Test
    void makePaymentHandlingOtpMismatchedException() throws Exception{
        when(otpManager.validateOtp()).thenReturn(false);
        when(transactionManager.makePayment(SOURCE_ID,TransferType.ACCOUNTNUMBER,TARGET_ID,TransferType.MOBILE,AMOUNT)).thenThrow(OtpMismatchedException.class);
        retailBankingProvider.makePayment(SOURCE_ID,TransferType.ACCOUNTNUMBER, TARGET_ID,TransferType.MOBILE, AMOUNT);
        verify(transactionManager,times(1)).makePayment(SOURCE_ID,TransferType.ACCOUNTNUMBER, TARGET_ID,TransferType.MOBILE, AMOUNT);
    }
}
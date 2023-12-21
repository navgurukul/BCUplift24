package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.uplifte.exceptionhandling.InsufficientBalanceException;
import org.uplift.uplifte.exceptionhandling.InvalidOtpException;
import org.uplift.uplifte.exceptionhandling.OtpExpiredException;


import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RetailBankingproviderTest {
    @Mock
    private Scanner scanner;
    public static final String SOURCEACCOUNTID = "A123";
    public static final String TARGETID = "abcde";
    @Mock
    private TransactionManager transactionManager;
    @InjectMocks
    private RetailBankingprovider retailBankingprovider;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testMakePayment() throws InsufficientBalanceException, InvalidOtpException, OtpExpiredException {
        retailBankingprovider.makePayment(SOURCEACCOUNTID,TransferType.ACCOUNTID, TARGETID,TransferType.USERNAME,1435.50);
        verify(transactionManager,times(1)).makePayment(SOURCEACCOUNTID,TransferType.ACCOUNTID,TARGETID,TransferType.USERNAME,1435.50);

    }
    @Test
    void makePaymentHandleOtpExpriration() throws Exception{
        when(transactionManager.makePayment("A123",TransferType.ACCOUNTID,"+91 - 987655",TransferType.MOBILE, 1415.5)).thenThrow(OtpExpiredException.class);
        when(scanner.next()).thenReturn(AttemptChoice.YES.toString());
        retailBankingprovider.makePayment("A123",TransferType.ACCOUNTID,"+91 - 987655",TransferType.MOBILE, 1415.5);
        verify(transactionManager,atLeast(2)).makePayment("A123",TransferType.ACCOUNTID,"+91 - 987655",TransferType.MOBILE, 1415.5);
    }

}
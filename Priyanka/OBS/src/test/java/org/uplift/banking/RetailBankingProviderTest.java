package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.exception.InsufficientBalanceException;
import org.uplift.account.exception.InvalidOtpException;
import org.uplift.banking.security.TransactionManager;


import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RetailBankingProviderTest {
    @Mock
    private TransactionManager tm;
    @Mock
    private Scanner scanner;

    @InjectMocks
    private RetailBankingProvider rbo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void makePayment() throws InsufficientBalanceException, InvalidOtpException, OtpExpiredException {
        rbo.makePayment("123AC",TransferType.account,"abcdf",TransferType.username,1200.0);
        verify(tm,times(1)).makePayment("123AC",TransferType.account,"abcdf",TransferType.username,1200.0);
    }
    @Test
    void makePaymentHandleOtpException() throws InsufficientBalanceException, InvalidOtpException, OtpExpiredException {
        when(tm.makePayment("123AC",TransferType.account,"abcdf",TransferType.username,1200.0)).thenThrow(OtpExpiredException.class);
        when(scanner.next()).thenReturn(Choice.YES.toString());
        rbo.makePayment("123AC",TransferType.account,"abcdf",TransferType.username,1200.0);
        verify(tm,atLeast(2)).makePayment("123AC",TransferType.account,"abcdf",TransferType.username,1200.0);

    }
}
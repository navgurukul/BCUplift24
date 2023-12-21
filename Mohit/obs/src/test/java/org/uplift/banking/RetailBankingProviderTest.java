package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.exception.InSufficientBalanceException;
import org.uplift.security.OtpExpireException;


import java.util.Scanner;

import static org.mockito.Mockito.*;

class RetailBankingProviderTest {
    @Mock
    private TransactionManager tm;
    @Mock
    private Scanner scanner;
    @InjectMocks
    private RetailBankingProvider rbp;
    private static final String USERNAME="abc";
    private static final String SOURCEACCOUNT_ID="as123";


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void makepayment() throws InSufficientBalanceException, InvalidOtpException, OtpExpireException {
        rbp.makePayment(SOURCEACCOUNT_ID,Transfertype.ACCOUNT,USERNAME,Transfertype.USERNAME,1000);
        verify(tm,times(1)).makePayment(SOURCEACCOUNT_ID,Transfertype.ACCOUNT,USERNAME,Transfertype.USERNAME,1000);


    }
    @Test
    void makePaymentHandleOtpException() throws InSufficientBalanceException, InvalidOtpException, OtpExpireException {
        when(scanner.next()).thenReturn(Attempt.YES.toString());
        when(tm.makePayment(SOURCEACCOUNT_ID,Transfertype.ACCOUNT,USERNAME,Transfertype.USERNAME,1000)).thenThrow(OtpExpireException.class);
        rbp.makePayment(SOURCEACCOUNT_ID,Transfertype.ACCOUNT,USERNAME,Transfertype.USERNAME,1000);
        verify(tm,atLeast(2)).makePayment(SOURCEACCOUNT_ID,Transfertype.ACCOUNT,USERNAME,Transfertype.USERNAME,1000);

    }
}
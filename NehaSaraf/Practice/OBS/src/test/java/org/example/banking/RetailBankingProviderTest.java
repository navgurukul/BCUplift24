package org.example.banking;

import org.example.exception.InsufficientBalanceException;
import org.example.exception.InvalidOtpException;
import org.example.exception.OTPExpiredException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class RetailBankingProviderTest {
    public static final String SOURCE_ID = "A123";
    public static final String USERNAME = "abcdef";
    @Mock
    private TransactionManager transactionManager;
    @InjectMocks
    private RetailBankingProvider retailBankingProvider;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMakePayment() throws OTPExpiredException, InsufficientBalanceException, InvalidOtpException {
        retailBankingProvider.makePayment(SOURCE_ID,TransferType.ACCOUNT_NUMBER,
                USERNAME,TransferType.USER_NAME,3456);
        verify(transactionManager,times(1)).makePayment(SOURCE_ID,TransferType.ACCOUNT_NUMBER,
                USERNAME,TransferType.USER_NAME,3456);

    }
    @Test
    void testMakePaymentHandlesOtpException()throws Exception{
        when(transactionManager.makePayment(SOURCE_ID,TransferType.ACCOUNT_NUMBER,
                USERNAME,TransferType.USER_NAME,3456)).thenThrow(OTPExpiredException.class);
    }
}
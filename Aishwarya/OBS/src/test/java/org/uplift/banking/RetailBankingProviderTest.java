package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.InsufficientBalanceException;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class RetailBankingProviderTest {

    private static final String SOURCE_ACCOUNT_NUMBER = "A12234";
    private static final String TARGET_ID = "abcdef";
    @Mock
    private TransactionManager tm;
    @Mock
    private RetailBankingProvider rbp;


    @InjectMocks
    private RetailBankingProvider retailBankingProvider;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks( this );

    }

    @Test
    void makePayment() throws Exception, InsufficientBalanceException, InvalidOtpException {
        rbp.makePayment( SOURCE_ACCOUNT_NUMBER, TransferType.ACCOUNT_ID, TARGET_ID, TransferType.USERNAME, 14523.2  );
        verify( tm, times(1)).makePayment( SOURCE_ACCOUNT_NUMBER, TransferType.ACCOUNT_ID, TARGET_ID, TransferType.USERNAME, 14523.2 );
    }


}
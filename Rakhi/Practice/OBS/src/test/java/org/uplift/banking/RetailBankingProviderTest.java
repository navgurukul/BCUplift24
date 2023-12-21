package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class RetailBankingProviderTest {

    private static final String Source_ACCOUNT_NUMBER = "A123";
    private static final String USER_NAME = "B123";
    @Mock
    TransactionManager tm;

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
}
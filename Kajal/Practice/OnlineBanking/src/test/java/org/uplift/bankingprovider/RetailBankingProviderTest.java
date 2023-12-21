package org.uplift.bankingprovider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.exception.InvailidOfpException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class RetailBankingProviderTest {
    private static final String A_12345 = "a12345";
    public static final String SOURCE_ACC_ID = A_12345;
    @Mock
    private TransactionManager tm;

    @InjectMocks
    private RetailBankingProvider rbp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void makingPayment() throws Exception {
        rbp.makePayment(SOURCE_ACC_ID, TransferType.ACCOUNT_ID, "abcdef", TransferType.USERNAME, 3435);
        verify(tm, times(1)).makePayment(A_12345, TransferType.ACCOUNT_ID, "abcdef", TransferType.USERNAME, 3435);
    }
}
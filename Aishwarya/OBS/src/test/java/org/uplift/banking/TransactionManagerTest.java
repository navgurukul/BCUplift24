package org.uplift.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.*;
import org.uplift.banking.security.OTPManager;
import org.uplift.banking.security.OtpExpiredException;
import org.uplift.user.User;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionManagerTest {
    @Mock
    private Account sa;
    @Mock
    private Account ta;
    private User sourceUser;
    private User targetUser;
    @Mock
    private OTPManager otpManager;

    @Mock
    private AccountManager accountManager;

    @Mock
    private Random random;
    private static final int RANDOM_NUMBER = 10000001;
    private static final String MOBILE = "998877899";
    private static final String ACCOUNT_NUMBER = "123Ac";


    @InjectMocks
    private TransactionManager tm;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks( this );

        when( random.nextInt( 1000000, 1000000000 ) ).thenReturn( RANDOM_NUMBER );


    }


    @Test
    void transfer() throws InsufficientBalanceException {

        InOrder io = inOrder( sa, ta );
        Transaction t = tm.transfer( sa, ta, 1000 );
        assertEquals( "" + RANDOM_NUMBER, t.getId( ) );

        verify( sa, times( 1 ) ).withdraw( 1000 );
        verify( ta, times( 1 ) ).deposit( 1000 );


        io.verify( sa ).withdraw( 1000 );
        io.verify( ta ).deposit( 1000 );

        assertEquals( t, tm.findByTransactionId( "" + RANDOM_NUMBER ) );

    }


    @Test
    void makePayment() throws InsufficientBalanceException, OtpExpiredException, InvalidOtpException {

        when( accountManager.findByAccountNumber( ACCOUNT_NUMBER ) ).thenReturn( sa );
        when( accountManager.findByMobileNumber( MOBILE ) ).thenReturn( ta );
        when(otpManager.validateOtp()).thenReturn( true );

        assertEquals( "" + RANDOM_NUMBER, tm.makePayment( ACCOUNT_NUMBER, TransferType.ACCOUNT_ID, MOBILE, TransferType.MOBILE, 1200.0 ).getId( ) );
        verify(otpManager, times(1) ).validateOtp();

    }


    @Test
    void makePaymentThrowsInvalidException() throws OtpExpiredException, InsufficientBalanceException, InvalidOtpException {

        when(otpManager.validateOtp()).thenReturn( false );
        assertThrows(InvalidOtpException.class, () -> tm.makePayment(ACCOUNT_NUMBER, TransferType.ACCOUNT_ID, "12563", TransferType.MOBILE, 1450.5 ));

    }
}
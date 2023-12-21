package org.uplift.account.Bank;

import org.junit.jupiter.api.*;
import org.mockito.*;
import org.uplift.account.*;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.user.User;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionManagerTest {

    private Account source;
    private Account target;
    private User sourceUser;
    private User targetUser;
    @Mock
    private Random random;
    @Mock
    private AccountManager accountManager;
    @InjectMocks
    private TransactionManager tm;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sourceUser = new User("Jyoti","67543223456567","jyoti@gmaol.com","Jyoti12","Jyoti@123");
        targetUser = new User("Priti","786543479","priti@gmail.com","priti122","Priti@123");
        source = new SavingAccount("SA9877654335","Jyoti",100000,new Date(),sourceUser,10000);
        target = new SavingAccount("SA9877654335","Priti",100,new Date(),targetUser,1000);
    }
    @Test
    void transfer() throws InsufficientBalanceException {
        int randomNumer =10000001;
        when(random.nextInt(1000000,100000000)).thenReturn(randomNumer);
        Account sa = mock(SavingAccount.class);
        Account ta = mock(SavingAccount.class);
        InOrder io = inOrder(sa,ta);
        Transaction t = tm.transfer(sa,ta,1000);
        assertEquals(""+randomNumer,t.getTransactionId());
        verify(sa,times(1)).withdraw(1000);
        verify(ta,times(1)).deposit(1000);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);
        assertEquals(t, tm.findByTransactionId(""+randomNumer));
    }
    @Test
    void testMakePayment() throws InsufficientBalanceException {
        int randomNumber = 10000001;
        Account sa = mock(SavingAccount.class);
        Account ta = mock(SavingAccount.class);
        when(random.nextInt(1000000,100000000)).thenReturn(randomNumber);
        when(accountManager.findByAccountNumber("A123")).thenReturn(sa);
        when(accountManager.findByUserMobileNo("+91 - 987655")).thenReturn(ta);
        assertEquals(""+randomNumber,tm.makePayment("A123",TransferType.ACCOUNTID,"+91 - 987655",TransferType.MOBILE, 1415.5).getTransactionId());

    }

}
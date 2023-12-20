package org.uplift.account.Bank;

import org.junit.jupiter.api.*;
import org.mockito.*;
import org.uplift.account.*;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.user.User;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class TransactionMangerTest {
    private Account source;
    private Account target;
    private User sourceUser;
    private User targetUser;
    @Mock
    private Account account;
    @Mock
    private  Random random;
    @InjectMocks
    private TransactionManger tm;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        sourceUser = new User("Jyoti", "12345667880", "jyoti@gmail.com", "jyoti03", "jyoti123");
        targetUser = new User("Bharati", "0987654321", "bharati@gmail.com", "bharati09", "bharato123");
        source = new SavingAccount("1234321", "jyoti", 12309.00, new Date(), sourceUser, 100);
        target = new SavingAccount("0987667890","bharati", 34567, new Date(),targetUser, 1000);
    }
    @Test
    void transfar() throws InsufficientBalanceException {
        int randomNumber = 12000;
        when(random.nextInt(10000, 1000)).thenReturn(randomNumber);
        String txnId = "" + Objects.hash(source, target, new Date());
        Transaction ET = new Transaction(source, target, new Date(), 1000, "tr1");
        assertEquals(ET, TransactionManger.transfar(source,target, 1000));
        Account sa = mock(SavingAccount.class);
        Account ta = mock(SavingAccount.class);
        InOrder io = inOrder(sa, ta);
        Transaction t = tm.transfar(sa,ta,1000);
        assertEquals("" + randomNumber,t.getTransactionId());
        verify(sa, times(1)).withdraw(1000);
        verify(ta, times(1)).deposit(1000);
        io.verify(sa).withdraw(1000);
        io.verify(ta).deposit(1000);
        assertEquals(t, tm.findByTransactionId("" + randomNumber));
    }
}

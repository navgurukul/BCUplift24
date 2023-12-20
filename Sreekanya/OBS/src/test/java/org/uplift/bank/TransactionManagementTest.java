package org.uplift.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uplift.account.Account;
import org.uplift.account.SavingAccount;
import org.uplift.account.Transaction;
import org.uplift.exception.InvalidSufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class TransactionManagementTest {

    private Account source;
    private Account target;
    private User sourceuser;
    private User targetuser;

    //private User transactionManager;

    @BeforeEach
    void setUp() {
        sourceuser=new User("user1","54765923","email.com","username1","121");
        targetuser=new User("user2","5379792","van@gmail.com","username2","132");
        source=new SavingAccount(sourceuser,"1544994",5000,new Date(),500.0);
        target=new SavingAccount(targetuser,"127057",5000,new Date(),500.0);

    }
    @Test
     void testTransfer() throws InvalidSufficientBalanceException {
        Date date=new Date();
        String transactionId=""+ Objects.hash(source,target,new Date());
        Transaction expectedTransaction=new Transaction(source,target,new Date(),1000,"123");
        assertEquals(expectedTransaction,TransactionManagement.transfer(source,target,1000));

    }
}
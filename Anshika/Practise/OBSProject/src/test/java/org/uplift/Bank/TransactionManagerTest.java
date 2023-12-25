package org.uplift.Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.uplift.account.Account;
import org.uplift.account.SavingsAccount;
import org.uplift.account.Transaction;
import org.uplift.user.User;

import java.util.Date;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class TransactionManagerTest {

    private Account source;
    private Account target;
    private User soureuser;
    @Mock
    private Random random;
    public void setRandom(Random random){
        this.random=random;
    }

    @InjectMocks
    private TransactionManager tm;

    void Transfer(){
        int randomNumber=10000001;
        when(randomNumber)
    }



    @BeforeEach
    void setUp(){
        sourceUser =new SavingsAccount("alka noor","123",1267,new Date(),1000);

    }
    @Test
    void Transfer(){
        Transaction expectedTransaction=new Transaction(source,target,new Date(),1000,"123")
        assertEquals(TransactionManager.transfer(source,target,1000));



    }

}
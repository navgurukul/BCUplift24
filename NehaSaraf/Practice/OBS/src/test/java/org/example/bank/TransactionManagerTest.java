package org.example.bank;

import org.example.account.Account;
import org.example.account.InsufficientBalanceException;
import org.example.account.SavingAccount;
import org.example.account.Transaction;
import org.example.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TransactionManagerTest {

    private Account source;
    private Account target;
    private User sourceUser;
    private User tragetUser;
    @Mock
    private Random random;
    @InjectMocks
    private TransactionManager tm;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sourceUser=new User("Neha Saraf","9999999999","nehasaraf@gmail.com","nehasaraf","12345");
        tragetUser=new User("Janhvi Shende","88888888","janvhishende@gmail.com","janvhishende","54321");
        source=new SavingAccount(sourceUser,"12345678",200000,new Date(),1000);
        target=new SavingAccount(tragetUser,"23456789",50000,new Date(),20000);


    }
    @Test
    void transfer() throws InsufficientBalanceException {
        int randomNumber=10000001;
        when(random.nextInt(1000000,100000000)).thenReturn(randomNumber);
        Date date=new Date();
        String txnId=""+Objects.hash(source,target,new Date());
        Transaction expectedTransaction=new Transaction(source,target,new Date(),100,"123");
        assertEquals(""+randomNumber,tm.transfer(source,target,1000).getId());
    }
}
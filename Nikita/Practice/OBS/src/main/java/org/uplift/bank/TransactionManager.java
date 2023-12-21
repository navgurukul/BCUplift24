package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientBalanceException;

import java.util.*;

public class TransactionManager {
    private Random random;
    private Set<Transaction> transactionHistory=new HashSet<>();


    public TransactionManager(Random random) {
        this.random = random;
//        this.transactionHistory = transactionHistory;
    }

    public  Transaction transfer( Account source, Account target, double amount) throws InsufficientBalanceException {
        source.withdraw(amount);
        target.deposit(amount);
        String txcId= String.valueOf(random.nextInt(1000000,1000000000));
        Transaction t= new Transaction(source,target, new Date(),txcId);
        transactionHistory.add(t);
        return t;

    }
    public Transaction findByTransactionId(String txnId) {
        for(Transaction t:transactionHistory){
            if(t.getId().equals(txnId)) return t;
        }
        return null;
    }
}

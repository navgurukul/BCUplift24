package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientBalanceException;

import java.util.*;

public class TransactionManager {
    private Random random;
    private Set<Transaction> transactionHistory=new HashSet<>();

    public void setRandom(Random random) {
        this.random = random;
    }

    public Transaction transfer(Account source, Account target, double amount) throws InsufficientBalanceException {
         source.withdraw(amount);
         target.deposit(amount);
        String txnId = String.valueOf(random.nextInt(1000000,1000000000));
         Transaction t = new Transaction(source,target,new Date(),amount,txnId);
         transactionHistory.add(t);
         return t;

    }

    public Transaction findByTransactionId(String txnId) {
        for(Transaction t :transactionHistory){
            if(t.getId().equals(txnId)) return t;
        }
        return null;
    }
}

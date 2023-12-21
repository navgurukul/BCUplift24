package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientBalanceException;

import java.security.SecureRandom;
import java.util.*;

public class TransactionManager {
    private Random random;
    private Set<Transaction> transactionHistrory = new HashSet<>();
    public void setRandom(Random random){
        this.random = random;
    }

    public Transaction transfer(Account source, Account target, double amount) throws InsufficientBalanceException {

        source.withdraw(amount);
        target.deposit(amount);
       String txnd = ""+ random.nextInt(1000000,1000000000);
       Transaction t = new Transaction(source,target,new Date(),1000,txnd);
       transactionHistrory.add(t);
       return t;
    }
    public Transaction findByTransactionId(String txnd){
        for(Transaction t : transactionHistrory){
            if(t.getTransactionId().equals(txnd)) return t;
        }
        return null;
    }

}

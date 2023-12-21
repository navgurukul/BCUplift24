package com.uplift.bank;

import com.uplift.account.Account;
import com.uplift.account.Transaction;
import com.uplift.exceptions.InsufficietBalanceException;

import java.util.*;

public class TransactionManager {

    private Random random;

    private Set<Transaction> transactionHistory=new HashSet<>();
    public void setRandom(Random random) {
        this.random = random;
    }

     public  Transaction transfer(Account source, Account target, double amount) throws InsufficietBalanceException {
         source.withdraw(amount);
         target.deposit(amount);
         String txnId = "" + random.nextInt(1000000, 1000000000);
         Transaction t = new Transaction(source, target, new Date(), amount, txnId);
         transactionHistory.add(t);
         return t;
     }

     public Transaction findByTransactionId(String txnId){
        for(Transaction t : transactionHistory){
            if(t.getId().equals(txnId)){
                return t;
            }
        }
        return null;
     }
}

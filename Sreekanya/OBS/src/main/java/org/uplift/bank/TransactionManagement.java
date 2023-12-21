package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exception.InvalidSufficientBalanceException;

import java.util.*;

public class TransactionManagement {
    private Random random;
    private Set<Transaction> transactionSet=new HashSet<>();
    private void setRandom(){
        this.random=random;
    }
    public Transaction transfer(Account source, Account target, double amount) throws InvalidSufficientBalanceException {
        source.withDraw(amount);
        target.deposit(amount);
        String randomNumber=""+random.nextInt(1000000,1000000000);
        Transaction t=new Transaction(source,target,new Date(),amount,randomNumber);
        transactionSet.add(t);
        return t;

    }
    public Transaction findByTransactionId(String tranId){
        for(Transaction t:transactionSet){
            if(t.getTransactionId().equals(tranId)) return t;
        }
        return null;
    }
}

package org.uplift.account;

import java.util.*;

public class TransactionManager {
    private  String txnId;
    private Random random;
    private Set<Transaction> transactionHistory=new HashSet<>();

    public void setRandom(Random random) {
        this.random = random;
    }

    public  Transaction transfer(Account source, Account target, double amount) throws InsufficientBalanceException {
        source.withdraw(amount);
        target.deposit(amount);
       String txnId= String.valueOf(random.nextInt(1000000,1000000000));
        Transaction t= new Transaction(source,target,new Date(),1000.0,txnId);
        transactionHistory.add(t);
        return t;

    }

    public Transaction findByTransaction(String txnId) {
        for (Transaction t: transactionHistory){
            if(t.getId().equals(txnId))return t;

        }
        return null;
    }
}

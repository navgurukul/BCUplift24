package org.example.bank;

import org.example.account.Account;
import org.example.exception.InsufficientBalanceException;
import org.example.account.Transaction;

import java.util.*;

public class TransactionManager {
    private Random random;
    private Set<Transaction> transactionHistory;

    public TransactionManager() {
        this.transactionHistory = new HashSet<>();
    }

    public Transaction transfer(Account source, Account target, double amount) throws InsufficientBalanceException {
        source.withdraw(amount);
        target.deposit(amount);
        String txtId=""+random.nextInt(1000000,100000000);
        Transaction t=new Transaction(source,target,new Date(),amount,txtId);
        transactionHistory.add(t);
        return t;
    }

    public void setRandomNo(Random random) {
        this.random = random;

    }

    public Transaction findByTransactionId(String s) {
        for(Transaction t:transactionHistory){
            if(t.getId().equals(s))
                return t;

        }
        return null;
    }
}

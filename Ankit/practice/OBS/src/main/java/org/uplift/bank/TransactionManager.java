package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientBalanceException;

import java.util.*;

public class TransactionManager {
    private Random random ;
    private Set<Transaction> transactionHistory = new HashSet<>();

    public TransactionManager(Random random) {
        this.random = random;
    }

    public Transaction transfer(Account sourceAccount, Account targetAccount, double amount) throws InsufficientBalanceException {
        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);
        String transactionId = "" + random.nextInt(1000000,1000000000);
        Transaction transaction = new Transaction(sourceAccount,targetAccount,new Date(),amount, transactionId);
        transactionHistory.add(transaction);
        return transaction;
    }


    public Transaction findTransactionByTransactionId(String id){
        for(Transaction t: transactionHistory){
            if(t.getTransactionId().equals(id)){
                return t;
            }
        }
        return null ;
    }

}

package org.uplift.bankpackage;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.uplifte.exceptionhandling.InsufficientBalanceException;

import java.util.*;

public class TransactionManager {
    private Random random;
    private Set<Transaction> transactionSet= new HashSet<>();

    public void setRandom(){
        this.random = random;
        //this.transactionSet= new HashSet<>();
    }
    public  Transaction transfer(Account sourceAccount, Account targetaccount, double amount) throws InsufficientBalanceException {
        sourceAccount.withdraw(amount);
        targetaccount.deposit(amount);
        String txnId =""+ random.nextInt(1000000,100000000);
        Transaction t = new Transaction(sourceAccount,targetaccount,new Date(),amount,txnId);
        transactionSet.add(t);
        return  t;
    }
    public Transaction findByTransactionId(String txnId){
        for (Transaction t : transactionSet){
            if (t.getTransactionId().equals(txnId)) return t;
        }
        return null;
    }

}

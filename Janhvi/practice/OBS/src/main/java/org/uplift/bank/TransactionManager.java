package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exception.InSufficientBalanceException;
import org.uplift.exception.InvalidPinException;
import org.uplift.user.User;

import java.util.*;

public class TransactionManager {
    private Random random;
    private Set<Transaction> transactionHistory = new HashSet<>();

    public void setRandom(Random random){
        this.random = random;
    }
    public  Transaction transfer(Account source, Account target, double amount) throws InSufficientBalanceException {
        source.withdraw(amount);
        target.deposit(amount);
        String txnId = "" + random.nextInt(100000,100000000);
        Transaction t =  new Transaction(source,target,new Date(),amount,txnId);
        transactionHistory.add(t);
        return t;
    }

    public Transaction findByTransactionID(String txnId) {
        for(Transaction t :transactionHistory){
            if(t.getTransactionId().equals(txnId))return t;

        }
        return null;
    }



}

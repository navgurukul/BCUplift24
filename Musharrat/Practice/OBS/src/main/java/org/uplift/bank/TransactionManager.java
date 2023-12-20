package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientAccountBalanceException;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TransactionManager {
    private Random random;
    private Set<Transaction> transactionHistory = new HashSet<>();

    public Transaction transfer(Account source, Account target, double amount)
            throws InsufficientAccountBalanceException {

        source.withdraw(amount);
        target.deposit(amount);

        String txnId = ""+random.nextInt(100000, 1000000000);
        Transaction t=  new Transaction(source, target, new Date(), amount, txnId);
        transactionHistory.add(t);
        return t;
    }

    public void setRandom(Random random){
        this.random = random;
    }

    public Transaction findByTransactionId(String txnId) {

        for (Transaction t: transactionHistory){
            if (t.getId().equals(txnId)) return t;
        }
        return null;
    }
}

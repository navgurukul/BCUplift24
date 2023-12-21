package org.uplift.bank.security;

import org.uplift.account.Account;
import org.uplift.account.SavingAccount;
import org.uplift.account.Transaction;
import org.uplift.account.exception.InsufficientBalanceException;


import java.util.*;

public class TransactionManager {
    private Random random;
    private Set<Transaction> transactonHistory = new HashSet<>();
    public void setRandom(Random random) {
        this.random = random;
    }

    public Transaction transfer(Account source, Account target, double amount) throws InsufficientBalanceException {
        source.withdraw(amount);
        target.deposit(amount);
        String txnId = ""+random.nextInt(100000,100000000);
        Transaction t =  new Transaction(source,target,new Date(),amount,txnId);
        transactonHistory.add(t);
        return t;
    }

    public Transaction findByTransctionId(String txnId) {
        for (Transaction t : transactonHistory) {
            if (t.getId().equals(txnId)) return t;
        }
        return null;
    }
}

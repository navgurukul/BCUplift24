package org.Uplift.Bank;

import org.Uplift.account.Account;
import org.Uplift.account.Transaction;
import org.Uplift.exception.InsufficientBalanceException;

import java.util.*;

public class TransactionManager {

    private Random random;
    private Set<Transaction> transactions= new HashSet<>();
    public void setRandom(Random random){
        this.random = random;
    }
    public Transaction transfer(Account source, Account target, double amount) throws InsufficientBalanceException {
        source.withdraw(amount);
        target.deposit(amount);
        String txnId = "" + random.nextInt(1000000, 1000000000);
        Transaction t = new Transaction(source,target, new Date(), amount, txnId);
        transactions.add(t);
        return t;
    }
public Transaction findByTransactionId(String txnId){
        for (Transaction t : transactions){
            if (t.getId().equals(txnId)) return t;
        }
        return null;
}


}

package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.user.User;

import java.util.*;

public class TransactionManager {
    private Random random;
    private Set<Transaction> transactionHistory = new HashSet<>();

    public TransactionManager(Random random){
        this.random=random;
    }

    public  Transaction transfer(Account sourceAccount, Account targetAccount, double amount) throws InsufficientBalanceException {
      sourceAccount.withdraw(amount);
      targetAccount.deposit(amount);
      String transId= ""+ random.nextInt(1000000,10000000);
      Transaction t =  new Transaction(sourceAccount, targetAccount, new Date(),1000.0, transId);
      transactionHistory.add(t);
      return t;
    }

    public Transaction findByTransaction(String transId) {
        for(Transaction t: transactionHistory){
            if(t.getId().equals(transId)){
                return t;
            }
        }
        return null;
    }
}

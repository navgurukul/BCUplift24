package org.uplift.account.Bank;
import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientBalanceException;
import java.util.*;
public class TransactionManger {
    private static Random random;
    private static Set<Transaction> transactionSet= new HashSet<>();

    public void setRandom(){
        this.random = random;
        //this.transactionSet= new HashSet<>();
    }
    public static Transaction transfar(Account sourceAccount, Account targetaccount, double amount) throws InsufficientBalanceException {
        sourceAccount.withdraw(amount);
        targetaccount.deposit(amount);
        String txnId =""+ random.nextInt(10000,10000);
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


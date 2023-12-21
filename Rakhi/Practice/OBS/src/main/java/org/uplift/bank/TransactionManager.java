package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientBalanceException;
import java.util.*;

public class TransactionManager {
    private Random random;
    private AccountManager accountManager;
    private Set<Transaction> transactionHistory=new HashSet<>();

    public void setRandom(Random random) {
        this.random = random;
    }
    public Transaction transfer(Account source, Account target, double amount) throws InsufficientBalanceException {
       source.withdraw(amount);
       target.deposit(amount);
       String txnId=""+random.nextInt(100000,100000000);
       Transaction t=new Transaction(source,target,new Date(),amount,txnId);
       transactionHistory.add(t);
       return t;
    }

    public Transaction findByTransactionId(String txnId){
//        for(Transaction t:transactionHistory){
//            if(t.getId().equals(txnId)) return t;
//        }return null;
//
        return transactionHistory.stream().filter(transaction->transaction.getId().equals(txnId))
                .findFirst().orElse(null);
    }

    public Transaction makePayment(String source,TransferType sourceType,String target,TransferType targetType,double amount)
    throws InsufficientBalanceException{
        Account sourceAccount= findAccount(source, sourceType);
        Account targetAccount=findAccount(target,targetType);
        return transfer(sourceAccount,targetAccount,amount);
    }

    private Account findAccount(String source, TransferType sourceType) {
        Account account=null;
        switch(sourceType){
            case ACCOUNT_ID ->{
                account=accountManager.findByAccountNumber(source);
            }
            case MOBILE -> {
                account=accountManager.findByMobile(source);
            }
            case USERNAME -> {
                account=accountManager.findByUserName(source);
            }

        }return account;
    }
}


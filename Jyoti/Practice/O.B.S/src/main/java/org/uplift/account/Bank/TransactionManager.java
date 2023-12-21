package org.uplift.account.Bank;
import org.uplift.account.*;
import org.uplift.exception.InsufficientBalanceException;
import java.util.*;

public class TransactionManager {
    private Random random;
    private AccountManager accountManager;
    private Set<Transaction> transactionSet= new HashSet<>();

    public void setRandom(){
        this.random = random;
    }
    public void setAccountManager(){
        this.accountManager = accountManager;
    }
    public  Transaction transfer(Account sourceAccount, Account targetaccount, double amount) throws InsufficientBalanceException {
        sourceAccount.withdraw(amount);
        targetaccount.deposit(amount);
        String txnId =""+ random.nextInt(1000000,100000000);
        Transaction t = new Transaction(sourceAccount,targetaccount,new Date(),amount,txnId);
        transactionSet.add(t);
        return  t;
    }
    public Transaction findByTransactionId(String txnId) {
        return transactionSet.stream()
                .filter(t -> t.getTransactionId().equals(txnId))
                .findFirst()
                .orElse(null);
    }

    public Transaction makePayment(String source, TransferType sourceType, String target,TransferType targetType, double amount) throws InsufficientBalanceException {
        Account sourceAccount=findAccount(source, sourceType);
        Account targetAccount=findAccount(target, targetType);;
        return transfer(sourceAccount,targetAccount,amount);
    }

    private Account findAccount(String source, TransferType sourceType) {
        Account sourceAccount = null;
        switch(sourceType){
            case ACCOUNTID -> {
                sourceAccount = accountManager.findByAccountNumber(source);
                break;
            }
            case MOBILE -> {
                sourceAccount = accountManager.findByUserMobileNo(source);
                break;
            }
            case USERNAME -> {
                sourceAccount = accountManager.findByUserName(source);
            }
        }
        return sourceAccount;
    }

}


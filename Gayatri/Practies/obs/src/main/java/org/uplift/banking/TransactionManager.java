package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.exception.OtpExpiredException;
import org.uplift.security.OTPManager;

import java.util.*;

public class TransactionManager {
    private String txnId;
    private Random random;
    private OTPManager otpManager;
    private AccountManager accountManager;
    private Set<Transaction> transactionHistory = new HashSet<>();

    public void setRandom(Random random) {
        this.random = random;
    }

    public Transaction transfer(Account source, Account target, double amount) throws InsufficientBalanceException {
        source.withdraw(amount);
        target.deposit(amount);
        String txnId = String.valueOf(random.nextInt(1000000, 100000000));
        Transaction t = new Transaction(source, target, new Date(), 1000.0, txnId);
        transactionHistory.add(t);
        return t;

    }

    public Transaction findByTransaction(String txnId) {
        for (Transaction t : transactionHistory) {
            if (t.getId().equals(txnId)) return t;

        }
        return null;
    }
    //Transaction manager and test Implements stream

    public Transaction findByTransactionID(String txnId) {
        return transactionHistory.stream().filter(a->a.getTransactionId().equals(txnId)).findFirst().orElse(null);
    }


    public Transaction makePayment(String source, TransferType sourceType,String target, TransferType targetType, double amount) throws InsufficientBalanceException, OtpExpiredException {

        if(!otpManager.validateOtp()){
            throw new InsufficientBalanceException("balance is not sufficient");
        }
        Account sourceAccount= FindAccount(source, sourceType);
        Account targetAccount = FindAccount(target,targetType);
        return transfer(sourceAccount,targetAccount,amount);

    }


    private Account FindAccount(String source, TransferType sourceType) {
        Account account = null;
        switch(sourceType){
            case ACCOUNTID -> {account = accountManager.findByAccountNumber(source);}
            case MOBILE -> {account = accountManager.findMyMobile(source);}
            case USERNAME -> {account = accountManager.findMyUsername(source);}
        }
        return account;
    }

}
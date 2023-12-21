package org.uplift.banking;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.exception.OtpExpiredException;
import org.uplift.exception.OtpMismatchedException;
import org.uplift.security.OtpManager;

import java.util.*;

public class TransactionManager {
    private Random random ;
    private Set<Transaction> transactionHistory = new HashSet<>();
    private AccountManager accountManager ;
    private OtpManager otpManager ;

    public TransactionManager(Random random,AccountManager accountManager,OtpManager otpManager) {
        this.random = random;
        this.accountManager = accountManager ;
        this.otpManager = otpManager;
    }

    public Transaction transfer(Account sourceAccount, Account targetAccount, double amount) throws InsufficientBalanceException {
        sourceAccount.withdraw(amount);
        targetAccount.deposit(amount);
        String transactionId = "" + random.nextInt(1000000,1000000000);
        Transaction transaction = new Transaction(sourceAccount,targetAccount,new Date(),amount, transactionId);
        transactionHistory.add(transaction);
        return transaction;
    }

    public Transaction findTransactionByTransactionId(String id){

//        for(Transaction t: transactionHistory){
//            if(t.getTransactionId().equals(id)){
//                return t;
//            }
//        }
//        return null ;

        // another way of finding transaction in transaction set by stream.

        return transactionHistory.stream()
                .filter(transaction -> transaction.getTransactionId().equals(id))
                .findFirst().orElse(null);
    }


    public Transaction makePayment(String sourceId, TransferType sourceType, String targetId, TransferType targetType, double amount)
            throws InsufficientBalanceException, OtpExpiredException,OtpMismatchedException {
        Account sourceAccount = findAccount(sourceId,sourceType);
        Account targetAccount = findAccount(targetId, targetType);
        if(otpManager.validateOtp()) {
            return transfer(sourceAccount,targetAccount,amount);
        }
        else{
            throw new OtpMismatchedException("Sorry, otp does not matched.");
        }

    }

    private Account findAccount(String sourceId, TransferType sourceType) {
        Account account = null;
        switch (sourceType) {
            case ACCOUNTNUMBER -> {
                account = accountManager.findAccountByAccountNumber(sourceId);
            }
            case MOBILE -> {
                account = accountManager.findAccountByPhoneNumber(sourceId);
            }
            case USERNAME -> {
                account = accountManager.findAccountByUserName(sourceId);
            }
        }
        return account;
    }
}

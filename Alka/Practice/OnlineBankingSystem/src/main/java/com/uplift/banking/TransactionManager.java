package com.uplift.banking;

import com.uplift.account.Account;
import com.uplift.account.Transaction;
import com.uplift.banking.security.OtpManager;
import com.uplift.exceptions.InsufficietBalanceException;
import com.uplift.exceptions.InvalidOtpException;
import com.uplift.exceptions.OtpExpiredException;

import java.util.*;

public class TransactionManager {

    private Random random;
    private AccountManager accountManager;
    private OtpManager otpManager;

    private Set<Transaction> transactionHistory=new HashSet<>();
    public void setRandom(Random random) {
        this.random = random;
    }

     public  Transaction transfer(Account source, Account target, double amount) throws InsufficietBalanceException {
         source.withdraw(amount);
         target.deposit(amount);
         String txnId = "" + random.nextInt(1000000, 1000000000);
         Transaction t = new Transaction(source, target, new Date(), amount, txnId);
         transactionHistory.add(t);
         return t;
     }

     public Transaction findByTransactionId(String txnId){
        return transactionHistory.stream().filter((t)-> t.getId().
                equals(txnId)).findFirst().orElse(null);
     }

    public Transaction makePayment(String sourceId, TransferType sourceType, String target, TransferType targetType, double amount)
            throws InsufficietBalanceException, OtpExpiredException, InvalidOtpException {
        if(!otpManager.validiateOtp()){
            throw new InvalidOtpException("Otp entered is incorrect. Please enter correct OTP!");
        }
        Account sourceAccount = findAccount(sourceId,sourceType);
        Account targetAccount=findAccount(target,targetType);
        return transfer(sourceAccount,targetAccount,amount);
    }

    private Account findAccount(String sourceId, TransferType sourceType) {
        Account account = null;
        switch (sourceType){
            case ACCOUNT_ID -> {
                account = accountManager.findByAccountNumber(sourceId);
            }
            case MOBILE -> {
                account = accountManager.findByPhoneNumber(sourceId);
            }
            case USERNAME -> {
                 account = accountManager.findByUserName(sourceId);
            }
        }
        return  account;
    }


}

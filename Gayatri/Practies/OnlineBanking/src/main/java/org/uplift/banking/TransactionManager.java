package org.uplift.banking;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.banking.security.OTPManager;
import org.uplift.exception.InSufficientBalanceException;
import org.uplift.exception.InvalidOTPException;
import org.uplift.exception.OTPExpiredException;

import java.util.*;

public class TransactionManager {
    private Random random;
    private AccountManager accountManager;
    private Set<Transaction> transactionHistory = new HashSet<>();
    private OTPManager otpManager;

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }


    public void setRandom(Random random){
        this.random = random;
    }
    public  Transaction transfer(Account source, Account target, double amount) throws InSufficientBalanceException {
        source.withdraw(amount);
        target.deposit(amount);
        String txnId = "" + random.nextInt(100000,100000000);
        Transaction t =  new Transaction(source,target,new Date(),amount,txnId);
        transactionHistory.add(t);
        return t;
    }

    public Transaction findByTransactionID(String txnId) {
        return transactionHistory.stream().filter(a->a.getTransactionId().equals(txnId)).findFirst().orElse(null);
    }


    public Transaction makePayment(String source, TransferType sourceType,String target, TransferType targetType, double amount) throws InSufficientBalanceException, InvalidOTPException, OTPExpiredException {
        if(!otpManager.validateOTP()){
            throw new InvalidOTPException("Invalid otp.Due to three trials your account is blocked for 24 hours.Please try again after 24 hours.");
        }
        Account sourceAccount= findAccount(source, sourceType);
        Account targetAccount = findAccount(target,targetType);
        return transfer(sourceAccount,targetAccount,amount);

    }


    private Account findAccount(String source, TransferType sourceType) {
        Account account = null;
        switch(sourceType){
            case ACCOUNT_ID -> {account = accountManager.finByAccountNumber(source);}
            case MOBILE -> {account = accountManager.findMyMobile(source);}
            case USERNAME -> {account = accountManager.findMyUsername(source);}
        }
        return account;
    }

}
package org.uplift.banking;

import org.uplift.OTPManager.OtpManager;
import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.uplifte.exceptionhandling.InsufficientBalanceException;
import org.uplift.uplifte.exceptionhandling.InvalidOtpException;
import org.uplift.uplifte.exceptionhandling.OtpExpiredException;

import java.util.*;

public class TransactionManager {
    private Random random;
    private AccountManager accountManager;
    private OtpManager otpManager;
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

    public Transaction makePayment(String source, TransferType sourceType, String target,TransferType targetType, double amount) throws InsufficientBalanceException, OtpExpiredException, InvalidOtpException {
        if (!otpManager.validateOtp()){
            throw new InvalidOtpException("Otp enter is incorrect. request to try after 24 hours.");
        }
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

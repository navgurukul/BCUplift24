package org.uplift.banking.security;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.account.exception.InsufficientBalanceException;
import org.uplift.account.exception.InvalidOtpException;
import org.uplift.banking.AccountManager;
import org.uplift.banking.OtpExpiredException;
import org.uplift.banking.OtpGenerator;
import org.uplift.banking.TransferType;


import java.util.*;

public class TransactionManager {
    private Random random;
    private AccountManager accountManager;
    private OtpGenerator otpGenerator;
    private Set<Transaction> transactonHistory = new HashSet<>();
    public void setRandom(Random random) {
        this.random = random;
    }

    public Transaction transfer(Account source, Account target, double amount) throws InsufficientBalanceException {
        source.withdraw(amount);
        target.deposit(amount);
        String txnId = ""+random.nextInt(100000,100000000);
        Transaction t =  new Transaction(source,target,new Date(),amount,txnId);
        transactonHistory.add(t);
        return t;
    }

    public Transaction findByTransctionId(String txnId) {
        return transactonHistory.stream().filter(i->i.getId().equals(txnId)).findFirst().orElse(null);
    }

    public Transaction makePayment(String sourceId, TransferType sourceType, String mobileNumber, TransferType target, double amount) throws InsufficientBalanceException, InvalidOtpException, OtpExpiredException {
        if (!otpGenerator.validateOtp()) {
            throw new InvalidOtpException("Otp entered is incorrect,request to do after 20 hour");
        }
        Account sourceAccount = findAccount(sourceId,sourceType);
        Account targetAccount = findAccount(sourceId,sourceType);
        return transfer(sourceAccount,targetAccount,amount);
    }

    private Account findAccount(String sourceId, TransferType sourceType) {
        Account account = null;
        switch(sourceType) {
            case account ->  {
                account = accountManager.findbyAccountNumber(sourceId);
            }
            case mobile -> {
                account = accountManager.findByMobileNumber(sourceId);
            }
            case username -> {
                account = accountManager.findByUserName(sourceId);
            }
        }
        return account;
    }
}

package org.example.banking;

import org.example.account.Account;
import org.example.banking.security.OTPManager;
import org.example.exception.InsufficientBalanceException;
import org.example.account.Transaction;
import org.example.exception.InvalidOtpException;
import org.example.exception.OTPExpiredException;

import java.util.*;

public class TransactionManager {
    private Random random;
    private AccountManager accountManager;
    private OTPManager otpManager;
    private Set<Transaction> transactionHistory;

    public TransactionManager() {
        this.transactionHistory = new HashSet<>();
    }

    public Transaction transfer(Account source, Account target, double amount) throws InsufficientBalanceException {
        source.withdraw(amount);
        target.deposit(amount);
        String txtId=""+random.nextInt(1000000,100000000);
        Transaction t=new Transaction(source,target,new Date(),amount,txtId);
        transactionHistory.add(t);
        return t;
    }

    public void setRandomNo(Random random) {
        this.random = random;

    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public Transaction findByTransactionId(String s) {
        for(Transaction t:transactionHistory){
            if(t.getId().equals(s))
                return t;

        }
        return null;
    }

    public Transaction makePayment(String source, TransferType sourceType, String target,TransferType targetType, double amount) throws InsufficientBalanceException, OTPExpiredException, InvalidOtpException {
        if(!otpManager.validateOTP()){
            throw new InvalidOtpException("invalid OTP.Your account is Blocked request to try after 24 hours.");
        }
        Account sourceAccount=findAccount(source,sourceType);
        Account targetAccount=findAccount(target,targetType);
        return transfer(sourceAccount,targetAccount,amount);
    }

    private Account findAccount(String source, TransferType sourceType) {
        Account account=null;
        switch(sourceType){
            case ACCOUNT_NUMBER -> {
                account=accountManager.findByAccountNumber(source);
            }
            case MOBILE_NUMBER -> {
                account=accountManager.findByMobile(source);
            }
            case USER_NAME -> {
                account=accountManager.findByUsername(source);
            }

        }
        return account;
    }
}


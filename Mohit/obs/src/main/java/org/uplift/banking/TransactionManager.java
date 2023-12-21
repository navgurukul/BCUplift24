package org.uplift.banking;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exception.InSufficientBalanceException;
import org.uplift.security.AccountManager;
import org.uplift.security.OtpExpireException;
import org.uplift.security.OtpManager;

import java.util.*;

public class TransactionManager {
    private Random random;
    private OtpManager otpManager;
    private AccountManager accountManager;
     private Set<Transaction> transactionSet=new HashSet<>();

    public void setRandom(Random random) {
        this.random = random;
    }

    public void setOtpManager(OtpManager otpManager) {
        this.otpManager = otpManager;
    }

    public  Transaction transfer(Account source, Account targetAccount, double amount) throws InSufficientBalanceException {
        source.withdraw(amount);
        targetAccount.deposite(amount);
        String txnId= ""+random.nextInt(100000,100000000);
        Transaction t = new Transaction(source,targetAccount,new Date(),1000,txnId);
        transactionSet.add(t);
        return t;
    }

    public Transaction findByTransactionId(String txnd) {
        for(Transaction t : transactionSet){
            if(t.getId().equals(txnd)){
                return t;
            }
        }
        return null;
    }

    public Transaction findbyAccountId(String id){
        return transactionSet.stream().filter(a->a.getId().equals(id)).findFirst().orElse(null);
    }




    public Transaction makePayment(String sourceId, Transfertype sourceType, String targetId, Transfertype targetType, double amount) throws InSufficientBalanceException, OtpExpireException, InvalidOtpException {
        if (!otpManager.validateOtp()){
            throw new InvalidOtpException("Otp entered is incorrect, request to try again");
        }
        Account sourceAccount = findAccount(sourceId,sourceType);
        Account targetAccount = findAccount(targetId, targetType);
        return transfer(sourceAccount,targetAccount,amount);
    }

    private Account findAccount(String sourceId, Transfertype sourceType) {
        Account account = null;
        switch (sourceType) {
            case MOBILE -> {
                account = accountManager.findAccountByMobile(sourceId);
            }
            case ACCOUNT -> {
                account = accountManager.findAccountNumber(sourceId);
            }
            case USERNAME -> {
                account = accountManager.findAccountByUserName(sourceId);
            }
        }
        return account;
    }
}

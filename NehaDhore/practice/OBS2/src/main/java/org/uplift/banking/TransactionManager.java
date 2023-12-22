package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.exception.InvalidOtpException;
import org.uplift.exception.OtpExpiredException;

import java.util.*;

import static org.uplift.bank.TransferType.MOBILE;
import static org.uplift.bank.TransferType.USERNAME;

public class TransactionManager {
    private Random random;
    private AccountManager accountManager;
    private OtpManager otpManager;
    private Set<Transaction> transactionHistrory = new HashSet<>();
    public TransactionManager(AccountManager accountManager,Random random){
        this.accountManager = accountManager ;
        this.random =random ;
    }


    public Transaction transfer(Account source, Account target, double amount) throws InsufficientBalanceException {

        source.withdraw(amount);
        target.deposit(amount);
       String txnd = ""+ random.nextInt(1000000,1000000000);
       Transaction t = new Transaction(source,target,new Date(),1000,txnd);
       transactionHistrory.add(t);
       return t;
    }
    public Transaction findByTransactionId(String txnd){
        for(Transaction t : transactionHistrory){
            if(t.getTransactionId().equals(txnd)) return t;
        }
        return null;
    }

    public Transaction makePayment(String sourceId, TransferType soucreType, TransferType targetType, String target, double amount) throws InsufficientBalanceException, OtpExpiredException, InvalidOtpException {

     Account sourceAccount = getAccount(sourceId,soucreType);
     Account targetAccount = getAccount(target,targetType);
     if(!otpManager.validateOtp()){
         throw new InvalidOtpException("Invalid Otp");
     }
     return transfer(sourceAccount,targetAccount,amount);
    }

    private Account getAccount(String sourceId, TransferType soucreType) {
        Account account = null ;
        switch (soucreType){
            case ACCOUNT -> {
                account = accountManager.findByAccountnumber(sourceId);

            }
            case MOBILE -> {
                account = accountManager.findByMobile(sourceId);
            }
            case USERNAME ->{
                account = accountManager.findByUsername(sourceId);
            }
        }
        return account;
    }
}

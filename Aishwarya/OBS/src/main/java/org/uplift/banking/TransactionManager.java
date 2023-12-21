package org.uplift.banking;

import org.uplift.account.Account;
import org.uplift.account.AccountManager;
import org.uplift.account.InsufficientBalanceException;
import org.uplift.account.Transaction;
import org.uplift.banking.security.OTPManager;
import org.uplift.banking.security.OtpExpiredException;

import java.util.*;

public class TransactionManager {

    private Random random;
    Set<Transaction> transactionHistory = new HashSet<>();
    private AccountManager accountManager;
    private OTPManager otpManager;






    public Transaction transfer(Account source, Account target, double amount) throws InsufficientBalanceException {

        source.withdraw(amount);
        target.deposit( amount );
        String txnId = "" + random.nextInt(1000000,1000000000);

        Transaction t = new Transaction( source, target, new Date(), amount, txnId);
        transactionHistory.add(t);
        return t;
    }




    public Transaction findByTransactionId(String txnId){

        return transactionHistory.stream().filter(t -> t.getId().equals( txnId )).findFirst().orElse( null );
    }





    public Transaction makePayment(String sourceId, TransferType sourceType, String target , TransferType targetType, double amount) throws InsufficientBalanceException, OtpExpiredException, InvalidOtpException {

        if(!otpManager.validateOtp()){
            throw new InvalidOtpException("Otp is Incorrect, Request to try after 24 hours");
        }
        Account sourceAccount = findAccount(sourceId,sourceType);
        Account targetAccount = findAccount(sourceId,sourceType);
        return transfer(sourceAccount,targetAccount,amount);
    }





    private Account findAccount(String sourceId, TransferType sourceType) {
        Account account = null;
        switch(sourceType) {
            case ACCOUNT_ID ->  {
                account = accountManager.findByAccountNumber(sourceId);
            }
            case MOBILE -> {
                account = accountManager.findByMobileNumber(sourceId);
            }
            case USERNAME -> {
                account = accountManager.findByUserName(sourceId);
            }
        }
        return account;
    }

}

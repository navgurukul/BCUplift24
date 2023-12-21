package org.uplift.banking;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.banking.security.OtpManager;
import org.uplift.exception.InsufficientAccountBalanceException;
import org.uplift.exception.InvalidOtpException;
import org.uplift.exception.OtpExpireException;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TransactionManager {
    private Random random;
    private AccountManager accountManager;
    private OtpManager otpManager;
    private Set<Transaction> transactionHistory = new HashSet<>();

    public Transaction transfer(Account source, Account target, double amount)
            throws InsufficientAccountBalanceException {

        source.withdraw(amount);
        target.deposit(amount);

        String txnId = ""+random.nextInt(100000, 1000000000);
        Transaction t=  new Transaction(source, target, new Date(), amount, txnId);
        transactionHistory.add(t);
        return t;
    }

    public void setRandom(Random random){
        this.random = random;
    }

    public Transaction findByTransactionId(String txnId) {

        return transactionHistory.stream().filter(transaction -> transaction.getId().equals(txnId))
                .findFirst().orElse(null);

    }

    public Transaction makePayment(String source, TransferType sourceType, String target, TransferType targetType,
                                   double amount) throws InsufficientAccountBalanceException, OtpExpireException,
            InvalidOtpException {

        if (!otpManager.validateOtp()){
            throw new InvalidOtpException("Otp entered is incorrect. Request to try again after 24 hours");
        }
        Account sourceAccount = findAccount(source, sourceType);
        Account targetAccount = findAccount(target, targetType);

        return transfer(sourceAccount, targetAccount, amount);
    }

    private Account findAccount(String source, TransferType sourceType) {
        Account account = null;
        switch (sourceType){
            case ACCOUNT_ID -> {
                account = accountManager.findByAccountNumber(source);
            }
            case MOBILE -> {
                account = accountManager.findByPhoneNumber(source);
            }
            case USERNAME -> {
                account = accountManager.findByUserName(source);
            }
        }
        return account;
    }
}

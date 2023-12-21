package org.uplift.bankingprovider;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.bankingprovider.security.OtpManager;
import org.uplift.exception.InsufficientAccountBalanceException;
import org.uplift.exception.InvailidOfpException;
import org.uplift.exception.OtpExpiredException;

import java.util.*;

public class TransactionManager {

    private Random random;
    private OtpManager otpManager;
    private Set<Transaction> transactionsHistory = new HashSet<>();
    private AccountManager accountManager;

    public void setRandom(Random random){
        this.random = random;
    }
    public Transaction transfer(Account source, Account target, double amount) throws InsufficientAccountBalanceException {
        source.withdraw(amount);
        target.deposit(amount);
        String txnId = ""+random.nextInt(1000, 10000);
        Transaction t = new Transaction(source, target, new Date(), amount, txnId);
        transactionsHistory.add(t);
        return t;
    }


    public Transaction findByTransactionId(String txtId) {
        return transactionsHistory.stream().filter(t->t.getId().equals(txtId)).findFirst().orElse(null);
    }

    public Transaction makePayment(String source, TransferType sourceType, String target, TransferType targetType ,
                                   double amount) throws InsufficientAccountBalanceException, OtpExpiredException, InvailidOfpException {
        if (!otpManager.validateOtp()){
            throw new InvailidOfpException("OTP entered is incorrect. Request to try again after 24 hours");
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

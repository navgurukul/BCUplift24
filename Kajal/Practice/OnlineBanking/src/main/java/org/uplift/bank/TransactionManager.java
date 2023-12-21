package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientAccountBalanceException;

import java.util.*;

public class TransactionManager {

    private Random random;
    private Set<Transaction> transactionsHistory = new HashSet<>();
    private AccountManager accountManager = new AccountManager();

    public void setRandom(Random random){
        this.random = random;
    }
    public Transaction transfer(Account source, Account target, double amount) throws InsufficientAccountBalanceException {
        source.withdraw(amount);
        target.deposit(amount);
        String txnId = ""+random.nextInt(1000000, 1000000000);
        Transaction t = new Transaction(source, target, new Date(), amount, txnId);
        transactionsHistory.add(t);
        return t;
    }


    public Transaction findByTransactionId(String txtId) {
        return transactionsHistory.stream().filter(t->t.getId().equals(txtId)).findFirst().orElse(null);
//        for (Transaction t : transactionsHistory){
//            if (t.getId().equals(txtId)) return t;
//        }
//        return null;
    }

    public Transaction makePayment(String source, TransferType sourceType, String target, TransferType targetType , double amount) throws InsufficientAccountBalanceException {
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

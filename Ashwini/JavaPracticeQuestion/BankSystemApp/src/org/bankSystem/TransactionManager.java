package org.bankSystem;

import org.bankSystem.ExceptionHandling.InsufficientFundsException;
import org.bankSystem.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private List<Transaction> transactions;

    public TransactionManager() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void executeTransactions() {
        for (Transaction transaction : transactions) {
            try {
                transaction.execute();
                System.out.println("Transaction executed successfully.");
            } catch (InsufficientFundsException e) {
                System.out.println("Transaction failed: " + e.getMessage());
            }

        }
    }
}


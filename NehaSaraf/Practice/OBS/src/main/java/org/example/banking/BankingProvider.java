package org.example.banking;

import org.example.account.Transaction;

public interface BankingProvider {
    public Transaction makePayment(String source, TransferType sourceType, String target, TransferType targetType, double amount);
}

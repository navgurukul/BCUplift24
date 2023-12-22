package org.uplift.banking;

import org.uplift.account.Transaction;

public interface BankingProvider {
    public Transaction makePayment(String sourceId, TransferType sourceType,
                                   String target, TransferType targetType, double amount);



}
package com.uplift.banking;

import com.uplift.account.Transaction;

public interface BankingProvider {
    public Transaction makePayment(String sourceId, TransferType sourceType,
                                   String target, TransferType targetType, double amount);



}

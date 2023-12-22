package org.example.bankingprovider;

import org.example.account.Transaction;

public interface BankingProvider {
    Transaction makePayment(String source, TransferType sourceType, String target, TransferType targetType,
                            double amount);
}

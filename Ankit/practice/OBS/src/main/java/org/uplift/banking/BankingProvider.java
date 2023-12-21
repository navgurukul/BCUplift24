package org.uplift.banking;

import org.uplift.account.Transaction;

public interface BankingProvider {
    Transaction makePayment(String sourceId, TransferType sourceType, String targetId, TransferType targetType, double amount);

}

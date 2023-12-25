package org.uplift.bank.security;

import org.uplift.account.Transection;
import org.uplift.bank.TransferType;

public interface BankingProvider {
    public Transection makePayment(String source, TransferType sourceType, String target, TransferType targetType, int amount);


}

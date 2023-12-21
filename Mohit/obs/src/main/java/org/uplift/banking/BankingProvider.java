package org.uplift.banking;

import org.uplift.account.Transaction;
import org.uplift.exception.InSufficientBalanceException;
import org.uplift.security.OtpExpireException;

public interface BankingProvider {
    Transaction makePayment(String sourceId, Transfertype sourceType, String targetId, Transfertype targetType, double amount);

}


package org.uplift.banking;

import org.uplift.account.InsufficientBalanceException;
import org.uplift.account.Transaction;
import org.uplift.banking.security.OtpExpiredException;

public interface BankingProvider {

    public Transaction makePayment(String sourceId, TransferType sourceType, String mobileNumber, TransferType target, double amount);

    }

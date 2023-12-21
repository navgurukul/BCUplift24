package org.uplift.banking;

import org.uplift.account.Transaction;
import org.uplift.account.exception.InsufficientBalanceException;
import org.uplift.account.exception.InvalidOtpException;
import org.uplift.banking.security.TransactionManager;

public class RetailBankingProvider implements BankingProvider{
    private TransactionManager tm;
    @Override
    public Transaction makePayment(String sourceId, TransferType sourceType, String mobileNumber, TransferType target, double amount) {
        try {
            return tm.makePayment(sourceId,sourceType,mobileNumber,target,amount);
        } catch (InsufficientBalanceException e) {
            throw new RuntimeException(e);
        } catch (InvalidOtpException e) {
            throw new RuntimeException(e);
        } catch (OtpExpiredException e) {
            throw new RuntimeException(e);
        }
    }
}

package org.uplift.banking;

import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientAccountBalanceException;
import org.uplift.exception.InvalidOtpException;
import org.uplift.exception.OtpExpireException;

public class RetailBankingProvider implements BankingProvider{

    private TransactionManager tm;
    @Override
    public Transaction makePayment(String source, TransferType sourceType, String target, TransferType targetType, double amount) {
        try {
            return tm.makePayment(source, sourceType, target, targetType, amount);
        } catch (InsufficientAccountBalanceException e) {
            throw new RuntimeException(e);
        } catch (OtpExpireException e) {
            throw new RuntimeException(e);
        } catch (InvalidOtpException e) {
            throw new RuntimeException(e);
        }
    }
}

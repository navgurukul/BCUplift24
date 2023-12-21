package org.uplift.bankingprovider;

import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientAccountBalanceException;
import org.uplift.exception.InvailidOfpException;
import org.uplift.exception.OtpExpiredException;

public class RetailBankingProvider implements BankingProvider{
    private TransactionManager tm;
    @Override
    public Transaction makePayment(String source, TransferType sourceType, String target, TransferType targetType, double amount) {
        try {
            return tm.makePayment(source, sourceType, target, targetType, amount);
        } catch (InsufficientAccountBalanceException e) {
            throw new RuntimeException(e);
        } catch (OtpExpiredException e) {
            throw new RuntimeException(e);
        } catch (InvailidOfpException e) {
            throw new RuntimeException(e);
        }
    }
}

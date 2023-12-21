package org.uplift.banking;

import org.uplift.account.InsufficientBalanceException;
import org.uplift.account.Transaction;
import org.uplift.banking.security.OtpExpiredException;

public class RetailBankingProvider implements BankingProvider {
    private TransactionManager transactionManager;
    @Override
    public Transaction makePayment(String sourceId, TransferType sourceType, String target, TransferType targetType, double amount) {
        try {
            return transactionManager.makePayment( sourceId, sourceType, target,targetType, amount );
        } catch (InsufficientBalanceException e) {
            throw new RuntimeException( e );
        } catch (OtpExpiredException e) {
            throw new RuntimeException( e );
        } catch (InvalidOtpException e) {
            throw new RuntimeException( e );
        }
    }
}

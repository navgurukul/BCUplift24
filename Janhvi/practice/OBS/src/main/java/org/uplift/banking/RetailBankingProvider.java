package org.uplift.banking;

import org.uplift.account.Transaction;
import org.uplift.exception.InSufficientBalanceException;
import org.uplift.exception.InvalidOTPException;
import org.uplift.exception.OTPExpiredException;

public class RetailBankingProvider implements BankingProvider {

    private TransactionManager tm;
    @Override
    public Transaction makePayment(String source, TransferType sourceType, String target, TransferType targetType, double amount) {
        try {
            return tm.makePayment(source,sourceType,target,targetType,amount);
        } catch (InSufficientBalanceException e) {
            throw new RuntimeException(e);
        } catch (InvalidOTPException e) {
            throw new RuntimeException(e);
        } catch (OTPExpiredException e) {
            throw new RuntimeException(e);
        }
    }
}

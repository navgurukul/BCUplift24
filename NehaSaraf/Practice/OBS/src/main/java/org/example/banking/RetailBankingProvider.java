package org.example.banking;

import org.example.account.Transaction;
import org.example.exception.InsufficientBalanceException;
import org.example.exception.InvalidOtpException;
import org.example.exception.OTPExpiredException;

public class RetailBankingProvider implements BankingProvider {
    private TransactionManager transactionManager;

    @Override
    public Transaction makePayment(String source, TransferType sourceType, String target, TransferType targetType, double amount) {
        try {
            return transactionManager.makePayment(source,sourceType,target,targetType,amount);
        } catch (InsufficientBalanceException e) {
            throw new RuntimeException(e);
        } catch (OTPExpiredException e) {
            throw new RuntimeException(e);
        } catch (InvalidOtpException e) {
            throw new RuntimeException(e);
        }
    }
}

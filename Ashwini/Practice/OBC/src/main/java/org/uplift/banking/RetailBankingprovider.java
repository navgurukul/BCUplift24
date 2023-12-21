package org.uplift.banking;

import org.uplift.account.Transaction;
import org.uplift.uplifte.exceptionhandling.InsufficientBalanceException;
import org.uplift.uplifte.exceptionhandling.InvalidOtpException;
import org.uplift.uplifte.exceptionhandling.OtpExpiredException;

import java.util.Scanner;

public class RetailBankingprovider implements BankingProvider {
    private TransactionManager transactionManager;
    private Scanner scanner;

    @Override
    public Transaction makePayment(String source, TransferType sourceType, String target, TransferType targetType, double amount) {
        int ctr = 0;
        do {
            try {
                return transactionManager.makePayment(source, sourceType, target, targetType, amount);
            } catch (InsufficientBalanceException e) {
                throw new RuntimeException(e);
            } catch (OtpExpiredException e) {
                System.err.println("Sorry, try again (YES/NO)");
                String userInput = scanner.next();
                if (!userInput.equals(AttemptChoice.YES.toString())) {
                    return null;
                }
            } catch (InvalidOtpException e) {
                throw new RuntimeException(e);
            } finally {
                ctr++;
            }
        } while (ctr < 3);
        return null;
    }
}

package org.uplift.bankingprovider;

import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientAccountBalanceException;
import org.uplift.exception.InvailidOfpException;
import org.uplift.exception.OtpExpiredException;

import java.util.Scanner;

public class RetailBankingProvider implements BankingProvider{
    private TransactionManager tm;
    private Scanner scanner;

    @Override
    public Transaction makePayment(String source, TransferType sourceType, String target, TransferType targetType, double amount) {
        int ctr = 0;
        do {
            try {
                return tm.makePayment(source, sourceType, target, targetType, amount);
            } catch (InsufficientAccountBalanceException e) {
                throw new RuntimeException(e);
            } catch (OtpExpiredException e) {
                System.err.println(e.getMessage() + " Sorry Otp has expired, would you want to try agai (Yes/ No): ");
                String userInput = scanner.next();
                if (userInput.equals(Attempt.NO.toString())) return null;
            } catch (InvailidOfpException e) {
                throw new RuntimeException(e);
            }
            finally {
                ctr++;
            }
        }while (ctr < 3);
        return null;
    }
}

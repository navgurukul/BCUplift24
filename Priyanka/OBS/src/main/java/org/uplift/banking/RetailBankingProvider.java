package org.uplift.banking;

import org.uplift.account.Transaction;
import org.uplift.account.exception.InsufficientBalanceException;
import org.uplift.account.exception.InvalidOtpException;
import org.uplift.banking.security.TransactionManager;

import java.util.Scanner;

public class RetailBankingProvider implements BankingProvider{
    private TransactionManager tm;
    private Scanner scanner;
    @Override
    public Transaction makePayment(String sourceId, TransferType sourceType, String mobileNumber, TransferType target, double amount) {
        int ctr = 0;
        do {
            try {
                return tm.makePayment(sourceId, sourceType, mobileNumber, target, amount);
            } catch (InsufficientBalanceException e) {
                throw new RuntimeException(e);
            } catch (InvalidOtpException e) {
                throw new RuntimeException(e);
            } catch (OtpExpiredException e) {
                System.err.println(e.getMessage());
                System.out.println("Sorry,Otp has expired, Would you like to try again?(Yes/NO)");
                String userInput = scanner.next();
                if (userInput.equals(Choice.NO.toString()))
                    return null;
            } finally {
                ctr++;
            }

        } while (ctr < 3);
        return null;
    }
}

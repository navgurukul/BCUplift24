package org.example.bankingprovider;

import org.example.account.Transaction;
import org.example.exception.InsufficientAccountBalanceException;
import org.example.exception.InvalidOtpException;
import org.example.exception.OtpExpiredException;

import java.util.Scanner;

public class RetailBankingProvider implements BankingProvider {

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

                System.err.println(e.getMessage());
                System.out.println("Sorry, otp has expired, Would you like to try again? (YES/NO) ");
                String userInput = scanner.next();
                if (userInput.equals(Attempt.NO.toString())) return null;

            } catch (InvalidOtpException e) {
                throw new RuntimeException(e);
            } finally {
                ctr ++;
            }
        } while(ctr < 3);
        return null;
    }
}

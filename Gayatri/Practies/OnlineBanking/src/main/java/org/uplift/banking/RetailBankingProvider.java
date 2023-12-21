package org.uplift.banking;

import org.uplift.account.Transaction;
import org.uplift.exception.InSufficientBalanceException;
import org.uplift.exception.InvalidOTPException;
import org.uplift.exception.OTPExpiredException;

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
            } catch (InSufficientBalanceException e) {
                throw new RuntimeException(e);
            } catch (InvalidOTPException e) {
                throw new RuntimeException(e);
            } catch (OTPExpiredException e) {
                System.err.println(e.getMessage());
                System.out.println("Sorry, otp has expired .Would you lik to try again ? (YES/NO)");
                String userInput = scanner.next();
                if (userInput.equals(Attempt.NO.toString())) {
                    return null;
                    //return makePayment(source, sourceType, target, targetType, 34365);
                }
            }
            finally{
                ctr++;
            }

        }while(ctr<3);
        return null;

    }
}
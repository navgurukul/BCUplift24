package org.uplift.banking;

import org.uplift.account.Transaction;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.exception.OtpExpiredException;
import org.uplift.exception.OtpMismatchedException;
import org.uplift.security.OtpManager;

import java.util.Scanner;

public class RetailBankingProvider implements BankingProvider{
    private TransactionManager transactionManager;
    private Scanner scanner;

    public RetailBankingProvider(TransactionManager transactionManager, Scanner scanner) {
        this.transactionManager = transactionManager;
        this.scanner = scanner;
    }

    @Override
    public Transaction makePayment(String sourceId, TransferType sourceType, String targetId, TransferType targetType, double amount) {
        int maxAttempts = 3 ;
        do {
            try {
                return transactionManager.makePayment(sourceId,sourceType,targetId,targetType,amount);
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            } catch (OtpExpiredException e) {
                System.out.println(e.getMessage());
                System.err.println("would you like to try again?(YES/NO) ");
                String userInput = scanner.next();
                if(userInput.equals(Choice.No.toString())) {
                    return null;
                }
            } catch (OtpMismatchedException e) {
               return null;
            }finally {
                maxAttempts-- ;
            }

        }while (maxAttempts>0);
        return null ;
    }

}

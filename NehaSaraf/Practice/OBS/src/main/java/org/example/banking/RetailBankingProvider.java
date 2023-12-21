package org.example.banking;

import org.example.account.Transaction;
import org.example.exception.InsufficientBalanceException;
import org.example.exception.InvalidOtpException;
import org.example.exception.OTPExpiredException;

import java.util.Scanner;

public class RetailBankingProvider implements BankingProvider {
    private TransactionManager transactionManager;
    private Scanner scanner;

    @Override
    public Transaction makePayment(String source, TransferType sourceType, String target, TransferType targetType, double amount) {
        int count=0;
        do{
            try {
                return transactionManager.makePayment(source,sourceType,target,targetType,amount);
            } catch (InsufficientBalanceException e) {
                throw new RuntimeException(e);
            } catch (OTPExpiredException e) {
                System.err.println(e.getMessage());
                System.out.println("would you try again? (YES/NO)");
                String userInput= scanner.next();
                if(userInput.equals(Attempt.NO.toString())){
                    return null;
                }
            } catch (InvalidOtpException e) {
                throw new RuntimeException(e);
            }
            finally {
                count++;
            }
        }
        while(count <3);
        return null;

    }
}

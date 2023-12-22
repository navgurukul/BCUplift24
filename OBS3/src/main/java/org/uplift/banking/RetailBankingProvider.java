package org.uplift.banking;

import org.uplift.account.Transaction;
import org.uplift.exceptions.InsufficietBalanceException;
import org.uplift.exceptions.InvalidOtpException;
import org.uplift.exceptions.OtpExpiredException;

import java.util.Scanner;

public class RetailBankingProvider implements BankingProvider{
    private TransactionManager tm;

    private Scanner scanner;
    @Override
    public Transaction makePayment(String sourceId, TransferType sourceType,
                                   String target, TransferType targetType, double amount) {
        int ctr = 0;
        do{
            try {
                return tm.makePayment(sourceId,sourceType,target,targetType,amount);
            } catch (InsufficietBalanceException e) {
                throw new RuntimeException(e);
            } catch (OtpExpiredException e) {
                System.err.println(e.getMessage());
                System.out.println("Sorry , otp has expired. would you like to do try again? (YES/NO) ");
                String userInput = scanner.next();
                if(userInput.equals(Attempt.NO.toString())){
                    return null;
                }
            } catch (InvalidOtpException e) {
                throw new RuntimeException(e);
            }finally {
                ctr++;
            }

        }while (ctr<3);
        return null;
    }
}
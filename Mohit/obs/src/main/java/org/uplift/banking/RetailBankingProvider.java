package org.uplift.banking;

import org.uplift.account.Transaction;
import org.uplift.exception.InSufficientBalanceException;
import org.uplift.security.OtpExpireException;

import java.util.PrimitiveIterator;
import java.util.Scanner;

public class RetailBankingProvider implements BankingProvider {
    private TransactionManager tm;
    private Scanner scanner;
    @Override
    public Transaction makePayment(String sourceId, Transfertype sourceType, String targetId, Transfertype targetType, double amount) {
        int ctr=0;
        do{
            try {
                return tm.makePayment(sourceId,sourceType,targetId,targetType,amount);
            } catch (InSufficientBalanceException e) {
                throw new RuntimeException(e);
            } catch (OtpExpireException e) {

                System.err.println(e.getMessage());
                System.out.println("Sorry,your otp has expire can you please try again");
                String userInput=scanner.next();
                if(userInput.equals(Attempt.NO.toString())){
                    return null;
                }

            } catch (InvalidOtpException e) {
                throw new RuntimeException(e);
            }finally {
                {
                    ctr++;
                }
            }
        }while (ctr<3);
        return null;

    }
}

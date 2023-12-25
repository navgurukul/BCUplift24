package org.uplift.bank.security;

import org.uplift.account.Transection;
import org.uplift.bank.Attepmt;
import org.uplift.bank.OTPExpiredException;
import org.uplift.bank.TransectionManager;
import org.uplift.bank.TransferType;
import org.uplift.exceptions.InsuffucentBalanceException;
import org.uplift.exceptions.InvalidOTPException;

import java.util.Scanner;

public class RetailBankingProvider implements BankingProvider{
    private Scanner scanner;
    private TransectionManager transectionManager;
    @Override
    public Transection makePayment(String source, TransferType sourceType, String target, TransferType targetType, int amount) {
        int counter=0;
        do {
            try {
                return transectionManager.makePayment(source, sourceType, target, targetType, amount);
            } catch (InsuffucentBalanceException e) {
                throw new RuntimeException(e);
            } catch (OTPExpiredException e) {
                System.err.println(e.getMessage());
                System.out.println("Sorry OTP hase Expired whould you lick to try again (YES/NO)");
                String userInput = scanner.next();
                //if the user dont want to attempt aganin
                if (userInput.equals(Attepmt.NO.toString()))
                    return null;
            } catch (InvalidOTPException e) {
                throw new RuntimeException(e);
            }finally {
                counter++;
            }
        }while (counter<3);
                return null;
    }

}

package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exception.InSufficientBalanceException;

import java.util.*;

public class TransactionManager {
    private Random random;
     private Set<Transaction> transactionSet=new HashSet<>();

    public void setRandom(Random random) {
        this.random = random;
    }

    public  Transaction transfer(Account source, Account targetAccount, double amount) throws InSufficientBalanceException {
        source.withdraw(amount);
        targetAccount.deposite(amount);
        String txnId= ""+random.nextInt(100000,100000000);
        Transaction t = new Transaction(source,targetAccount,new Date(),1000,txnId);
        transactionSet.add(t);
        return t;
    }

    public Transaction findByTransactionId(String txnd) {
        for(Transaction t : transactionSet){
            if(t.getId().equals(txnd)){
                return t;
            }
        }
        return null;
    }
    public int generateOtp(){
        Random random = new Random();
        int otp = random.nextInt(100000,900000);
        return otp;
//        String sixDigitNumberString = String.valueOf(sixDigitNumber);
    }

    public Transaction verifyTransaction(Account source, Account target, double amount) throws InSufficientBalanceException {
        int typeOTP=generateOtp();
        System.out.println("Enter the given OTP:" + typeOTP);
        Scanner input=new Scanner(System.in);
        for(int i=0; i<3; i++){
            int put= input.nextInt();
            if(typeOTP==put){
                return transfer(source,target,amount);
            }
        }
        return null;
    }


}

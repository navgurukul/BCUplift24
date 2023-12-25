package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.account.AccountManager;
import org.uplift.account.Transection;
import org.uplift.bank.security.OTPManager;
import org.uplift.exceptions.InsuffucentBalanceException;
import org.uplift.exceptions.InvalidOTPException;

import java.util.*;

import static java.lang.String.valueOf;

public class TransectionManager {
    private OTPManager otpManager;
    private AccountManager  accountManager;
    private Set<Transection> transectionHistory=new HashSet<>();
    private Random random;

        public TransectionManager(Random random, AccountManager accountManager, OTPManager otpManager) {
            this.random = random;
            this.accountManager = accountManager;
            this.otpManager = otpManager;
        }

    //make a method with source account and target account and ammount  and give a randome OTP and ask for giving the OTP if OTP is currect the call Transection transfer() with alctual parameter which is given in this method otherwise give a 3 trys after 3 trys give frendly exception.
    public Transection transfer(Account source, Account target, double amount) throws InsuffucentBalanceException {
        //taking source account from which we have to transfer the amount
        source.withdraw(amount);
        //taking target account to which the fund have to send
        target.deposit(amount);
        //genrating the transection ID  randomly
        String transectionID=""+random.nextInt(10000000,100000001);

        //making the transection
        Transection t=new Transection(source,target,amount,new Date(),transectionID);

        //adding the transection in set (History)
        transectionHistory.add(t);
        return t;
    }

    public Transection findByTransectionId(String s) {
        return transectionHistory.stream().filter(t->t.getId().equals(s)).findFirst().orElse(null);

    }

    public Transection makePayment(String sourceId, TransferType sourceType, String target, TransferType targetType, double amount)
            throws InsuffucentBalanceException, OTPExpiredException, InvalidOTPException {

        if (!otpManager.validOTP()) {
            throw new InvalidOTPException("otp is invalid, your account is locked. Please try after 24 hours");
        }

        Account sourceAccount = findAccount(sourceId, sourceType); // This line causes NullPointerException
        Account targetAccount = findAccount(sourceId, targetType);
        return transfer(sourceAccount, targetAccount, amount);
    }


    private Account findAccount(String sourceId, TransferType sourceType) {
        Account account = null;
        switch (sourceType){
            case ACCOUNT_ID->{
                account=accountManager.findByAccountNumber(sourceId);
            }
            case MOBILE->{
               account= accountManager.findByMobileNumber(sourceId);
            }case  USERNAME->{
                account=accountManager.findByUserName(sourceId);
            }
        }
        return account;
    }

    public void setOtpManager(OTPManager otpManager) {
        this.otpManager=otpManager;
    }
}

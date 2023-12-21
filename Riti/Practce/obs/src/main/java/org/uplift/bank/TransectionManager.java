package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.account.Transection;
import org.uplift.exceptions.InsuffucentBalanceException;

import java.util.*;

import static java.lang.String.valueOf;

public class TransectionManager {
    private Set<Transection> transectionHistory=new HashSet<>();
    private Random random;
    public void setRandom(Random random) {
        this.random = random;
    }
    //make a method with source account and target account and ammount  and give a eandome OTP and ask for giving the OTP if OTP is currect the call Transection transfer() with alctual parameter which is given in this method otherwise give a 3 trys after 3 trys give frendly exception.
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
        for(Transection t:transectionHistory){
            if(t.getId().equals(s))return t;
        }return  null;
    }
}

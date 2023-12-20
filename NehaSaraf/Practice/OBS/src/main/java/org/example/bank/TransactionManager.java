package org.example.bank;

import org.example.account.Account;
import org.example.account.InsufficientBalanceException;
import org.example.account.Transaction;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class TransactionManager {
    private Random random;
    public Transaction transfer(Account source, Account target, double amount) throws InsufficientBalanceException {
        source.withdraw(amount);
        target.deposit(amount);
        String txtId=""+random.nextInt(1000000,100000000);
        return new Transaction(source,target,new Date(),amount,txtId);
    }

    public void setRandomNo(Random random) {
        this.random = random;
    }

}

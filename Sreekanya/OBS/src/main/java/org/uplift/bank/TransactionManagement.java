package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.account.Transaction;
import org.uplift.exception.InvalidSufficientBalanceException;

import java.util.Date;
import java.util.Objects;

public class TransactionManagement {

    public static Transaction transfer(Account source, Account target, double amount) throws InvalidSufficientBalanceException {
        source.withDraw(amount);
        target.deposit(amount);
        return new Transaction(source,target,new Date(),amount,""+ Objects.hash(source,target,new Date(),amount));



    }
}

    package org.bankSystem.transaction;

    import org.bankSystem.ExceptionHandling.InsufficientFundsException;
    import org.bankSystem.account.Account;

    public class TransaferTransaction extends  Transaction {
        public TransaferTransaction(Account sourceAccount, Account targetAccount, double amount) {
            super(sourceAccount, targetAccount, amount);
        }
        @Override
        public void execute() throws InsufficientFundsException {
            super.execute();
            getSourceAccount().feeDeduction();
        }
    }

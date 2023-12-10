import org.bankSystem.TransactionManager;
import org.bankSystem.account.CheckingAccount;
import org.bankSystem.account.SavingAccount;
import org.bankSystem.transaction.TransaferTransaction;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        SavingAccount savingAccount= new SavingAccount("s897",0.05);
        CheckingAccount checkingAccount = new CheckingAccount("C8653", 100.0);

        savingAccount.deposite(1000.0);

        TransaferTransaction transferTransaction = new TransaferTransaction(savingAccount, checkingAccount, 500.0);

        TransactionManager transactionManager = new TransactionManager();
        transactionManager.addTransaction(transferTransaction);

        transactionManager.executeTransactions();

        System.out.println("Savings Account Balance: " + savingAccount.getBalance());
        System.out.println("Checking Account Balance: " + checkingAccount.getBalance());
    }
}
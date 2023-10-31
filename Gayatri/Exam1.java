
import java.util.*;
import java.util.Date;


abstract class Account {
    private String accountNumber;
    protected double balance;
    private ArrayList<Transaction> transactions;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance = balance+ amount;
        createTransaction("credit", amount);
    }

    public void withdrawal(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            createTransaction("debit", amount);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    public void createTransaction(String type, double amount) {
        Random rand = new Random();
        int Id = rand.nextInt(1000);
        Date date = new Date();
        Transaction transaction = new Transaction(Id, date, type, amount);
        transactions.add(transaction);
    }

    public void printTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

}

class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public void withdrawal(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance = balance-amount;
            createTransaction("debit", amount);
        } else {
            System.out.println("Exceeded limit for withdrawal.");
        }
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void createTransaction(String type, double amount) {
        super.createTransaction(type, amount);
    }

    private void calculateInterest() {
        double interest = (balance * interestRate) / 365;
        deposit(interest);
    }

}

class Transaction {
    private int Id;
    private Date date;
    private String type;
    private double amount;

    public Transaction(int Id, Date date, String type, double amount) {
        this.Id = Id;
        this.date = date;
        this.type = type;
        this.amount = amount;
    }

    public String toString() {
        return "Transaction ID: " + Id + ", Date: " + date + ", Type: " + type + ", Amount: " + amount;
    }
}

class Customer {
    private String name;
    private String dob;
    private String aadhar;
    private Account account;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

public class Exam1 {
    public static void main(String[] args) {
        CurrentAccount currentAccount = new CurrentAccount("C12345", 6000, 24000);
        SavingsAccount savingsAccount = new SavingsAccount("S67890", 200000, 0.13);

        Customer customer1 = new Customer();
        customer1.setName("Gayatri Ganorkar");
        customer1.setAccount(currentAccount);

        Customer customer2 = new Customer();
        customer2.setName("Aniket Ganorkar");
        customer2.setAccount(savingsAccount);

        currentAccount.deposit(5000);
        currentAccount.withdrawal(10000);
        currentAccount.printTransactions();

        savingsAccount.deposit(5000);
        savingsAccount.calculateInterest();
        savingsAccount.withdrawal(10000);
        savingsAccount.printTransactions();
    }
}


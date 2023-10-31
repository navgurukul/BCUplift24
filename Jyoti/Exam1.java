import java.util.*;

abstract class Account {
    private String accountNumber;
    protected double balance;
    protected List<Transaction> transactionList;

    public Account() {
        this.accountNumber = generateAccountNumber();
        this.balance = 0;
        this.transactionList = new ArrayList<>();
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionList.add(new Transaction("credit", amount));
            System.out.println("Deposited: Rs " + amount);
        }
    }

    public abstract void withdraw(double amount);
    public void createTransaction(String type, double amount) {
        if ("debit".equals(type)) {
            if (balance >= amount) {
                balance -= amount;
                transactionList.add(new Transaction(type, amount));
                System.out.println("Transaction: Rs " + amount + " "+ type + "ed");
            }
        } else if ("credit".equals(type)) {
            balance += amount;
            transactionList.add(new Transaction(type, amount));
            System.out.println("Transaction: Rs " + amount + " " + type + "ed");
        } else {
            System.out.println("Invalid transaction type.");
        }
    }

    public void printTransactions() {
        System.out.println("Transaction History Of: " + accountNumber);
        for (Transaction transaction : transactionList) {
            System.out.println("Transaction ID: " + transaction.getId() +
                    ", Date: " + transaction.getDate() +
                    ", Type: " + transaction.getType() +
                    ", Amount: Rs " + transaction.getAmount());
        }
    }
    private String generateAccountNumber() {
        Random rand = new Random();
        int accountNumber = rand.nextInt(100000);
        return String.format("%04d", accountNumber);
    }
}

class Transaction {
    private int id;
    private Date date;
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.id = new Random().nextInt(10000);
        this.date = new Date();
        this.type = type;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }
    public Date getDate() {
        return date;
    }
    public String getType() {
        return type;
    }
    public double getAmount() {
        return amount;
    }
}

class SavingsAccount extends Account {
    private double interestRate;
    public SavingsAccount(double interestRate) {
        this.interestRate = interestRate;
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionList.add(new Transaction("debit", amount));
            System.out.println("Withdrawn: Rs " + amount);
        }
    }
    public void calculateInterest() {
        double dailyInterest = (balance * interestRate) / 365;
        balance += dailyInterest;
        System.out.println("Interest: Rs " + dailyInterest + " added to the account.");
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit;
    public CurrentAccount(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            transactionList.add(new Transaction("debit", amount));
            System.out.println("Withdrawn: Rs " + amount);
        }
    }
}

public class Exam1 {
    public static void main(String[] args) {
        // Create a Savings Account
        SavingsAccount savingsAc = new SavingsAccount(0.12);
        savingsAc.deposit(1000);
        savingsAc.createTransaction("debit", 1500);
        savingsAc.calculateInterest();
        savingsAc.printTransactions();
        System.out.println();

        // Create a Current Account
        CurrentAccount currentAc = new CurrentAccount(25000);
        currentAc.createTransaction("credit", 500);
        currentAc.withdraw(10000);
        currentAc.printTransactions();
    }
}


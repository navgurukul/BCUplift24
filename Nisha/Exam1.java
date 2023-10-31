import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

class Exam1 {
    public static void main(String[] args) {
  	Customer cust = new Customer("Nisha", "20000-01-01", 123456789);
        SavingsAccount savingsAccount = new SavingsAccount(12345, 0.10, cust);
        savingsAccount.deposit(300000);
        savingsAccount.withdraw(70000);
        savingsAccount.printTransactions();
    }
}

class Customer {
    String name;
    String dob;
    int aadharNumber;

    Customer(String name, String dob, int aadharNumber) {
        this.name = name;
        this.dob = dob;
        this.aadharNumber = aadharNumber;
    }

    protected String getName() {
        return name;
    }

    protected String getDob() {
        return dob;
    }

    protected int getAadharNumber() {
        return aadharNumber;
    }
}

abstract class Account {
    protected int accountNumber;
    protected double balance;
    protected ArrayList<Transaction> transactionList;
    protected Customer customer;

    Account(int accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.transactionList = new ArrayList<>();
        this.customer = customer; 
    }

    abstract void deposit(double amount);

    abstract void withdraw(double amount);

    void createTransaction(String type, double amount) {
        Random random = new Random();
        int id = random.nextInt(200000);
        Date date = new Date();
        Transaction transaction = new Transaction(id, date, type, amount);
        transactionList.add(transaction);
    }

    void printTransactions() {
        for (Transaction transaction : transactionList) {
            System.out.println(transaction);
        }
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accountNumber, double interestRate, Customer customer) {
        super(accountNumber, customer);
        this.interestRate = interestRate;
    }

    void deposit(double amount) {
        balance += amount;
        createTransaction("credited", amount);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            createTransaction("debited", amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

}

class CurrentAccount extends Account {
    double overdraftLimit;

    public CurrentAccount(int accountNumber, double overdraftLimit, Customer customer) {
        super(accountNumber, customer);
        this.overdraftLimit = overdraftLimit;
    }

    void deposit(double amount) {
        balance += amount;
        createTransaction("credited", amount);
    }

    void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            createTransaction("debited", amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class Transaction {
    private int id;
    private Date date;
    private String type;
    private double amount;

    public Transaction(int id, Date date, String type, double amount) {
        this.id = id; 
        this.date = date;
        this.type = type;
        this.amount = amount;
    }

    public String toString() {
        return "Transaction ID: " + id +
                ", Date: " + date +
                ", Type: " + type +
                ", Amount: " + amount;
    }
}

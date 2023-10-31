import java.util.*;
import java.util.Date;

class Customer {
    private String name;
    private String dob;
    private String aadharNumber;
    private Account account;

    public Customer(String name, String dob, String aadharNumber, Account account) {
        this.name= name;
        this.dob=dob;
        this.aadharNumber = aadharNumber;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public Account getAccount() {
        return account;
    }
}

abstract class Account {
    private String accountNumber;
    private double balance;
    protected List<Transaction> transactions;

    public void deposit(double amount) {
        balance += amount;
        createTransaction("Deposit", amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            createTransaction("Withdrawal", amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public abstract Transaction createTransaction(String item, double amount);

    public void printTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions in this account.");
        } else {
            System.out.println("List of Transactions:");
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }
}

class Transaction {
    private String id;
    private Date date;
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.id = genId();
        this.date = new Date();
        this.type = type;
        this.amount = amount;
    }

    private String genId() {
        Random r = new Random();
        return String.valueOf(r.nextInt(1000));
    }

    
    public String toString() {
        return "ID: " + id + ", Date: " + date + ", Type: " + type + ", Amount: " + amount;
    }
}

public class Exam1 {
    public static void main(String[] args) {
        SavingsAccount esiarsAccount = new SavingsAccount("S789", 0.1);
        Customer esiarsCustomer = new Customer("Esiar", "1995-11-30", "555 444 555", esiarsAccount);

        esiarsCustomer.getAccount().deposit(20000.0);
        esiarsCustomer.getAccount().withdraw(5000.0);

        System.out.println("Esiar's Details:");
        System.out.println("Name: " + esiarsCustomer.getName());
        System.out.println("Date of Birth: " + esiarsCustomer.getDob());
        System.out.println("Aadhar Number: " + esiarsCustomer.getAadharNumber());
        esiarsCustomer.getAccount().printTransactions();
    }
}



//emailumangdoctor@gmail.com
import java.util.*;
public class Exam1 {

	public static void main(String[] args) {
    		SavingsAccount savingsAccount = new SavingsAccount(2000);
    		CurrentAccount currentAccount = new CurrentAccount(25000);

   		 Customer customer1 = new Customer("Sonam", "2023-10-31", "12349236499", savingsAccount);
   		 Customer customer2 = new Customer("Monika", "2023-12-01", "98768234627", currentAccount);

    		customer1.performTransaction("credit", 1000);
    		customer1.performTransaction("debit", 500);

    		customer2.performTransaction("credit", 2000);
    		customer2.performTransaction("debit", 1500);

   		customer1.printTransactions();
    		customer2.printTransactions();
	}


}


class Customer {
    private String name;
    private String dateOfBirth;
    private String aadharNumber;
    private Account account;

    public Customer(String name, String dateOfBirth, String aadharNumber, Account account) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.aadharNumber = aadharNumber;
        this.account = account;
    }

    public void printTransactions() {
        printTransactions();
    }
}



class Transaction {
    private int id;
    private Date date;
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.id = new Random().nextInt(100);
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





abstract class Account {
    private int accountNumber;
    private int generateAccountNumber() {
        return new Random().nextInt(10000);
    }

    private double balance;
    private ArrayList<Transaction> transactionList;

    public Account() {
        this.accountNumber = generateAccountNumber();
        this.balance = 0;
        this.transactionList = new ArrayList<Transaction>();
    }

    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public void createTransaction(String type, double amount) {
        Transaction transaction = new Transaction(type, amount);
        transactionList.add(transaction);
        if (type.equals("debit")) {
            balance -= amount;
        } else if (type.equals("credit")) {
            balance += amount;
        }
    }

    public void printTransactions() {
        for (Transaction transaction : transactionList) {
            System.out.println(transaction.getId(),transaction.getDate(),transaction.getType(),transaction.getAmount());
        }
    }


}






class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    public void deposit(double amount) {
        createTransaction("credit", amount);
    }

    public void withdraw(double amount) {
        if (getBalance() >= amount) {
            createTransaction("debit", amount);
        } else {
            System.out.println("Insufficient!!!");
        }
    }
}







class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public void deposit(double amount) {
        createTransaction("credit", amount);
    }

    public void withdraw(double amount) {
        if (getBalance() + overdraftLimit >= amount) {
            createTransaction("debit", amount);
        } else {
            System.out.println("isufficient!!!!!");
        }
    }
}


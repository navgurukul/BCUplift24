import java.util.ArrayList;

class Customer {
    private String name;
    private String dateOfBirth;
    private long aadharNumber;

    public Customer(String name, String dateOfBirth, long aadharNumber) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.aadharNumber = aadharNumber;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public long getAadharNumber() {
        return aadharNumber;
    }
    public String toString() {
        return "Customer details - Name: " + getName() + ", DOB: " + getDateOfBirth() + ", Aadhar Number: " + getAadharNumber();
    }
}

abstract class Account {
    private long accountNumber;
    protected double balance;
    protected ArrayList<Transaction> transactionList;

    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionList = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public abstract void withdraw(double amount);

    public void createTransaction() {
  	//
    }

    public void printTransactions() {
        //
    }
}

class SavingAccount extends Account {
    private double interestRate;

    public SavingAccount(long accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
	    System.out.println(balance);
		
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(long accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }
}

class Transaction {
    private long transactionId;
    private String date;
    private String type;
    private double amount;

    public Transaction(long transactionId, String date, String type, double amount) {
        this.transactionId = transactionId;
        this.date = date;
        this.type = type;
        this.amount = amount;
    }

    public String toString() {
        return ("T.ID: " + transactionId + ", Date: " + date + ", Type: " + type + ", Amount: " + amount);
    }
}

public class Exam1 {
    public static void main(String[] args) {
        Customer customer = new Customer("Satyanarayana", "21/02/1990", 6783669);
	System.out.println(customer);

        SavingAccount savingAccount = new SavingAccount(54321, 150000, 25);
        savingAccount.withdraw(5000);
        savingAccount.deposit(20000);

        CurrentAccount currentAccount = new CurrentAccount(123444556, 45622, 25000);
        currentAccount.withdraw(80000);
	Transaction transation=new Transaction(14553,"2/3/1199","credit",5909);
	System.out.println(transation);
	

        
    }
}


// Banking Details 
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Random;

abstract class Account {
    private long accountNumber;
    protected double balance;
    protected List<Transaction> transList;

    public Account() {
        this.accountNumber = generateAccountNumber();
        this.balance = 0;
        this.transList = new ArrayList<>();
    }
	public long getAccountNumber(){
		return accountNumber;
	}

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance =this.balance+ amount;
            Transaction t = new Transaction(new Date(), "CREDIT", amount);
            this.transList.add(t);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance =this.balance - amount;
            Transaction t = new Transaction(new Date(), "DEBIT", amount);
            this.transList.add(t);
        } else {
            System.out.println("balance is not sufficient!");
        }
    }

   public void createTransaction(String type, double amount) {
        if ("CREDIT".equals(type)) {
            deposit(amount);
        } else if ("DEBIT".equals(type)) {
            withdraw(amount);
        }
    }

    public void printTransactions() {
        for (Transaction t : transList) {
            System.out.println(t);
        }
    }

    private long generateAccountNumber() {
        return new Random().nextLong();
    }
}

class SavingsAccount extends Account {
    private double RateofInterest;

    public SavingsAccount(double RateofInterest) {
        super();
        this.RateofInterest = RateofInterest;
    }

    
    public void deposit(double amount) {
        super.deposit(amount);
        calculateInterest();
    }

   
    public void withdraw(double amount) {
        super.withdraw(amount);
        calculateInterest();
    }

    private void calculateInterest() {
        double dailyInterest = (balance * RateofInterest) / 365;
        System.out.println("Daily interest is : " + dailyInterest );
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(double overdraftLimit) {
        super();
        this.overdraftLimit = overdraftLimit;
    }

   
    public void withdraw(double amount) {
        if (amount <= (balance + overdraftLimit)) {
            super.withdraw(amount);
        } else {
            System.out.println("overdraft limit is exceeded!");
        }
    }
}

class Customer {
    private String name;
    private String dateOfBirth;
    private String aadharNumber;
    private Account ac;

    public Customer(String name, String dateOfBirth, String aadharNumber, Account ac) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.aadharNumber = aadharNumber;
        this.ac = ac;
    }

   public void performTransaction(String type, double amount) {
        ac.createTransaction(type, amount);
    }

    public void printStatement() {
        System.out.println("Customers Name is : " + name);
        System.out.println("DOB is : " + dateOfBirth);
        System.out.println("Aadhar Number is: " + aadharNumber);
	//System.out.println(getAccountNumber());
      //  System.out.println("Ac Number is : " + ac.accountNumber);
        System.out.println("Account Balance: " + ac.balance + " Rs");
     	ac.printTransactions();
    }
}

class Transaction {
    private long transId;
    private Date date;
    private String type;
    private double amount;

    public Transaction(Date date, String type, double amount) {
        this.transId = new Random().nextLong();
        this.date = date;
        this.type = type;
        this.amount = amount;
    }

  
    public String toString() {
        return "Transaction ID is given as : " + transId +" Date is : " + date + " Type is : " + type +" Amount is equal to : " + amount ;
    }
}

public class Examone{
    public static void main(String[] args) {
        SavingsAccount s = new SavingsAccount(0.15);
        CurrentAccount c = new CurrentAccount(3000);

        Customer c1 = new Customer("Dipti Thakre  ", "10-11-2001  ", "1674-5678-9012", s);
        Customer c2 = new Customer("trupti Thakre", "24-04-1997", "9876-5432-1098",c);
	
        c1.performTransaction("CREDIT", 3000);
        c1.performTransaction("DEBIT", 500);
        c2.performTransaction("CREDIT", 100);
        c2.performTransaction("DEBIT", 150);
        c1.printStatement();
        c2.printStatement();
      System.out.println(c.getAccountNumber());
    }
}   

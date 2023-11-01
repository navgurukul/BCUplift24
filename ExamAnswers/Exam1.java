import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Random;

public class Exam1 {
	public static void main(String[] args) throws ParseException {
		Account ca = new CurrentAccount(“C12345”, 1000, 25000);
		SimpleDateFormat sdf = new SimpleDateFormat(“dd-MM-yyyy”);
		Customer c1 = new Customer(“Alka”, sdf.parse(“19-07-2004”), “A34567”, ca);

		SavingsAccount sa = new SavingsAccount(“C7890”, 500, 4.5f);
		Customer c2 = new Customer(“Ankit”, sdf.parse(“27-08-2003”), “A8901”, sa);
		sa.deposit(5000);
		sa.printTransactions();
		System.out.println(“Balance of Savings account: “ + sa.getBalance());
		sa.withdraw(300);
		sa.printTransactions();
		System.out.println(“Balance of Savings account: “ + sa.getBalance());
		double closingBalance = sa.getBalance() + sa.endOfDayInterest();
		System.out.println(“End of day balance of Savings account: “ + closingBalance);
	}
}

class Customer {
	private String name;
	private Date dob;
	private String aadharNumber;
	private Account account;

	Customer(String name, Date dob, String aadharNumber, Account account) {
		this.name = name;
		this.dob = dob;
		this.aadharNumber = aadharNumber;
		this.account = account;
	}
} 

abstract class Account {
	private String accountNumber;
	private double balance;
	private ArrayList<Transaction> transactions;

	protected double getBalance() {
		return balance;
	}

	protected void setBalance(double balance) {
		this.balance = balance;
	}

	Account(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.transactions = new ArrayList<Transaction>();
	}

	protected boolean deposit(double amount) {
		balance += amount;
		Transaction t = createTransaction(Transaction.CREDIT, amount);
		return true;
	}
	
	protected boolean withdraw(double amount) {
		if(amount <= balance) {
			balance -= amount;
			Transaction t = createTransaction(Transaction.DEBIT, amount);
			return true;
		}
		return false;
	}
	
	protected Transaction createTransaction(String type, double amount) {
		Transaction t = new Transaction(type, amount);
		transactions.add(t);
		return t;
	}

	void printTransactions() {
		for(int i = 0; i < transactions.size(); i++) {
			System.out.println(transactions.get(i));
		}
	}
}

class CurrentAccount extends Account {
	private double overdraftLimit;

	CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
		super(accountNumber, balance);
		this.overdraftLimit = overdraftLimit;
	}

	@Override
	protected boolean withdraw(double amount) {
		double balance = getBalance();
		if(amount <= (balance + overdraftLimit)) {
			setBalance(balance - amount);
			Transaction t = createTransaction(Transaction.DEBIT, amount);
			return true;
		}
		return false;
	}
	
} 

class SavingsAccount extends Account {
	private float interestRate;

	SavingsAccount(String accountNumber, double balance, float interestRate) {
		super(accountNumber, balance);
		this.interestRate = interestRate;
	}

	double endOfDayInterest() {
		return getBalance() * (interestRate / 36500);
	}
} 

class Transaction {
	private String transactionId;
	private Date date;
	private String type;
	private double amount;
	public static final String DEBIT = “debit”;
	public static final String CREDIT = “credit”;

	Transaction(String type, double amount) {
		Random r = new Random();
		this.transactionId = “T” + r.nextInt();
		this.date = new Date();
		this.type = type;
		this.amount = amount;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(“Transaction id: “ + transactionId);
		sb.append(“Date: “ + date);
		sb.append(“Type: “ + type);
		sb.append(“Amount: “ + amount);
		return sb.toString();
	}
} 

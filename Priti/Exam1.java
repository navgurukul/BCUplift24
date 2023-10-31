import java.util.*;
import java.time.*;

abstract class Account {
    	protected String accountNumber;
    	protected int balance = 0;
    	private ArrayList<Transaction> transactions;

    	Account(String accountNumber, int balance) {
        	this.accountNumber = accountNumber;
        	this.balance = balance;
        	this.transactions = new ArrayList<>();
        	System.out.println(this.accountNumber + " " + this.balance);
    	}

    	abstract public void deposit(int amount);
    	abstract public void withdraw(int amount);

    	public void addTransaction(Transaction transaction) {
        	transactions.add(transaction);
    	}
	public void printTransaction(){
		for (Transaction transaction : transactions){
			System.out.println(transaction.getId()+" "+transaction.getType());
		}
	}
}

class CurrentAccount extends Account {
    	CurrentAccount(String accountNumber, int balance) {
        	super(accountNumber, balance);
    	}

   
    	public void deposit(int amount) {
        	this.balance += amount;
        	Transaction transaction = new Transaction(1, LocalDate.now(), "deposit", amount);
        	addTransaction(transaction);
    	}

    
    	public void withdraw(int amount) {
        	this.balance -= amount;
        	Transaction transaction = new Transaction(2, LocalDate.now(), "withdrawal", amount);
        	addTransaction(transaction);
    	}
}

class SavingAccount extends Account {
    	SavingAccount(String accountNumber, int balance) {
        	super(accountNumber, balance);
    	}

    	
    	public void deposit(int amount) {
        	this.balance += amount;
        	Transaction transaction = new Transaction(1, LocalDate.now(), "deposit", amount);
        	addTransaction(transaction);
    	}

    
    	public void withdraw(int amount) {
        	this.balance -= amount;
        	Transaction transaction = new Transaction(2, LocalDate.now(), "withdrawal", amount);
        	addTransaction(transaction);
    	}
}

class Transaction {
    	int id;
    	LocalDate date;
    	String type;
    	int amount;

    	Transaction(int id, LocalDate date, String type, int amount) {
        	this.id = id;
        	this.date = date;
        	this.type = type;
        	this.amount = amount;
    	}
	public int getId(){
		return id;
	}
	public LocalDate getdate(){
		return date;
	}
	public String getType(){
		return type;
	}
	public int getAmount(){
		return amount;
	}
}

class Customer {
    	private String name;
    	private LocalDate dob;
    	private int aadharNumber;
    	private Account account;

    	Customer(String name, String dob, int aadharNumber, Account account) {
        	this.name = name;
        	this.dob = LocalDate.parse(dob);
        	this.aadharNumber = aadharNumber;
        	this.account = account;
    	}
}

public class Exam1 {
    	public static void main(String[] args) {
        	CurrentAccount customer1 = new CurrentAccount("123", 100000);
        	customer1.deposit(5000);
        	customer1.withdraw(2000);

        	SavingAccount customer2 = new SavingAccount("124", 100000);
        	customer2.deposit(3000);
        	customer2.withdraw(1000);

    }
}


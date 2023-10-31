import java.util.Random;
import java.util.ArrayList;
import java.util.Date;
class Exam1 {
	public static void main(String[] args){
		SavingAccount customer1 = new SavingAccount("Ashwini","31-05-91",901234456712 );
		CurrentAccount customer2 = new CurrentAccount("Rupali", "01-10-88", 849202835623);
		customer1.deposite(5000);
	}
}


abstract class Account {
    	private long accountNumber;
    	protected double balance;
	ArrayList<Transaction> transactionList = new ArrayList<Transaction>(); 

   	public Account() {
        	this.accountNumber = generateAccountNumber();
        	this.balance = 0.0;
       
    	}
	

    	public abstract void deposit(double amount);
	public abstract void withdraw(double amount);
	public void createTransaction(String type, double amount) {
        	Transaction transaction = new Transaction(type, amount);
        	transactionList.add(transaction);
   	 }
	public void printTransactions(){
		for(Transaction transaction : transactionList){
			System.out.println(transaction);	
	};
	private long generateAccountNumber() {
        	Random random = new Random();
        	return Math.abs(random.nextLong());
    	}

	
}

class SavingsAccount extends Account {
    	final double interestRate = 0.12;

    	public SavingsAccount(double interestRate) {
        	this.interestRate = interestRate;
    	}

    	public void applyInterest() {
        	double dailyInterest = (balance * interestRate) / 365;
       		System.out.println("Interest of saving amount is Rs.", dailyInterest)
    	}

   
    	public void deposit(double amount) {
        	balance += amount;
       
    	}

   
    	public void withdraw(double amount) {
        	if (amount <= balance) {
            		balance -= amount;
            	
        	} else {
            		System.out.println("Low Balance");
        	}
    	}
}

class CurrentAccount extends Account {
    	final double overdraftLimit = 25000;

    	public CurrentAccount(double overdraftLimit) {
        	this.overdraftLimit = overdraftLimit;
    	}
   
    	public void deposit(double amount) {
        	balance += amount;
        
    	}

   
    	public void withdraw(double amount) {
        	if (balance + overdraftLimit >= amount) {
            		balance -= amount;
            		
        	} else {
            		System.out.println("Exceed Amount");
        	}
    	}
}
Class Transaction {
	private long transactionId;
    	private Date date;
    	private String type;
    	private double amount;

    	public Transaction(String type, double amount) {
        	this.transactionId = generateTransactionId();
        	this.date = new Date();
        	this.type = type;
        	this.amount = amount;
    	}

    	private long generateTransactionId() {
        	Random random = new Random();
        	return Math.abs(random.nextLong());
    	}
}

class Customer {
    	private String name;
    	private String dateOfBirth;
    	private long aadharNumber;
    	private Account account;

    	public Customer(String name, String dateOfBirth, long aadharNumber, Account account) {
        	this.name = name;
        	this.dateOfBirth = dateOfBirth;
        	this.aadharNumber = aadharNumber;
        	this.account = account;
    }

}


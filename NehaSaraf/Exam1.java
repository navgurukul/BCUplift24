import java.util.Date;
import java.util.ArrayList;
 
class Customer{
	private String name;
	private String dob;
	private String aadharNumber;
	private Account account;

	public Customer(String name, String dob , String aadharNumber){
		this.name=name;
		this.dob=dob;
		this.aadharNumber=aadharNumber;
	}
}

class Transaction{
	private int id;
	private Date date;
	private String type;
	private double amount;

	public Transaction(int id ,Date date, String type, double amount){
		this.id=id;
		this.date=date;
		this.type=type;
		this.amount=amount;
	}
	
	int getId(){
		id=Math.random();
		return id;
	}
	int getDate(){
		return date;
	}
	int gatType(){
		return type;
	}
}

abstract class Account{
	String accountNumber;
	double balance;
	ArrayList<Transaction> transactions =new ArrayList<Transaction>();

	public Account(String accountNumber,double balance){
		this.accountNumber=accountNumber;
		this.balance= balance;
	}

	abstract void deposit(double amount);
	abstract double withdraw(double amount);
	abstract void createTransaction(String type, double amount);
	abstract void printTransaction();
}

class CurrentAccount extends Account{

	private double overdraftLimit;
	public CurrentAccount(String accountNumber,double balance,double overdraftLimit){
		this.overdraftLimit= overdraftLimit;
	}
	
	void deposit(double amount) {
        balance += amount;
    	}

	double withdraw(double amount){
		if(balance>=amount || (balance+amount)<overdraftLimit){
			return balance-amount;
		}
	}
	
	void createTransaction(String type,double amount){
		Transaction transaction=new Transaction(transactions.size()+ Transaction.getId(),Transaction.getDate(),type,amount);
		transactions.add(transaction);
	}

	void printTransaction(){
		for(Transaction transaction:transactions){
		
			System.out.println("Id: "+transaction.getId());
			System.out.println("Date: "+transaction.getDate());
			System.out.println("Type: "+transaction.gatType());
			System.out.println("Amount: "+transaction.amount);
		}
	}
	
	
}

class SavingAccount extends Account{
	
	private double interestRate;
	void SavingAccount(double interestRate){
		this.interestRate=interestRate;
	}
	void deposit(double amount){
		balance=balance+amount;
	}
	
	double withdraw(double amount){
		if(balance >=amount){
			return balance=balance-amount;
		}
		else{
			return 0;
		}
	}

	double endOfDayInterest(){
		interestRate=(balance*0.12)/365;
		balance=balance+interestRate;
		return balance;
	}

	void createTransaction(String type,double amount){
		Transaction transaction=new Transaction(transactions.size()+ Transaction.getId(),Transaction.getDate(),type,amount);
		transactions.add(transaction);
	}

	void printTransaction(){
		for(Transaction transaction:transactions){
		
			System.out.println("Id: "+transaction.getId());
			System.out.println("Date: "+transaction.getDate());
			System.out.println("Type: "+transaction.gatType());
			System.out.println("Amount: "+transaction.amount);
		}
	}

	
}


public class Exam1{

	public static void main(String[] args){
		Customer c1=new Customer("Priyanka","08-10-1999","34567890123" );
		
		CurrentAccount ca= new CurrentAccount("34567",1500.0,500);

		ca.deposit(1200.0);
		ca.createTransaction("Deposit",1200);
		ca.printTransaction();

		SavingAccount sa= new SavingAccount("78954",2500);
		sa.deposit(1500.0);
		sa.createTransaction("Deposit",1500.0);
		sa.endOfDayInterest();
		sa.printTransaction();
	}
}

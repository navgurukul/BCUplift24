import java.util.*;


class Transaction {
	private int id;
	private Date date;
	private String  type;
	private double amount;

	public Transaction(String type, double amount) {
        	this.id = new Random().nextInt(10000); 
        	this.date = new Date();
        	this.type = type;
        	this.amount = amount;
    	}
	public int getid(){
		return id;
	}
	
	public Date getdate(){
		return date;
	}
	
	public String gettype(){
		return type;
	}
	
	public double getamount(){
		return amount;
	}

	
}

class Customer{
	private String name;
	private String dob;
	private String aadharNumber;
	private Account account;

	public String getname(){
		return name;
	}
	
	public String getdob(){
		return dob;
	}

	public String getaadharNumber(){
		return aadharNumber;
	}

	public ArrayList<Account> getaccount(){
		return account;
	}

	public Customer(String name,String dob,String aadharNumber,Account account){
	
		this.name=name;
		this.dob=dob;
		this.aadharNumber=aadharNumber;
		this.account=account;
	}
}
		


abstract class Account{
	private String accountNumber;
	private double balance;
	private ArrayList<Transaction> transactions= new ArrayList<Transaction>();

	public Account(String accountNumber,double balance){
		this.accountNumer=accountNumber;
		this.balance=0;
		
	}

	public String getAccountNumber(){
		return accountNumber;
	}
	public double getBalance(){
		return balance;
	}
	public ArrayList<Transaction> gettransactions(){
		return transactions;
	}
	
	public void deposit(double amount){
		balance=balance+amount;
	}

	public void withdraw(double amount){
		balance=balance-amount;
	}

	

	

}
class CurrentAccount extends Account{
	public double overdraftLimit;

	public CurrentAccount(double overdraftLimit){
		super();
		this.overdraftLimit=overdraftLimit;
	}
	
	public double getoverdraftLimit(){
		return overdraftLimit;
	}
	
	public void withdraw(double amount){
		if (amount<=overdraftLimit){
			balance=balance-amount;
		}
		
	

	}
	
	public void createTransaction(){

	}
}

class SavingAccount extends Account{
	private  double interestRate;
	
	public double getinterestRate(){
		return interestRate;
	}

	public SavingAccount(double interestRate){
		super();
		this.interestRate=interestRate;
	}

	public void withdraw(double amount){
		if (amount<=getBalance){
			balance=balance-amount;
		}
	}
	
	public double  endofDayInterest(double interestRate){
		double dailyInterestAmount=balance*(interestRate/100)/365;
		return dailyInterestAmount;

	}
}

public class Exam1{
	public static void main(String[] args){
	
		SavingAccount s1=new SavingAccount(12);

		CurrentAccount c1= new CurrentAccount(25000);

		Customer cust1=new Customer ("Shikha","20/4/2000", "46579",c1);
		Customer cust2=new Customer ("Shivam","18/8/2003", "97893",s1);

	}
}
	

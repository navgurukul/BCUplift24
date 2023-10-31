import java.util.*;
class Customer {
	public String name;
	private String aadharNumber;
	abstract Account account;
	public Customer(String name,String aadharNumber,Account account){
		this.name=name;
		this.aadharNumber=aadharNumber;
		this.account=account;
	}
}
class Transaction{
	private int tId;
	private Date date;
	private String type;
	private double amount;
	public Transaction(int tId,Date date,String type,double amount){
		this.tId=Math.random();
		this.date=new date();
		this.type=type;
		this.amount=amount;
	}
	public String getTid(){
		return Tid;
	}
	public void setTid(int tId){
		this.tId=Math.random;
	}
	public Date getDate(){
		return getDate;
	}
	public void setDate(Date date){
		this.date=date;
	}
	public String getType(){
		return type;
	}
	public void setType(String Type){
		this.type=type;
	}
	public double getAmount(){
		return amount;
	}
	public void setAmount(double amount){
		this.amount=amount;
	}
} 
	
		

abstract class Account{
	private String accountNumber;
	protected double balance;
	public ArrayList<Transaction> list;
	public Account(String accountNumber,double balance){
		this.accountNumber=accountNumber;
		this.balance=balance;
		this.list = new ArrayList<>();
	}
	public String getAccountNumber(){
		return accountNumber;
	}
	public double getBalance(){
		return balance;
	}
	public void setBalance(double balance){
		this.balance=balance;
	}
	public void setAccountNumber(String accountNumber){
		this.accountNumber=accountNumber;
	}
	public abstract double deposit();
	public abstract double withdraw();
	public void  createTransaction(Transaction transaction){
		list.add(transaction);
	}
		
	public abstract Transaction printTransaction(){
		System.out.println(accountNumber);
		for (int i=0;i<list.size();i++){
			System.out.println("Transaction 1"+getTid+"On Date"+getDate()+"of type"+getType()+"and amount is "+getAmount());
		}
	}
}
class SavingAccount extends Account{
	public SavingAccount(String accountNumber,double balance,double interestRate){
		super(accountNumber,balance);
	}
	public void calculateInterest(){
		double interest = (balance*0.12)/365;
		deposit(interest);				;
	}		
	public double deposit(double amount){
		balance = balance+amount;
		list.add(amount);
	}
	public double withdraw(double amount){
		if (balance>=amount){
			balance= balance-amount;
			list.add(amount);
		}
		else {
			return 0;
		}
	}
	
}

class CurrentAccount extends Account{
	public CurrentAccount(String accountNumber,double balance,double overdraft){
		super(accountNumber,balance);
		this.overdraft=overdraft;
	}
	public double deposit(double amount){
		balance = balance+amount;
		list.add("credit",amount);
	}
	public double withdraw(double amount){
		double b = balance + overdraft;
		if (b>=amount){
			balance= balance-amount;
			list.add("debit",amount);
		}
		else {
			return 0;
		}
	}
}
public class Exam1{
	public static void main(String[] args){
		Customer c1=new Customer("Ram","424031204412",savingAccount);			
		c1.printTransaction();
		SaveAccount sc= new SaveAccount();
		sc.deposit();
	}
}

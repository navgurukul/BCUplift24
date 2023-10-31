import java.util.ArrayList;
import java.time.LocalDate;
import java.util.*;

public class Exam1{

	public static void main(String[] args){
		
		Account savingAcc = new SavingAccount("234987094387", 100000, 12);
		Customer customer1 = new Customer("Aman", "07-11-1998", "1234 5678 8901", savingAcc);
		System.out.println(savingAcc.getBalance());
		
		((SavingAccount) savingAcc).endOfDayInterest();
		System.out.println(savingAcc.getBalance());
		savingAcc.deposit(5000);
		savingAcc.deposit(5000);
		savingAcc.withdraw(10000);
		savingAcc.printTransactions();

		
		Account currentAcc = new CurrentAccount("234987094387", 100000, 25000);
		Customer customer2 = new Customer("Aryan", "07-11-1998", "1234 5678 8901", currentAcc);

		System.out.println(currentAcc.getBalance());
		currentAcc.deposit(5000);
		currentAcc.withdraw(10000);
		currentAcc.withdraw(50000);
		currentAcc.withdraw(25000);
		currentAcc.withdraw(25000);
		currentAcc.withdraw(25000);
		currentAcc.withdraw(25000);

		currentAcc.printTransactions();
		
	}

}

class Customer{
	private String name;
	private String dob;
	private String aadharNumber;
	public Account account;

	Customer(String name, String dob, String aadharNumber, Account account){
		this.name = name;
		this.dob = dob;
		this.aadharNumber = aadharNumber;
		this.account = account;
	}

	public void showCustomerDetails(){
		System.out.println("Customer Name: " + name + "\n Account Number: "+ account.getAccountNumber());
	}
}


abstract class Account{
	protected String accountNumber;
	protected double balance;
	protected ArrayList<Transaction> transactions = new ArrayList<Transaction>();

	Account(String accountNumber, double intialBalance){
		this.accountNumber = accountNumber;
		this.balance = intialBalance;
	}
	
	public void deposit(double amount){
		createTransaction("Deposit", amount);
		this.balance += amount;
	}

	public void withdraw(double amount){
		createTransaction("Withdraw", amount);
		this.balance -= amount;
	}

	public void createTransaction(String type, double amount){
		Transaction trans = new Transaction(type, amount);
		transactions.add(trans);
	}

	public void printTransactions(){
		for (int i = 0; i<transactions.size(); i++){
			System.out.println((transactions.get(i)).showTransaction());
		}
	}

	public ArrayList<Transaction> getTransactions(){
		return transactions;
	}

	public double getBalance(){
		return balance;
	}
		
	public void setBalance(double balance){
		this.balance = balance;
	}

	public String getAccountNumber(){
		return accountNumber;
	}

} 

class Transaction{

	private double id = Math.random();
	private LocalDate date = LocalDate.now();
	private String type;
	private double amount;

	Transaction(String type, double amount){
		this.type = type;
		this.amount = amount;
	}

	public String showTransaction(){
		return "Transaction id: " + id + "\nDate : " + date + "\ntype: " + type + "\namount: " + amount;
	}

}

class CurrentAccount extends Account{
	private int overdraftLimit;
	
	CurrentAccount(String accountNumber, double intialBalance, int overdraftLimit){
		super(accountNumber, intialBalance);
		this.overdraftLimit = overdraftLimit;
	}

	public void withdraw(double amount){
		if (getBalance() <= 0 ){
			
			if (overdraftLimit > 0){
				createTransaction("withdraw", amount);
			
				overdraftLimit -= amount;
				System.out.println("ov "+overdraftLimit);
				setBalance(getBalance()-amount);
			}
			else {
				System.out.println("Insufficient Balance");
			}
		}
		else {
			createTransaction("withdraw", amount);
			overdraftLimit -= amount;
			setBalance(getBalance()-amount);
		}
	}
	
	public void createTransaction(String type, double amount){
		super.createTransaction(type, amount);
	}
}

class SavingAccount extends Account{
	float interestRate;

	SavingAccount(String accountNumber, double intialBalance, float interestRate){
		super(accountNumber, intialBalance);
		this.interestRate = interestRate;
	}
	
	public void endOfDayInterest(){
		double interest = (getBalance()*(interestRate/100))/365;
		setBalance(getBalance() + interest);
	}

}

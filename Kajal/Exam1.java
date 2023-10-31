import java.util.ArrayList;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Exam1{
	public static void main(String[] args){
		Customer customer1 = new Customer("XYZ", "12-2-23", "667755443322", SavingAccount);
		Account c = customer1.getSavingAccount();
		c.deposite(13000);
		
		Customer customer2 = new Customer("ABC", "12-2-23", "667755443322", CurrentAccount);
		Account c1 = customer2.getCurrentAccount();
		c1.deposite(13000);
		
		/*
		Account a1 = new SavingAccount("1234566", 40000);
		Account a2 = new CurrentAccount("223345677", 500000);

		a1.withdraw(2000);
		a2.withdraw(2000);

		a1.deposite(1200);
		a2.deposite(5600);

		a1.printTransactions();
		a2.printTransactions();

		*/
	}
}

class Customer{
	String name;
	String dob;
	String aadharNumber;
	private SavingAccount saccount = new SavingAccount("12345678", 12000);
	private CurrentAccount caccount = new CurrentAccount("3457865", 50000);

	Customer(String name, String dob, String aadhar, SavingAccount account){
		this.name=name;
		this.dob = dob;
		this.aadharNumber = aadhar;
		this.saccount = account;
		
	}

	Customer(String name, String dob, String aadhar, CurrentAccount account){
		this.name=name;
		this.dob = dob;
		this.aadharNumber = aadhar;
		this.caccount = account;
		
	}

	public SavingAccount getSavingAccount(){
		return saccount;
	}

	public CurrentAccount getCurrentAccount(){
		return caccount;
	}

}

class Transaction{
	LocalDateTime myDateObj = LocalDateTime.now();
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	Random rand = new Random();
	int randInt = rand.nextInt(100000);
	String formattedDate = myDateObj.format(myFormatObj);
	String type;
	double amount;
	
	Transaction(String type, double amount){
		this.type = type;
		this.amount = amount;
	}    

	public String getTrans(){
		return randInt+"  "+formattedDate+"  "+type+"  "+amount;
	}
}

abstract class Account{
	
	public ArrayList<String> transaction = new ArrayList<String>();
	
	protected String accountNumber;
	double balance;

	Account(String accountNumber,double balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	abstract void deposite(double amount);
	abstract void withdraw(double amount);
	abstract void createTransaction(String type, double amount);

	public void printTransactions(){
		for (int i=0; i<transaction.size(); i++){
			System.out.println(transaction.get(i));
		}
	}
}

class CurrentAccount extends Account{	
	CurrentAccount(String account, double balance){
		super(account, balance);
	}

	public void deposite(double amount){
		Transaction trans = new Transaction("Deposite", amount);
		balance+=amount;
		transaction.add(trans.getTrans());
	}

	public void withdraw(double amount){
		if (amount<=balance+25000){
			balance-=amount;
			Transaction trans = new Transaction("Withdraw", amount);
			transaction.add(trans.getTrans());
		}
		else{
			System.out.println("You don't have sufficient amount");
		}
	}

	public void createTransaction(String type, double amount){
		Transaction trans = new Transaction(type, amount);
		transaction.add(trans.getTrans());
	}

	
}

class SavingAccount extends Account{
	SavingAccount(String account, double balance){
		super(account, balance);
	}

	public double calculateInerest(){
		return (balance*12)/365;
	}

	public void deposite(double amount){
		Transaction trans = new Transaction("Deposite", amount);
		balance+=amount;
		transaction.add(trans.getTrans());
	}

	public void withdraw(double amount){
		if (amount>balance){
			System.out.println("You don't have sufficient amount");
		}
		else{
			balance-=amount;
			Transaction trans = new Transaction("Withdraw", amount);
			transaction.add(trans.getTrans());
		}
	}

	public void createTransaction(String type, double amount){
		Transaction trans = new Transaction(type, amount);
		transaction.add(trans.getTrans());
	}
	
}




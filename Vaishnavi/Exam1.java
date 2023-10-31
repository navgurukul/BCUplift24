





import java.util.*;



class Customer{

	private String name;
	private Date dob;
	private String AadharNo;
	
	public Customer(String name,Date dob,String AadharNo)
	{
	  this.name = name;
	  this.dob = dob ;
	  this.AadharNo = AadharNo;
	
	}

}


class Account{
	private String accountNumber;
	private double balance;
	
	private ArrayList <Transaction> transactionlist = new ArrayList<Transaction>();

	public Account(String accountNumber,double balance)
	{
	 this.accountNumber = accountNumber;
	 this.balance = balance;
	 this.transactionlist = new ArrayList<Transaction>();
	}


	public abstract void deposit(double money);

	public abstract void withdraw(double money)

	public  void createTransaction()
	{
	  transactionlist.add(transaction);
	}
	
	public  void printTransaction()
	{
	  for(Transaction transaction : transactionlist)
	  {
	     System.out.println(transaction);
	   }
	}


}
	



class Transaction{

	private String id;
	private date;
	private String types;
	private amount;	

	Transaction(String id,date,String types,double amount)
	{
	   this.id = id;
	   this.date = date;
	   this.types = types;
	   this.amount = amount;


	}




}


class CurrentAccount extends Account{

	private double overdraftLimit;

	currentAccount(String accountNumber,double overdraftLimit)
	{
	   super(accountNumber,0);
	   this.overdraftLimit = overdraftLimit;
	}

	public void deposit(double money)
	{
	   balance = balance + money;
	   transactionlist.add(new Transaction("Deposit",money));
	}

	public void withdraw(double money)
	{
	     
	      if(money > balance && overdraftLimit > 0)
	      {
		 overdraftLimit = overdraftLimit - money;
                 balance = overdraftLimit ;
	 	
	      }
	      else
	      { 
	        balance = balance - money;
	      }
	  
	    transactionlist.add(new Transaction("withdraw",money));

	}



}




class SavingAccount extends Account{
      
	private double interestRate;

	SavingAccount(String accountNumber,double interestRate)
	{
	    super(accountNumber,balance);
	    this.interestRate = interestRate;
	}

	public void deposit(double money)
	{
	   amount = amount + money;
	 
	}

	public void withdraw(double money)
	{
	  amount = amount - money;
	}


	endOfDayinterest()
	{
	    balance = ((balance*12)/365) + amount ;
	}

}



public class Exam1{

	public static void main(String[] args)

	Customer c1 = new Customer("Vaishnavi",new Date(), "4534523");

	Customer c2 = new Customer("Sayali", new Date(),"35234646");

	CurrentAccount ca = new CurrentAccount("500);
	SavingAccount sa = new SavingAccount(1000);

	ca.deposit(588);
	ca.withdraw(400);
	ca.printTransaction();

	sa.deposit(600);
	sa.withdraw(300);
	sa.printTransactions();


}


import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


class Customer {
	private String name;
	private Date dob;
	private long aadharnumber;
	private long account;
	
	public Customer(String name, date dob,long aadharnumber,long account){
		this.name=name;
		this.dob=dob;
		this.aadharnumber=aadharnumber;
		this.account=account;
	}

}


abstract class Account {
    private long accountNumber;
    protected double balance;
   

    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        
    }

    
    public void deposit(double amount) {
        balance += amount;
        createTransaction("Deposit", amount);
    }

    
    public abstract void withdraw(double amount);

   
    public void createTransaction(String type, double amount) {
        Random rand = new Random();
        long transactionId = rand.nextLong();
       
    }

   
}


class Transcation{
	private int id;
	private Date date;
	private String type;
	private double amount;


	public Transaction(long transactionId, Date date, String type, double amount) {
        	this.id = id;
       		this.date = date;
        	this.type = type;
        	this.amount = amount;
    	}

/*
class CurrentAccount{
	private int overdraftLimit;

}
	public void withdraw(){
		System.out.println(transcations);
	}
	public void createTranscations(){
		System.out.println(transcations)
	}
}




class SavingsAccount{
	private int intrestRate;
}
	public void endOfDayinterest(){
		System.out.println("........");
	}
}


*/
//here we have to inherit the account properties from account class to the chils classes are CurrentAccount,SavingsAccount


class CurrentAccount extends Account{
	private int overdraftLimit;

}
	public void withdraw(){
		System.out.println(transcations);
	}
	public void createTranscations(){
		System.out.println(transcations);
	}
}
	

class SavingsAccount extends Account{
	private int intrestRate;
}
	public void endOfDayinterest(){
		System.out.println("........");
	}
}



class Exam1{
	 public static void main(String[] args) {
       
        SavingsAccount savingsAccount = new SavingsAccount(12345, 100, 0.12);
        savingsAccount.withdraw(50);
        savingsAccount.deposit(20000);
	CurrentAccount currentAccount = new CurrentAccount(123780, 300, 200);
        currentAccount.withdraw(20);
        currentAccount.deposit(10);
	System.out.println(currentAccount.balance);
        System.out.println(currentAccount);
	System.out.println(savingsAccount);
	System.out.println(savingsAccount.balance);
	System.out.println("Savings Account Transactions:");
        

        System.out.println("Current Account Transactions:");
        
    }
}
        
    
}

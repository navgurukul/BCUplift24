import java.lang.Math;
import java.time.LocalDate;
public class Exam1{

public static void main(String[] args){
	Account customer1 = new SavingsAccount("29473924", 2000);
	customer1.deposit(2000);
	customer1.getBalance();
	}


public abstract class Account{

protected String accountNumber;
protected double balance;

public abstract void deposit(int amount);
public abstract void withdraw(int amount);

	Account(String accountNumber, double balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
		}

public double getBalance(){
    return balance;
}

}

public class Customer{

private String name;
private String dob;
private String aadharNumber;
private String account;

	Customer(String name, String dob, String aadharNumber, String account){
	    this.name = name;
	    this.dob = dob;
	    this.aadharNumber = aadharNumber;
	    this.account = account;
	}

}

public class Transaction{

private double id;
private String type;
private String amount;

Transaction(double id, Strubg type, String amount){
	this.id = Math.random();
	this.type = type;
	this.amount = amount;
	}

}

class SavingsAccount extends Account{
    SavingsAccount(String accountNumber, double balance){
	super(accountNumber , balance);
	}
    public void deposit(double amount){
	balance += amount;
	System.out.println("balance now" + balance);
	}
    public void withdraw(double amount){
		if (amount>getBalance()){
		    System.out.println("Amount exceeds balance");
		}
		else{
	    	    balance -= amount;
		    System.out.println("balance now" + balance);
		}
	}
    public double CalculateInterest(){
	double bal = getBalance();
	return ((bal*(0.12))/365);
	}
}

class CurrentAccount extends Account{

    CurrentAccount(String accountNumber, double balance){
	super(accountNumber , balance);
	}
    public void deposit(double amount){
	balance+= amount;
	System.out.println("balance now" + balance);
	}
    public void withdraw(double amount){
		if (amount>getBalance()+25000){
		    System.out.println("Amount exceeds balance");
		}
		else{
	    	    balance -= amount;
		    System.out.println("balance now" + balance);
		}
	}
}
    
}

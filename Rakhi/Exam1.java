
Conversation opened. 1 read message.


Skip to content
Using Gmail with screen readers
5 of 8,567
Exam1
Inbox
import java.lang.Math;
import java.util.Date;
import java.util.ArrayList;

public class Exam1{

	public static void main(String[] args){
		SavingAccount sa=new SavingAccount("1234543",50000,12);
		sa.withdraw(1000);
		sa.deposit(2000);
		sa.createTransaction(3000);
		sa.printTransaction();

	}
}

class Customer{
	String name;
	String DOB;
	private String aadhar_number;
	//Account account=new Account();

	Customer(String name,String DOB,String aadhar_number){
		this.name=name;
		this.DOB=DOB;
		this.aadhar_number=aadhar_number;
	}
}



abstract class Account{
	private String account_number;
	double balance;
	ArrayList<String> transactions;

	Account(String account_no,double balance){
		this.account_number=account_no;
		this.balance=balance;
		this.transactions=new ArrayList<String>();
	}

	public void setAccount_number(String account_no){
		this.account_number=account_no;
	}

	public void setBalance(String account_no){
		this.account_number=account_no;
	}

	public String getAccount_number(){
		return account_number;
	}

	public double getBalance(){
		return balance;
	}

	public double deposit(double depositMoney){
		transactions.add("deposit :"+String.valueOf(depositMoney));
		return balance+=depositMoney;
	}
	public double withdraw(double withdrawMoney){
		if(withdrawMoney<=balance){
			transactions.add("withdraw :"+String.valueOf(withdrawMoney));
			return balance-=withdrawMoney;
		}
		else{
			transactions.add("trying to withdraw insuffecient ammount");
			return balance;
		}
	}
	public double createTransaction(double amount){
		if(getBalance()<=amount){
			transactions.add(String.valueOf(amount)+" shopping transaction");
			return balance-=amount;
		}
		else{
			return balance;
		}
	}
	public void printTransaction(){
		for(int i=0;i<transactions.size();i++){
			System.out.println("Account number "+ getAccount_number());
			System.out.println("Balance "+ getBalance());
			System.out.println(transactions.get(i));
		}
	
	}

}


class CurrentAccount extends Account{
	double overdraftLimit;

	CurrentAccount(String account_no,double balance,double overdraftLimit){
		super(account_no,balance);
		this.overdraftLimit=overdraftLimit;
	}
	
	public double withdraw(double withdrawMoney){
		if(withdrawMoney<=(getBalance()+overdraftLimit)){
			transactions.add("withdraw :"+String.valueOf(withdrawMoney));
			return balance-=withdrawMoney;
		}
		else{
			transactions.add("trying to withdraw insuffecient ammount");
			return balance;
		}
	}


}

class SavingAccount extends Account{
	int interestRate;

	SavingAccount(String account_no,double balance,int interestRate){
		super(account_no,balance);
		this.interestRate=interestRate;
	}

	public double endOfDayInterest(){
		return (getBalance()*interestRate)/365;
	}
}


class Transaction{
	double id=Math.random();
	Date date=new Date();
	
}

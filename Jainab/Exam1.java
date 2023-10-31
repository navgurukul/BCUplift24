import java.util.ArrayList;

public class Exam1{
	public static void main(String [] args){
		Account a1=new Account();
		A1.createTransaction(transactions);
		Customer c1=new Customer();
		
		
	
	}

}
class Customer{
	private String name;
	private int dob;
	private int adhaarNumber;
	private account Account;
	
	
}
class Account{
	private int accountNumber;
	private double balance;
	ArrayList<String> transactions= new ArrayList<String>();

	void deposit(){

	}
	void withdaw(){

	}
	void createTransaction(){

	}
	void printTransactions(){

	}
}
class Transaction{
	int id;
	int date;
	String type;
	int amount;

}
class CurrentAccount extends Account{
	int overdraftLimit;

	void withdraw(){

	}
	void createTransaction(){

	}

}
class SavingAccount{
	int interestRate;
	void endOfDayinterest(){

	}


}



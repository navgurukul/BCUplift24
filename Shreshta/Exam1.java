import java.util.ArrayList;
import java.util.List
import java.util.Random;

abstract class Account{
	private String accountNumber;
	private long balance;
	private List<Transaction> transactionList;

	public Account(String accountNumber, long balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.transactionList = new ArrayList<>();
	}

	public void deposit(long amount);

	public void withdraw(long amount);

	public void createTransaction(String description, long amount, TransactionType) {
    }
	
	public void printTransactions() {
        System.out.println(accountNumber);
        for (Transaction transaction : transactionList) {
            System.out.println(transaction);
        }
}

	private int id(){
		return new Random.nextInt(100);
	}
	public long balance(){
		return balance;
	}
	public String getAccountNumber(){
		return accountNumber;
	}
}	

class Customer{
	String name;
	String dob ;
	int aadharNumber;
	int account;
	Customer(String name,String dob,int aadharNumber){
		name = name;
		dob = dob;
		aadharNumber = aadharNumber;
	}
}


class Transaction{
	private int id;
	private String data;
	private String type;
	private long amount;
	public Transaction(int id, String data,String type,long amount){
		this.id = id;
		this.data = data;
		this.type = type;
		this.amount = amount;
	}
	public static List<object> getDetails(){
		return Arrays.asList(id,data,type,amount);
	}
}

 /*   public static void main(String[] args) 
    { 
        List<Object> person = getDetails(); 
        System.out.println(person); 
    } 
}*/

class CurrentAccount extends Account{
	long overdraftLimit;
	public void withdraw(long amount){
	}
	public void createTransaction(long amount){
	}
}
class SavingAccount extends Account{
	private long interestRate;
	void endOfDayInterest(){		
	}
}

public class Exam1{
	public static void main(String[] args){
	
	}
}

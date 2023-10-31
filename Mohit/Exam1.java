import java.util.*;
public class Exam1{
	public static void main(String[] args){
		SavingsAccount savingsAccount = new SavingsAccount("1001", 0.12);
        	CurrentAccount currentAccount = new CurrentAccount("2001", 25000);

        	savingsAccount.deposit(100000);
        	savingsAccount.withdraw(5000);
        	savingsAccount.interst_on_saving_account();
		System.out.println("Savings Account Balance: " + savingsAccount.balance);

        	System.out.println("Current Account Balance: " + currentAccount.balance);
        	System.out.println("Current Account Overdraft Limit: " + currentAccount.getOverdraftlimit());
        

	}
}






abstacts class account{
	private String accountnumber;
	private double balance;

	public account(String accountNumber, double balance){
		this.accountnumber=accountNumber;
		this.balance=Balance;
	}
	public void Deposite(double amount){
		if (amount>0){
			balance=balance+amount;
			System.out.print("amount deposited");
		}
		else{
			System.out.println("have to deposite");
		}
			
	}
	public void Withdraw(Double withdrawAmount){
		if (balance>=withdrawAmount){
			balance=balance-withdrawAmount;
			System.out.println("Amount withdraw");
		}
		else{
			System.out.println("Do not have sufficient Balance");
		}
	}
	

}


class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountnumber, double interestRate) {
        super(accountnumber);
        this.interestRate = interestRate;
    }

  
    public void interst_on_saving_account() {
        double dailyInterest = (balance * interestRate) / 365;
        balance += dailyInterest;
    }
}

class CurrentAccount extends Account {
    private double overdraftlimit;

    public CurrentAccount(String accountnumber, double overdraftlimit) {
        super(accountnumber);
        this.overdraftLimit = overdraftlimit;
    }



  
    
}



class customer{
	private String customername;
	private String dateofbirth;
	private String adharnumber;

	public customer(String customername,String dateofbirth,String adharnumber){
		this.customername=customername;
		this.dateofbirth=dateofbirth;
		this.adharnumber=adharnumber;
	}

	public String getcustomername(){
		return customername;
	}

	public String getcustomername(){
		return customername;
	}
	public String getdateofbirth(){
		return dateofbirth;
	}

	public String getadharnumber(){
		return adharnumber;
	}



	

}


class Transaction {
	private int transactionId;
    	private Date date;
    	private String type;
    	private double amount;

   	public Transaction(int transactionId, Date date, String type, double amount) {
        	this.transactionId = transactionId;
        	this.date = date;
        	this.type = type;
        	this.amount = amount;
    }
	public void displayTransaction() {
        	System.out.println("Transaction ID: " + transactionId);
        	System.out.println("Date: " + date);
        	System.out.println("Type: " + type);
        	System.out.println("Amount: " + amount);
    }
	
}

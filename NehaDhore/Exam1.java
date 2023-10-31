import java.util.*;


public class Account{
	
	private String accountNumber;
	Private double balance;
	Private List<String> transactions;

	 public void Account(String accountNumber,double amount) {
       
            this.accountNumber = accountNumber;
	    this.balance = initialBalance;
	    this.transactions = new ArrayList<>();
   	 }

	public void depodit(double amount){
	if(amount > 0){
		balance += amount;
		transaction.add(Deposit: "+ amount);
	}
}

	public void withdraw(double amount){
	if(amount > 0 && amount <= balance){
	balance -= amount;
	transaction.add("Withdraw: "+ amount);
}
}
	public void printTransaction(){
		System.out.println("Transaction:");

	for(String transaction : transactions){
	System.out.println(transaction);
}
}

	
}
public class CurrentAccount extends Account{
	private double overdraftLimit;
	
	public CurrentAccount(String accountNumber, double initialBalance, double overdraftLimit){
	super(accountNumber, initialBalance);
	this.overdraftLimit = overdraftLimit;
}

	public void withdraw(double amount){
	if(amount > 0 && (balance + overdraftLimit)>= amount){
	balance-= amount;
	transactions.add("withdraw : -" +amount);
}
	}
	
}
public class SavingAccount extends Account{
	private double interestRate;

	public SavingAccount(String accountNumber , double balance, double interestRate){
	super(accountNumber, balance);
	this.interestRate = interestRate;
 	}

	public void endOfDayInterest(double amount){
		public double r;
		r = (balance*12)/365;
		balance += r;
		transactions.add("Interest : " + r);	
	}
}

public class Transaction{
	private Date date;
	private double amount;
	private int id;

	public Transaction(double amount){
		this.date = new Date();
		this.amount = amount;
		this.id = generateID();
	}

	private int generateID(){
		Random random = new Random();
		return random.nextInt(100);
	}
	public Date getDate(){
		return date;
	}

	public double getAmount(){
		return amount;
	}

	public int getID(){
		return id;
	}

	public String toString(){
		return "Transaction ID: " + id + "\nDate" + date + "\nAmount: "+ amount;
	}
}

public class Exam1{
	 private String name;
   	 private Date dob;
   	 private String aadharNumber;
   	 private String accountNumber;

public Exam1(String name, Date dob, String aadharNumber, String accountNumber){
	 this.name = name;
         this.dob = dob;
         this.aadharNumber = aadharNumber;
         this.accountNumber = accountNumber;
}
	public String getName() {
        return name;
    }

	public Date getDob() {
        return dob;
    }

	public String getAadharNumber() {
        return aadharNumber;
    }

	public String getAccountNumber() {
        return accountNumber;
    }


public static void main(String[] args) {
        Date dob = new Date(2000 - 1900, 10, 15);
        Exam1 exam1 = new Exam1("John Doe", dob, "1234567890", "AC12345");

        System.out.println("Customer Information:");
        System.out.println("Name: " + exam1.getName());
        System.out.println("Date of Birth: " + exam1.getDob());
        System.out.println("Aadhar Number: " + exam1.getAadharNumber());
        System.out.println("Account Number: " + exam1.getAccountNumber());
    

}

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

class Customer {
    private String name;
    private String dob;
    private int aadharNumber;
    
    public Customer(String name, String dob, int aadharNumber) {
        this.name = name;
        this.dob = dob;
        this.aadharNumber = aadharNumber;
    }
        
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getdob(){
        return dob;
    }
    public void setdob(String dob) {
        this.dob = dob;
    }
    public int getAadharNumber(){
        return aadharNumber;
    }
    public void setAadharNumber(int aadharNumber) {
        this.aadharNumber = aadharNumber;
    }
}

class Transaction{
     private int id;
     private Date date;
     private String type;
     private double amount;

     public Transaction(Date date,String type, double amount) {
          this.date = date;
          this.type = type;
          this.amount = amount;
     }

     private int RandomId() {
        Random random = new Random();
        return random.nextInt(1000);
    }
    
}

abstract class Account{
    private String accountNumber;
    private double balance;
    ArrayList<Transaction>transactions = new ArrayList<>();

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }
  
    abstract void deposit(double amount);
    abstract void withdraw(double amount);
    protected void createTransaction(String type,double amount){
        Transaction transaction = new Transaction(new Date(),type,amount);
        transactions.add(transaction);
    }
    public void printTransactions() {
        for (Transaction transaction: transactions) {
           System.out.println(transaction);
        }
    }
}

class CurrentAccount extends Account{
    

    void deposit(Account amount) {
        getBalance()  = getBalance() + amount;
        createTransaction("Deposit",amount);
    }
    void withdraw(double account) {
        if (getBalance()-amount>=(-25000)) {
            getBalance() = getBalance() - amount;
            createTransaction("withdraw",amount);
        }
        else{
            System.out.println("You can't withdraw");
        }
    }


}
class SavingAccount extends Account{
    
    void deposit(double amount) {
        getBalance() = getBalance()+amount;
        createTransaction("Deposit",amount);
        if (getBalance()>100000) {
           double interest = (balance*0.12)/365;
           getBalance+= interest;
           createTransaction("Interest",interest);
        }
    }
   
    void withdraw(double amount) {
        getBalance() = getBalance()-amount;
        createTransaction("withdraw",amount);
    }
    
}

public class Exam1
{
	public static void main(String[] args) {
		CurrentAccount a1 = new CurrentAccount("123455",23000);
		a1.deposit(10000);
		a1.printTransactions();
		
	}
}


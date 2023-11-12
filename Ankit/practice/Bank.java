import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException ;


public class Bank{
    public static void main(String[] args )throws ParseException{
        // Create a SimpleDateFormat with the desired format pattern
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Get the current date
        Date currentDate = new Date();

        // Format the date
        String formattedDate = sdf.format(currentDate);

        CurrentAccount ex1 = new CurrentAccount("214201006789", 1000, 25000) ;
        Customer c1 = new Customer("ankit",sdf.parse("27/08/2003"),"1111 4444 3223 ",ex1) ;

        SavingAccount ex2 = new SavingAccount("45678456783", 2000, 1.0) ;
        Customer c2 = new Customer("mohit",sdf.parse("04/11/2003"),"5565 7767 8888",ex2) ;
        ex1.createTransaction(formattedDate, 500);
        ex1.printTransaction();
        System.out.println("an example of overdraft withdraw : "+ ex1.withdraw(2000));

        System.out.println("Closing balance is:"+ ex2.endOfDayBalance(ex2.getBalance(),1.0));
        c1.printCustomerDetails() ;
        c2.printCustomerDetails();

    }
}

abstract class Account{
    private String accountNumber ;
    private double balance ;
    ArrayList<Transaction>transactions = new ArrayList<Transaction>() ;

    public double getBalance(){
        return balance ;
    }
    Account(String accountNumber , double balance){
        this.accountNumber = accountNumber ;
        this.balance = balance ;
    }
    boolean deposit(double amount){
        balance+=amount ;
        createTransaction(Transaction.CREDIT, amount) ;
        return true ;
    }
    boolean withdraw(double amount){
        if (amount<=balance){
            balance-=amount ;
            createTransaction(Transaction.DEBIT,amount);
            return true ;
        }
        else{
            return false;
        }
        
    }
    Transaction createTransaction(String type, double balance){
        Transaction entry = new Transaction(type, balance) ;
        transactions.add(entry) ;
        return entry ;
             
    }
    void printTransaction(){
        for(int i= 0 ; i<transactions.size() ; i++){
            System.out.println(transactions.get(i));
        }
    }
    public String toString(){
        return accountNumber ;
    }
}

class CurrentAccount extends Account{
    double overdraftLimit;

    CurrentAccount(String accountNumber ,double balance ,  double overdraftLimit){
        super(accountNumber,balance) ;
        this.overdraftLimit = overdraftLimit ;
    }

    @Override
    boolean withdraw(double amount){
        double getbal = getBalance() ;
        if (amount<=getbal+overdraftLimit){
            getbal-=amount ;
            Transaction entry = createTransaction(Transaction.DEBIT,amount) ;
            transactions.add(entry) ;
            return true ;
        }
        else{
            return false ;
        }
    }
    @Override
    Transaction createTransaction(String type, double balance){
        Transaction entry = new Transaction(type, balance) ;
        transactions.add(entry) ;
        return entry ;
    }
}
class SavingAccount extends Account{
    double interestRate;
    double tempbal = getBalance() ;
    
    SavingAccount(String accountNumber , double balance , double interestRate){
        super(accountNumber,balance);
        this.interestRate = interestRate ;
    }

    double endOfDayBalance(double tempbal,double interestRate){
        double closingBalance = tempbal+tempbal*interestRate/100 ;
        return closingBalance ;

    }
}
class Customer{
    String name;
    Date dob ;
    String aadharNumber ;
    Account account ;

    Customer(String name,Date dob , String aadharNumber , Account account ){
        this.name= name;
        this.dob= dob ;
        this.aadharNumber = aadharNumber ;
        this.account = account ;
    }

    @Override 
    public String toString(){
        StringBuilder customerDetails = new StringBuilder("Name:" + name + " Dob:"+dob +" AAdhar: "+ aadharNumber +" AccountNum:"+ account) ;
        return customerDetails.toString() ;
    }
    public void printCustomerDetails(){
        System.out.println(this);

    }
}
class Transaction{
    int id ;
    Date date;
    String type;
    double amount ;

    public static final String CREDIT = "credit" ;
    public static final String DEBIT = "debit" ;

    Transaction(String type , double amount ){
        Random num = new Random();
        this.id = num.nextInt() ;
        this.date = new Date() ;
        this.type = type ;
        this.amount = amount ;
    }

    public String toString(){
        StringBuilder passbook = new StringBuilder("Id:"+id + " Date of Transaction: "+date +" Type of Transaction: "+ type + " amount: "+amount ) ;
        return passbook.toString() ;

    }
}

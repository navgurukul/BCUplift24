import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {

	//please comment off these line one by one to check the example..

        /*CurrentAccount customer1 = new CurrentAccount("1234567890", 0 , 25000);
        customer1.withdraw();*/

        /*SavingAccount customer2 = new SavingAccount("1234567890", 1000,10);
        customer2.deposit();
        customer2.endOfDayInterest();*/

    }

    public abstract static class Account {
        String accountNumber;
        double balance;
        Transaction transactions;

        Account(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public void deposit() {
            System.out.println("Enter the amount to Deposit: ");
            Scanner sc = new Scanner(System.in);
            double amount = sc.nextDouble();
            balance += amount;
            System.out.println("Amount deposited.");
            sc.close();
        }

        public void withdraw() {
            System.out.println("Enter the amount to Withdraw: ");
            Scanner sc = new Scanner(System.in);
            double amount = sc.nextDouble();
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Amount withdrawn.");
            } else {
                System.out.println("Insufficient balance.");
            }
            sc.close();
        }

        public void createTransaction() {
        }

        public void printTransaction() {
        }
    }

    public static class CurrentAccount extends Account {
        double overdraftLimit ;

        CurrentAccount(String accountNumber, double balance , double overdraftLimit) {
            super(accountNumber, balance);
            this.overdraftLimit = overdraftLimit;
        }
        public void withdraw() {
            System.out.println("Enter the amount to Withdraw from limit: ");
            Scanner sc = new Scanner(System.in);
            double amount = sc.nextDouble();
            if (amount <= overdraftLimit) {
                balance -= amount;
                System.out.println("Amount withdrawn.");
            } else {
                System.out.println("Insufficient balance., you exceeded the overdraft limit");
            }
            sc.close();
        }

        public void createTransaction() {
        }
    }

    static class SavingAccount extends Account {
        int interestRate;

        SavingAccount(String accountNumber, double balance, int interestRate) {
            super(accountNumber, balance);
            this.interestRate = interestRate;
        }

        public void endOfDayInterest() {
            double interest = balance * interestRate / 365;
            System.out.println("Received Interest: "+" "+interest) ;
        }
    }

    static class Customer {
        String name;
        String dob;
        String aadharNumber;
        Account account;
        Customer(String name, String dob, String aadharNumber, Account account){
            this.name = name ;
            this.dob= dob ;
            this.aadharNumber = aadharNumber ;
            this.account = account ;
            System.out.println("Account created successfully..") ;

        }
    }

    static class Transaction {
        int id;
        String date;
        String type;
        double amount;
    }
}


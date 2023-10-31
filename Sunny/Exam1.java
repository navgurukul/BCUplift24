
import java.util.*;

import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class Exam1 {
    public static void main(String[] args) {
        Exam1.Savings_Account customer1 = new Exam1().new Savings_Account();
        customer1.withdraw(0);

		Exam1.Current_Account customer2 = new Exam1().new Current_Account();
		customer2.withdraw(10000);
		customer2.getAccountNumber();
		customer2.getBalance();

	}


	class Transaction{
		private int Transaction_id;
		private Date date;
		private int amount;



		Transaction(Date date,int amount){
			Random Temp = new Random();
			int var = MAth.abs(temp.nextInt(100));
			this.Transaction_id = var;
			this.amount = amount;
			this.date = date;
		}


	}





    class Customer {
        private String customerName;
        private Date dateOfBirth;
        private final int aadharNumber;
		private List<Transaction> transactionlist;

        public Customer(String name, Date dateOfBirth, int aadharNumber){
            this.aadharNumber = aadharNumber;
            this.customerName = name;
            this.dateOfBirth = dateOfBirth;
			this.transactionlist = new ArrayList<>();
        }
    }

    abstract class Account {
        private double balance;
        private String accountNumber;

        Account(){
            this.balance = 0.0;
            Random a = new Random();
            int temp = Math.abs(a.nextInt() * 100);
            this.accountNumber = Integer.toString(temp);
        }

        public void deposit(int userAmount){                               //deposit method
            if(userAmount > 0){
                balance = balance + userAmount;
            } else {
                System.out.println("Invalid deposit amount");
            }
        }

        public abstract void withdraw(int withdrawAmount);
        
        public double getBalance() {                                    //returns balance variable access
            return balance;
        }

        public void getAccountNumber() {                              //return account number
			System.out.println(accountNumber);
		}
    }

    class Current_Account extends Account {
        @Override
        public void withdraw(int withdrawAmount) {
            if(withdrawAmount > 0 && withdrawAmount <= getBalance() + 25000){
                System.out.println("Rs " + withdrawAmount + " Withdrawal Successful.");
            } else {
                System.out.println("Invalid Amount!");
            }
        }
    }

    class Savings_Account extends Account {
        @Override
        public void withdraw(int withdrawAmount) {
            if(withdrawAmount > 0 && withdrawAmount <= getBalance()){
                System.out.println("Rs " + withdrawAmount + " Money Withdrawal Successful.");
            } else {
                System.out.println("Invalid Amount!");
            }
        }
    }
}


package org.uplift;

import org.uplift.account.SavingAccount;
import org.uplift.bank.TransactionManagement;
import org.uplift.exception.InvalidSufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        User user=new User("name1","2345367","email1.com","username1","1231");
        User user1=new User("name2","3424556","gmail.com","username2","2345");
        SavingAccount sa=new SavingAccount(user,"2345678",45000,new Date(),500.0);
        SavingAccount ta=new SavingAccount(user1,"67659765",5000.0,new Date(),300.0);
        TransactionManagement tm=new TransactionManagement();
        boolean ts=user.isValid();
        boolean flag=true;
        while(flag){
            if(ts) {
                System.out.println("Welcome ");
                System.out.println("Choose an option:");
                System.out.println("1. Show Balance");
                System.out.println("2,Transaction");
                System.out.println("3,Exit");
                Scanner s = new Scanner(System.in);
                int choice = s.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Account balance " + sa.showBalance());

                    case 2:
                        try {
                            tm.transfer(sa, ta, 1000);
                        } catch (InvalidSufficientBalanceException e) {
                            System.out.println(e.getMessage());
                        }
                    case 3:
                        System.out.println("thankyou");
                        flag=false;

                }
            }



        }
    }
}
package org.uplift;

import org.uplift.account.SavingAccount;
import org.uplift.bank.TransactionManager;
import org.uplift.exception.InSufficientBalanceException;
import org.uplift.user.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

        User user1=new User("Mohit","98765432","mohit22@gmail.com","mohitraj","12");
        User user2=new User("Rohit","92765432","rohit22@gmail.com","rohtitraj","13");
        SavingAccount s1=new SavingAccount(user1,20000,"321",sdf.parse("17/04/2023"),1000);
        SavingAccount s2=new SavingAccount(user2,20000,"311",sdf.parse("17/04/2023"),500);



        TransactionManager tm=new TransactionManager();
        try{
            tm.verifyTransaction(s1,s2,2000);
            System.out.println("Transaction complete");
        }
        catch (InSufficientBalanceException e){
            System.out.println(e.getMessage());
        }




    }
}
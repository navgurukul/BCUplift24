/*package org.uplift.userInterface;

import org.uplift.account.Transaction;
import org.uplift.bankpackage.TransactionManager;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private TransactionManager transactionManager;
    private Transaction transaction;

    public UserInterface(Scanner scanner,TransactionManager transactionManager,Transaction transaction) {
        this.scanner = scanner;
        this.transactionManager = transactionManager;
        this.transaction = transaction;


    }

    public Account login(int accountNumber, String password) {
        if (accountsMap.containsKey(accountNumber)) {
            Account account = accountsMap.get(accountNumber);
            if (account.checkCredentials(account.getUsername(), password)) {
                return account;
            }
        }
        return null;
    }

    public void start(){
        int choice;
        do {
            System.out.println("Welcome to the Banking System");
            System.out.println("1. Balance Check");
            System.out.println("2. Fund Transfer");
            System.out.println("3. Update mobile");
            System.out.println("4. Update Address");
            System.out.println("5. Transaction Statement");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:


            }
        }

}*/

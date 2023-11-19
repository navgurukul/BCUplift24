//package org.customerDetails.customerManagement;

import org.customerDetails.Customer;
import org.customerDetails.Identity;
import org.customerDetails.customerManagement.CustomerManagementSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import java.util.HashMap;
import java.util.Map;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try{
            ArrayList<Customer> customers = new ArrayList<>();
            Identity identity1 = new Identity("1AAA23456", "67896543221");
            Identity identity2 = new Identity("9RJY453","654278");
            Identity identity3 = new Identity("R67892SS","75433DEF");
            Identity identity4 = new Identity("98765RRR","798765433");
            Identity identity5 = new Identity("98765RRR","798765433");
            Identity identity6 = new Identity("98765RRR","798765433");

            Map<String, Double> assets1 = new HashMap<>();
            assets1.put("Building", 5000000.0);
            assets1.put("Investments", 2000000.0);
            assets1.put("Building", 5000000.0);
            assets1.put("Stock", 15000000.0);

            Map<String, Double> assets2 = new HashMap<>();
            assets2.put("Savings", 7000000.0);
            assets2.put("Investments", 1000000.0);
            assets2.put("Shares", 10000000.0);
            assets2.put("Car", 4000000.0);
            assets2.put("Land", 10000000.0);

            Map<String, Double> assets3 = new HashMap<>();
            assets3.put("Savings", 25000000.0);
            assets3.put("Investments", 200000000.0);
            assets3.put("Stocks", 6000000.0);
            assets3.put("Building", 7800000.0);

            Map<String, Double> assets4 = new HashMap<>();
            assets4.put("Savings", 450000.0);
            assets4.put("Investments", 20000.0);
            assets4.put("Land", 20000000.0);
            assets4.put("Stocks", 65000000.0);

            Map<String, Double> assets5 = new HashMap<>();
            assets5.put("Savings", 75500000.0);
            assets5.put("Investments", 4120000.0);

            Map<String, Double> assets6 = new HashMap<>();
            assets6.put("Savings", 650000.0);
            assets6.put("Investments", 220000.0);
            assets6.put("Building", 6200000.0);


            Map<String, Double> liabilities1 = new HashMap<>();
            liabilities1.put("Loans", 10000.0);
            liabilities1.put("CreditCard", 5000.0);

            Map<String, Double> liabilities2 = new HashMap<>();
            liabilities2.put("Loans", 1000000.0);
            liabilities2.put("CreditCard", 5000.0);

            Map<String, Double> liabilities3 = new HashMap<>();
            liabilities3.put("Loans", 10000.0);
            liabilities3.put("CreditCard", 5000.0);

            Map<String, Double> liabilities4 = new HashMap<>();
            liabilities4.put("Loans", 10000.0);
            liabilities4.put("CreditCard", 5000.0);

            Map<String, Double> liabilities5 = new HashMap<>();
            liabilities5.put("Loans", 10000.0);
            liabilities5.put("CreditCard", 5000.0);

            Map<String, Double> liabilities6 = new HashMap<>();
            liabilities6.put("Loans", 10000.0);
            liabilities6.put("CreditCard", 5000.0);

            customers.add(new Customer("Sunny", identity1, assets1, liabilities1, sdf.parse("12-07-2020")));
            customers.add(new Customer("Sonam", identity2, assets2, liabilities2,sdf.parse ("02-04-2019")));
            customers.add(new Customer("Mohit", identity3, assets3, liabilities3, sdf.parse("12-05-2022")));
            customers.add(new Customer("Akit", identity4, assets4, liabilities4,sdf.parse ("18-08-2023")));
            customers.add(new Customer("Sree", identity5, assets5, liabilities5,sdf.parse ("22-09-2021")));
            customers.add(new Customer("Priti", identity6, assets6, liabilities6,sdf.parse ("21-01-2023")));

            CustomerManagementSystem cms = new CustomerManagementSystem(customers);

            TreeSet<Customer> wealthManagerEligible = cms.getEligibleForWealthManager();
            TreeSet<Customer> bankCustomers = cms.getBankCustomers();
            for (Customer customer : wealthManagerEligible) {
                System.out.println(customer.getName() + " is eligible for wealth manager services.");
            }
            for (Customer customer : bankCustomers) {
                System.out.println(customer.getName() + ", Welcome to our bank!");
            }
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
    }
}
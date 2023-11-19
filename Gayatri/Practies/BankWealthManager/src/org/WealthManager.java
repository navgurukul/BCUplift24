package org;

import java.security.Identity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;

public class WealthManager {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();

        Identity I1 = new Identity("5678", "AB23");
        Map<String, Double> assets1 = new HashMap<>();
        assets1.put("Home", 500000000.0);
        assets1.put("Car",  600000000.0);
        Map<String, Double> liabilities1 = new HashMap<>();
        liabilities1.put("Loan", 7000000.0);
        Customer c1 = new Customer("Gayatri", LocalDate.of(2023, 5, 15), I1, assets1, liabilities1);
        customers.add(c1);

        Identity I2 = new Identity("9876", "XY09");
        Map<String, Double> assets2 = new HashMap<>();
        assets2.put("Farm", 800000000.0);
        assets2.put("Stocks", 200000000.0);
        Map<String, Double> liabilities2 = new HashMap<>();
        liabilities2.put("Loan", 10000000.0);
        Customer c2 = new Customer("Janhvi", LocalDate.of(2022, 1, 23), I2, assets2, liabilities2);
        customers.add(c2);

        Identity I3 = new Identity("4567", "CD56");
        Map<String, Double> assets3 = new HashMap<>();
        assets3.put("Business", 50000.0);
        assets3.put("Stocks",800000.0);
        Map<String, Double> liabilities3 = new HashMap<>();
        liabilities3.put("Loan", 80000.0);
        Customer c3 = new Customer("John", LocalDate.of(2021, 5, 15), I3, assets3, liabilities3);
        customers.add(c3);

        Identity I4 = new Identity("1234", "CA56");
        Map<String, Double> assets4 = new HashMap<>();
        assets4.put("Business", 500000000.0);
        assets4.put("Home", 600000000.0);
        Map<String, Double> liabilities4 = new HashMap<>();
        liabilities4.put("Loan", 7000000.0);
        Customer c4 = new Customer("Aniket", LocalDate.of(2023, 3, 10), I4, assets4, liabilities4);
        customers.add(c4);

        Bank bank = new Bank();

        SortedSet<Customer> wealthyPeople = bank.getWealthyCustomers(customers);


        for (Customer i : wealthyPeople) {
            try {
                System.out.println(i.getName()+ " You are selected your networth is :"  + i.calculateNetWorth());
            } catch (InvalidNetWorthException e) {
                System.out.println(i.getName()+e.getMessage());
            }
        }
    }
}

package org;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Bank {
    public SortedSet<Customer> getWealthyCustomers(List<Customer> customers) {
        SortedSet<Customer> wealthyPeople = new TreeSet<>();
        for (Customer customer : customers) {
            try {
                double nw = customer.calculateNetWorth();
                if (nw > 100000000) {
                    wealthyPeople.add(customer);
                    System.out.println("Welcome " + customer.getName() + ", Net Worth is " + nw);
                }
            } catch (InvalidNetWorthException e) {
                System.out.println(customer.getName()+" "+e.getMessage());
            }
        }
        return wealthyPeople;
    }
}

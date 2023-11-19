package org.wealth.manager;
import org.exceptions.NotEligibleForWMServices;
import org.wealthmanager.customer.Customer;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class WealthManager {
    private SortedSet <Customer> customerSortedSet;
    private ArrayList<Customer> allCustomers = new ArrayList<Customer>();
    public WealthManager(){
        this.customerSortedSet = new TreeSet<>();
    }

    public void addCustomerToWM(Customer c) throws Exception {
        allCustomers.add(c);
        double netWorth = c.getAssets()-c.getLiabilities();
        if (netWorth<100000000){
            throw new NotEligibleForWMServices();
        }
        else{
            customerSortedSet.add(c);
        }
    }

    public SortedSet <Customer> showWealthgetCustomers(){
        System.out.println("Welcome to in Our Wealth Manager Service");
        return customerSortedSet;
    }

    public ArrayList<Customer> getAllCustomers(){
        return allCustomers;
    }
}

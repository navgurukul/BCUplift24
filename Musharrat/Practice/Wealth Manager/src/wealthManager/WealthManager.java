package wealthManager;

import customer.Customer;
import exceptionHandling.NotEligibleForWMServicesException;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class WealthManager{
    SortedSet<Customer> wealthManagement = new TreeSet<>();
    ArrayList<Customer> allCust = new ArrayList<Customer>();

    public void addCustomerToWealthManagement(Customer c) throws NotEligibleForWMServicesException {
        allCust.add(c);
        double netWorth = c.getTotalAssets() - c.getTotalLiabilities();
        if (netWorth > 100000000){
            wealthManagement.add(c);
            System.out.println(c.getName()+" added for wealth management services. ");
        }
        else {
            throw new NotEligibleForWMServicesException(c.getName() + " Sorry :( You are not eligible for this Service ");
        }
    }

    public SortedSet<Customer> getWealthManagement() {
        return wealthManagement;
    }

    public ArrayList<Customer> getAllCust() {
        return allCust;
    }
}

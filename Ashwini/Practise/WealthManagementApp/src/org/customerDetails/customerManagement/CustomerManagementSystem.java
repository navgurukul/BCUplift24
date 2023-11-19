package org.customerDetails.customerManagement;

import org.customerDetails.Customer;

import java.util.*;

public class CustomerManagementSystem {
    private TreeSet<Customer> eligibleForWealthManager;
    private TreeSet<Customer> bankCustomers;

    public CustomerManagementSystem(ArrayList<Customer> customers) {
        eligibleForWealthManager = new TreeSet<>();
        bankCustomers = new TreeSet<>();

        for (Customer customer : customers) {
            double netWorth = customer.calculateNetWorth();

            if (netWorth > 10000000) {
                bankCustomers.add(customer);
            } else if (netWorth > 100000) {
                eligibleForWealthManager.add(customer);
            }
        }
    }

    public TreeSet<Customer> getEligibleForWealthManager() {
        return eligibleForWealthManager;
    }

    public TreeSet<Customer> getBankCustomers() {
        return bankCustomers;
    }

}

package org.uplift.wealthmanager;

import java.util.*;

public class Register {
    public SortedSet<Customer> customerSet=new TreeSet<Customer>();


    public void checkEligibility(Customer c) throws NotEligibleException {
        if(c.calculateNetworth()>100000000){
            customerSet.add(c);
            System.out.println("Welcome "+c);
        }
        else{
            throw new NotEligibleException(c+" You are not eligible ");
        }
    }

}

package org;

import java.security.Identity;
import java.time.LocalDate;
import java.util.Map;

public class Customer {
    private String name;
    private LocalDate accountDate;
    private Identity identity;
    private Map<String,Double> assest;
    private Map<String,Double> liabilities;
    public Customer(String name, LocalDate accountDate, Identity identity, Map<String, Double> assets,
                    Map<String, Double> liabilities) {
        this.name = name;
        this.accountDate = accountDate;
        this.identity = identity;
        this.assest = assets;
        this.liabilities = liabilities;
    }
    public String getName() {
        return name;
    }

    public LocalDate getAccountDate() {
        return accountDate;
    }
    public double calculateNetWorth() throws InvalidNetWorthException {
        double t1 = 0.0;
        for (double a :assest.values()) {
            t1 += a;
        }

        double t2 = 0.0;
        for (double l : liabilities.values()) {
            t2 += l;
        }

        double nw = t1 - t2;
        if (nw < 1000000000) {
            throw new InvalidNetWorthException("Not eligible for wealth management");
        }

        return nw;
    }
    public int compareTo(Customer obj) {
        try {
            double diff = Double.compare(this.calculateNetWorth(), obj.calculateNetWorth());
            if (diff == 0) {
                return this.accountDate.compareTo(obj.accountDate);
            }
            return (int) diff;
        } catch (InvalidNetWorthException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}


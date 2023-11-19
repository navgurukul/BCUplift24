package org.customerDetails;
import java.util.Date;
import java.util.Map;

public class Customer implements Comparable<StudentScore> {
    private String name;
    private Identity identity;
    private Map<String, Double> assets;
    private Map<String, Double> liabilities;
    private Date accountDate;

    public Customer(String name, Identity identity, Map<String, Double> assets, Map<String, Double> liabilities, Date accountDate) {
        this.name = name;
        this.identity = identity;
        this.assets = assets;
        this.liabilities = liabilities;
        this.accountDate = accountDate;
    }

    public double calculateNetWorth() {
        double totalAssets = 0.0;
        double totalLiabilities = 0.0;

        for (double assetValue : assets.values()) {
            totalAssets += assetValue;
        }

        for (double liabilityValue : liabilities.values()) {
            totalLiabilities += liabilityValue;
        }

        return totalAssets - totalLiabilities;
    }
    public Date getAccountDate() {
        return accountDate;
    }
    public String getName(){
        return name;
    }

    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", identity=" + identity +
                ", assets=" + assets +
                ", liabilities=" + liabilities +
                ", accountDate='" + accountDate + '\'' +
                '}';
    }

    public int compareTo(Customer otherCustomer) {
        int netWorthComparison = Double.compare(this.calculateNetWorth(), otherCustomer.calculateNetWorth());

        if (netWorthComparison == 0) {
            return this.getAccountDate().compareTo(otherCustomer.getAccountDate());
        }

        return netWorthComparison;
    }
}
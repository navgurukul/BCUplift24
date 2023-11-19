package org.wealthmanager.customer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Customer implements Comparable<Customer>{
    private String name;
    private Date accountOpeningDate;
    private String adhaarNumber;
    private String panNumber;
    Map<String, Double> assetsMap = new HashMap<>();
    Map<String, Double> liabilitiesMap = new HashMap<>();

    public Customer(String name, Date date, String adhaarNumber, String panNumber, Map<String, Double> assetsAmount, Map<String, Double> liabilitiesAmount){
        this.name = name;
        this.accountOpeningDate = date;
        this.adhaarNumber = adhaarNumber;
        this.panNumber = panNumber;
        this.assetsMap = assetsAmount;
        this.liabilitiesMap = liabilitiesAmount;
    }

    public String getName() {
        return name;
    }

    public String getAccountOpeningDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(accountOpeningDate);
    }

    public String getAdhaarNumber() {
        return adhaarNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public double getAssets() {
        double assets=0;
        for (String s : assetsMap.keySet()){
            assets += assetsMap.get(s);
        }
        return assets;
    }

    public double getLiabilities() {
        double liabilities=0;
        for (String s : liabilitiesMap.keySet()){
            liabilities += liabilitiesMap.get(s);
        }
        return liabilities;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("[ name='" + name + '\'');
        sb.append(", accountOpeningDate='" + sdf.format(accountOpeningDate) + '\'' );
        sb.append(", adhaarNumber='" + adhaarNumber + '\'' );
        sb.append(", panNumber='" + panNumber + '\'');
        sb.append(", assetsMap=" + assetsMap);
        sb.append(", liabilitiesMap=" + liabilitiesMap);
        sb.append(" ]");
        return sb.toString();
    }

    public int compareTo(Customer obj){
        int thisNetWorth = (int)(getAssets()-getLiabilities());
        int otherNetWorth = (int)(obj.getAssets()-obj.getLiabilities());

        int diff = Integer.compare(thisNetWorth, otherNetWorth);
        if (diff==0){
            String thisobj = name;
            String otherobj = obj.getName();

            return thisobj.compareTo(otherobj);}
        return diff;
    }
}

package org.uplift.wealthmanager;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Customer implements Comparable<Customer> {
    private String name;
    private Date openingAccountDate;
    private Map<String,Double> assets=new HashMap<>();
    private Map<String,Double> libilities=new HashMap<>();
    private String aadhar;
    private String panCard;

    private double networth;

    public Customer(String name, Date openingAccountDate, Map<String,Double> assets, Map<String,Double> libilities,String aadhar,String panCard){
        this.name=name;
        this.openingAccountDate=openingAccountDate;
        this.assets=assets;
        this.libilities=libilities;
        this.aadhar=aadhar;
        this.panCard=panCard;
    }

    public String getName(){
        return name;
    }

    public Date getOpeningAccountDate(){
        return openingAccountDate;
    }

    public Map<String,Double> getAssests(){
        return assets;
    }

    public Map<String,Double> getLibilities(){
        return libilities;
    }

    public String getAadhar(){
        return aadhar;
    }

    public String getPanCard(){
        return panCard;
    }

    public double getNetworth(){
        return networth;
    }

    public double calculateNetworth(){
        double totalValueOfAssets=0,totalValueOfLibilities=0;
        for(Map.Entry<String,Double> m:assets.entrySet()){
            totalValueOfAssets+=m.getValue();
        }

        for(Map.Entry<String,Double> m:libilities.entrySet()){
            totalValueOfLibilities+=m.getValue();
        }

        this.networth=totalValueOfAssets-totalValueOfLibilities;
        return networth;
    }

    public String toString(){
        return name+" "+aadhar+" ";
    }

    public int compareTo(Customer c){
        Calendar cal= Calendar.getInstance();
        cal.setTime(c.getOpeningAccountDate());
        double secCustomerNetworth=c.getNetworth();
        int secCustomerAccountOpeningDate=cal.get(Calendar.MONTH)+1;
        cal.setTime(openingAccountDate);
        double firstCustomerNetworth=networth;
        int firstCustomerAccountOpeningDate=cal.get(Calendar.MONTH)+1;
        if(firstCustomerNetworth==secCustomerNetworth){
            if(firstCustomerAccountOpeningDate==secCustomerAccountOpeningDate) {
                if (name.equals(c.getName())) return name.compareTo(c.getName());
            }return Integer.compare(firstCustomerAccountOpeningDate,secCustomerAccountOpeningDate);
        }return (int) Double.compare(secCustomerNetworth,firstCustomerNetworth);
    }
}

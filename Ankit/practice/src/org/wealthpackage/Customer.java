package org.wealthpackage;
import java.util.*;

public class Customer implements Comparable<Customer>{
    private Date accountDate ;
    private String name ;
    private long aadharNumber ;
    private String panNumber ;
    private Map<String,Double> assets ;
    private Map<String,Double> liablities;
    public Customer(Date accountDate, String name, long aadharNumber, String panNumber,Map<String,Double> assets ,Map<String,Double> liablities){
        this.accountDate = accountDate ;
        this.name = name ;
        this.aadharNumber = aadharNumber;
        this.panNumber = panNumber ;
        this.assets = assets ;
        this.liablities = liablities ;

    }
    public String getName(){
        return name ;
    }
    public double calculateTotalAssest(){
        double totalAssests = 0.0;
        for(Map.Entry<String, Double> i : assets.entrySet()){
            totalAssests += i.getValue() ;
        }
        return totalAssests ;

    }

    public double calculateTotalLiablity(){
        double totalLiablities = 0.0 ;
        for(Map.Entry<String, Double> i : liablities.entrySet()){
            totalLiablities += i.getValue() ;
        }
        return totalLiablities ;

    }
    @Override
    public int compareTo(Customer obj){
        Double netWorth = calculateTotalAssest() - calculateTotalLiablity();
        Double objNetWorth = obj.calculateTotalAssest() - obj.calculateTotalLiablity();

        int diff = netWorth.compareTo(objNetWorth);
        if(diff == 0){
            accountDate.compareTo(obj.accountDate) ;
        }
        return diff ;

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder() ;
        sb.append("NAME: ");
        sb.append(name);
        sb.append(" ") ;
        sb.append("ACCOUNT DATE: ");
        sb.append(accountDate);
        sb.append(" ") ;
        sb.append("AADHAR NUMBER: ");
        sb.append(aadharNumber);
        sb.append(" ") ;
        sb.append("PAN NUMBER: ");
        sb.append(panNumber);
        return sb.toString() ;
    }


}

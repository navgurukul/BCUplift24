package newquestion;
import java.lang.reflect.Array;
import java.util.*;
import java.util.HashMap;

public class Customer {
//    ArrayList<Customer> customerregister = new ArrayList<>();
    private String name;
    private HashMap<String,Integer> Assets = new HashMap<>();
    private HashMap<String,Integer> liabilities = new HashMap<>();
    private Identity object;
    private double totalassets;
    private double totalliabilities;

    private double totalnetworth;

    void addToAssets(String key,Integer value){
        Assets.put(key,value);
    }

    void addToLiabilities(String key,Integer value){
        liabilities.put(key,value);
    }


    Customer(String name, Identity  object){
        this.object = object;
        this.name = name;
        this.Assets = Assets;
        this.liabilities = liabilities;

    }
    double getTotalAssetValue(){
        for(Map.Entry<String,Integer> entry :Assets.entrySet())
        {
            int value = (int)entry.getValue();
            totalassets+=value;
        }
        return totalassets;
    }


    double getTotalliabilities(){
        for(Map.Entry<String,Integer> entry :liabilities.entrySet())
        {
            int value = (int)entry.getValue();
            totalliabilities+=value;
        }
        return  totalliabilities;
    }
    public double getTotalNetWorth(){
        totalnetworth = getTotalAssetValue()-getTotalliabilities();
        return totalnetworth;
    }

    public String toString(){
        return "Name is: "+name + " total Networth is : "+getTotalNetWorth();
    }


}

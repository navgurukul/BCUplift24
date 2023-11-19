package WealthManager;
import java.util.Map;

public class Customer implements Comparable<Customer>{
    private String name;
    private Identity id;
    private Map<String, Integer> assets;
    private Map<String, Integer> liabilities;

    public Customer(String name, Identity id, Map<String, Integer> assets, Map<String, Integer> liabilities){
        this.name = name;
        this.id = id;
        this.assets = assets;
        this.liabilities = liabilities;
    }
    public String getName() {
        return name;
    }
    public Identity getId() {
        return id;
    }
    public Map<String, Integer> getAssets() {
        return assets;
    }
    public Map<String, Integer> getLiabilities() {
        return liabilities;
    }
    public int calculateNetWorth(){
        int assetSum = 0;
        for (String key : assets.keySet()) {
            int value = assets.get(key);
            assetSum= assetSum + value;
        }
        int liabilitiesSum = 0;
        for (String key : liabilities.keySet()) {
            int value = liabilities.get(key);
            liabilitiesSum= liabilitiesSum + value;
        }
        return assetSum-liabilitiesSum;
    }

    @Override
    public int compareTo(Customer customer) {
        int diff1 = this.calculateNetWorth();
        int diff2 = customer.calculateNetWorth();
        return Integer.compare(diff1, diff2);

    }
}

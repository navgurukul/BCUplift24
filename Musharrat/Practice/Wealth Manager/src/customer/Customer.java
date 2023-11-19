package customer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Customer implements Comparable<Customer>{
    private String name;
    private Identity identity;
    private Map<String, Double> assets;
    private Date accountDate;
    private Map<String, Double> liabilities;

    public Customer(String name, Date accountDate, Map<String, Double> assets, Map<String, Double> liabilities,
                    Identity identity){
        this.name = name;
        this.accountDate = accountDate;
        this.assets = assets;
        this.liabilities = liabilities;
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public Identity getIdentity() {
        return identity;
    }

    public Map<String, Double> getAssets() {
        return assets;
    }

    public Map<String, Double> getLiabilities() {
        return liabilities;
    }

    public double getTotalAssets(){
        double totalAssets = 0;
        for (String s: assets.keySet()){
            totalAssets += assets.get(s);
        }
        return totalAssets;
    }

    public double getTotalLiabilities(){
        double totalLiabilities = 0;
        for (String s: liabilities.keySet()){
            totalLiabilities += liabilities.get(s);
        }
        return totalLiabilities;
    }

    @Override
    public int compareTo(Customer o) {
        double thisNetWorth = (getTotalAssets()-getTotalLiabilities());
        double otherNetWorth = (o.getTotalAssets()-o.getTotalLiabilities());

        int diff = Integer.compare((int)thisNetWorth, (int)otherNetWorth);
        if (diff == 0){
            return accountDate.compareTo(o.getAccountDate());
        }
        return diff;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        StringBuilder sb = new StringBuilder("Customer {");
        sb.append(" name: ");
        sb.append(name);
        sb.append(" identity: ");
        sb.append(identity);
        sb.append(" assets: ");
        sb.append(assets);
        sb.append(" accountDate: ");
        sb.append(sdf.format(accountDate));
        sb.append(" liabilities: ");
        sb.append(liabilities);

        return sb.toString();
    }

}

/*
Wealth Manager:
1. Input n customer with their name, identity(class)(IDs), assets(Map), liabilities(Map).
2. Bank will calculate net worth of every customer. If net worth is less than 1 million pounds
then throw exception showing user-friendly message. If more than 10 crore than display welcome
message.
3. If net worth is more than 100 crores, then display those customers in ascending order of
net worth. If same net worth then order by time.
 */

import WealthManager.Bank;
import WealthManager.Customer;
import WealthManager.Identity;
import WealthManager.NotEligibleException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Bank b1 = new Bank();
        Identity id1 = new Identity("4329dnbe3", "584gfri8");
        Identity id2 = new Identity("4329dnye3", "589gfri8");
        Identity id3 = new Identity("4329dnse3", "566gfri8");
        
        Map<String,Integer> m1Assets= new HashMap<String,Integer>();
        m1Assets.put("Car", 1008300);
        m1Assets.put("Home", 56309873);
        m1Assets.put("Private jet",6832);
        Map<String,Integer> m1Liabilities= new HashMap<String,Integer>();
        m1Liabilities.put("share", 1000);
        Customer c1 = new Customer("Vanshika",id1, m1Assets,m1Liabilities);
        try {
            System.out.println(b1.checkEligibility(c1));
        }
        catch (NotEligibleException e) {
            System.out.println(e.getMessage());
        }
    }
    }
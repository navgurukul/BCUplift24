import org.wealthpackage.Customer;
import org.wealthpackage.EligibilityPrimeException;
import org.wealthpackage.WealthManager;
import java.text.SimpleDateFormat ;
import java.text.ParseException ;
import java.util.*;

public class Main {
    private static boolean checkIsPrime(WealthManager wm) {
        try {
            return wm.isPrimeMember();
        } catch(EligibilityPrimeException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy") ;
        Date date1 = sdf.parse("01/01/2020") ;
        Date date2 = sdf.parse("02/02/2021") ;
        Date date3 = sdf.parse("03/03/2022") ;

        Map <String,Double> assetMap1 = new HashMap<String,Double>() ;
        assetMap1.put("Home",10000000.0);
        assetMap1.put("Car", 200000000.0);

        Map<String,Double> liabilityMap1 = new HashMap<String,Double>() ;
        liabilityMap1.put("Bank Loan",200000.0) ;
        liabilityMap1.put("Home loan",1000000.0);

        Map <String,Double> assetMap2 = new HashMap<String,Double>() ;
        assetMap2.put("Business",10000000000000.0);
        assetMap2.put("Car", 200000000.0);

        Map<String,Double> liabilityMap2 = new HashMap<String,Double>() ;
        liabilityMap2.put("Bank Loan",200000.0) ;
        liabilityMap2.put("Education loan",20000.0);

        Map <String,Double> assetMap3 = new HashMap<String,Double>() ;
        assetMap3.put("Premises",5000000000.0);
        assetMap3.put("factory", 200000000.0);

        Map<String,Double> liabilityMap3 = new HashMap<String,Double>() ;
        liabilityMap3.put("Bank Loan",200000.0) ;
        liabilityMap3.put("Home loan",1000000.0);

        Customer c1 = new Customer(date1,"Ankit",123456666678L,"FG3455K567",assetMap1,liabilityMap1) ;
        Customer c2 = new Customer(date2,"Sunny",3459666678L,"G3455K567G",assetMap2,liabilityMap2) ;
        Customer c3 = new Customer(date3,"Neha",56666671238L,"PK55K56756",assetMap3,liabilityMap3) ;

        double totalAss1 = c1.calculateTotalAssest();
        double totalLiab1 = c1.calculateTotalLiablity();

        double totalAss2 = c2.calculateTotalAssest();
        double totalLiab2 = c2.calculateTotalLiablity();

        double totalAss3 = c3.calculateTotalAssest();
        double totalLiab3 = c3.calculateTotalLiablity();

        TreeSet<Customer> sortedTree = new TreeSet<>();
        sortedTree.add(c1);
        sortedTree.add(c2);
        sortedTree.add(c3);
        System.out.println(sortedTree);


        WealthManager w1 = new WealthManager();
        double nw1 = w1.calculateNetWorth(totalAss1,totalLiab1);
        System.out.println(c1.getName() + " ,Your Net Worth is; " + nw1);
        System.out.println(c1.getName() + " ,Eligible for Wealth Manager Services: " + w1.isEligibleForMembership());
        checkIsPrime(w1);

        WealthManager w2 = new WealthManager();
        double nw2 = w2.calculateNetWorth(totalAss2,totalLiab2);
        System.out.println(c2.getName() + " ,Your Net Worth is; " + nw2);
        System.out.println(c2.getName() + " ,Eligible for Wealth Manager Services: " + w2.isEligibleForMembership());
        checkIsPrime(w2);

        WealthManager w3 = new WealthManager();
        double nw3 = w3.calculateNetWorth(totalAss3,totalLiab3);
        System.out.println(c3.getName() + " ,Your Net Worth is; " + nw3);
        System.out.println(c3.getName() + " ,Eligible for Wealth Manager Services: " + w3.isEligibleForMembership());
        checkIsPrime(w3);


    }
}
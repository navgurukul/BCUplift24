package customer;

import exceptionHandling.NotEligibleForWMServicesException;
import wealthManager.WealthManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class CustomerData {

    public static WealthManager wm = new WealthManager();

    public void sendCustomerData() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        //--------------------------------------------------------------------------------------------------------------
        Map<String, Double> assetsC1 = new HashMap<>();
        Map<String, Double> liabilitiesC1 = new HashMap<>();

        assetsC1.put("Properties", 100000000.0);
        assetsC1.put("Vehicles", 500000000.0);


        liabilitiesC1.put("Home loan: ", 3000000.0);

        Customer c1 = new Customer("Amara", sdf.parse("07-11-2020"), assetsC1,
                liabilitiesC1, new Identity("2345", "09897"));

        //--------------------------------------------------------------------------------------------------------------

        Map<String, Double> assetsC2 = new HashMap<>();
        Map<String, Double> liabilitiesC2 = new HashMap<>();

        assetsC2.put("Properties", 200000000.0);
        assetsC2.put("Vehicles", 8000000.0);

        liabilitiesC2.put("Car loan: ", 80000.0);
        liabilitiesC2.put("home loan: ", 200000.0);

        Customer c2 = new Customer("Mahi", sdf.parse("22-02-2020"), assetsC2,
                liabilitiesC2, new Identity("4532", "378ds45"));

        //--------------------------------------------------------------------------------------------------------------

        Map<String, Double> assetsC3 = new HashMap<>();
        Map<String, Double> liabilitiesC3 = new HashMap<>();

        assetsC3.put("House", 20000.0);
        assetsC3.put("Car", 8000.0);

        liabilitiesC3.put("Car loan: ", 18000.0);
        liabilitiesC3.put("home loan: ", 2000.0);

        Customer c3 = new Customer("Maya", sdf.parse("22-02-2020"), assetsC3,
                liabilitiesC3, new Identity("897435", "2h309d"));

        //--------------------------------------------------------------------------------------------------------------

        addCustomerData(c1);
        addCustomerData(c2);
        addCustomerData(c3);


        //System.out.println(wm.getWealthManagement());
        for (Customer c: wm.getWealthManagement()){
            System.out.println(c);
        }

        System.out.println();
        System.out.println("All Customer list: ");
        for (Customer cust: wm.getAllCust()){
            System.out.println(cust);
        }

    }

    public void addCustomerData(Customer c){
        try {
            wm.addCustomerToWealthManagement(c);
        }
        catch (NotEligibleForWMServicesException o){
            System.out.println(o.getMessage());
        }
    }



}

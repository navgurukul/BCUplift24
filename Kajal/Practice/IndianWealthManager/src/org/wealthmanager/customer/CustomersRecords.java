package org.wealthmanager.customer;

import org.exceptions.NotEligibleForWMServices;
import org.wealth.manager.WealthManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;

public class CustomersRecords {
    public static WealthManager wm = new WealthManager();

    public void addCustomers() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Map<String, Double> a = new TreeMap<>();
        a.put("Property", 1230000.0);
        a.put("Vehicle", 2306000.0);
        Map<String, Double> lib = new TreeMap<>();
        lib.put("loan", 1230000.0);
        lib.put("kisht", 23000000.0);
        Customer c = new Customer("xyz", sdf.parse("23-4-2002"), "1234569766", "SFHR2345G", a, lib);
        //------------------------------------------------------------------------------------------------------------------------------

        Map<String, Double> a1 = new TreeMap<>();
        a1.put("Property", 1000000000.0);
        a1.put("Vehicle", 2000000000.0);
        Map<String, Double> lib1 = new TreeMap<>();
        lib1.put("loan", 1000.0);
        lib1.put("kisht", 20000.0);
        Customer c1 = new Customer("Son", sdf.parse("20-4-2002"), "1234569766", "SFHR2345G", a1, lib1);

        //------------------------------------------------------------------------------------------------------------------------------

        Map<String, Double> a2 = new TreeMap<>();
        a2.put("Property", 4000000000.0);
        a2.put("Vehicle", 9000000000.0);
        Map<String, Double> lib2 = new TreeMap<>();
        lib2.put("loan", 10000.0);
        lib2.put("kisht", 70000.0);
        Customer c2 = new Customer("Mush", sdf.parse("23-2-2002"), "1234569766", "SFHR2345G", a1, lib1);
        //-------------------------------------------------------------------------------------------------------------------------------

        addCustomerData(c);
        addCustomerData(c1);
        addCustomerData(c2);

        //SortedSet <Customer> sortcustomer = ;
        for (Customer i : wm.showWealthgetCustomers()) {
            System.out.println(i);
        }

        System.out.println("List of all Bank's Customer: ");
        for (Customer cust : wm.getAllCustomers()){
            System.out.println(cust);
        }
    }
    public void addCustomerData(Customer c) {
        try{
            wm.addCustomerToWM(c);
        }
        catch (NotEligibleForWMServices e){
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

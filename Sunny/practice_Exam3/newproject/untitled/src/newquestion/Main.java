package newquestion;
import newquestion.Customer;
import newquestion.CustomerRegister;
import newquestion.WealthManager;
import newquestion.Identity;
import java.util.*;
import java.util.HashMap;


public class Main {
    public static void main(String[] input) {
        Identity obj1 = new Identity("1234", "56789");
        Identity obj2 = new Identity("000000","0987865");
        Customer c1 = new Customer("Sunny",obj1);
        Customer c2 = new Customer("Neha",obj2);
        c1.addToAssets("Car",100000);
        c1.addToAssets("bike",320000);
        c1.addToAssets("duke",320000);
        c1.addToLiabilities("House-Loan",2000);

        c2.addToAssets("house",2000000);
        c2.addToAssets("cars",300000);
        c2.addToAssets("Fz",250000);
        c2.addToLiabilities("null",0);

        CustomerRegister r1 = new CustomerRegister(c1);
//        System.out.println(c1.getTotalNetWorth());
        CustomerRegister r2 = new CustomerRegister(c2);
//        System.out.println(r1.listOfAllCustomer);
//        WealthManager wm = new WealthManager(r1);
////
//        WealthManager wm1 = new WealthManager(r2);
        r2.printList();

//        System.out.println(wm.getList());
    }
}

package newquestion;

import java.util.*;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.ArrayList;

public class WealthManager {
     private final CustomerRegister object;
     private SortedSet<Customer> regulercustomer = new TreeSet<>();
     private SortedSet<Customer> primecustomers = new TreeSet<>();

     WealthManager(CustomerRegister object){
         this.object = object;
         ArrayList<Customer> array = object.getListOfAllCustomer();
 
     }
    public ArrayList<Customer> getList(){
//        CustomerRegister custobject = object;
            ArrayList<Customer> array = object.getListOfAllCustomer();
//         System.out.println(array);
        return array;
    }
}



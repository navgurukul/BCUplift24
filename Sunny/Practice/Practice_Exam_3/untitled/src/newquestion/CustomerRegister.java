package newquestion;
import java.util.*;

public class CustomerRegister {
    private Customer customerobject;
    ArrayList<Customer> listOfAllCustomer = new ArrayList<>();

    CustomerRegister(Customer object){
        this.customerobject = object;
        listOfAllCustomer.add(object);
    }
    ArrayList<Customer> getListOfAllCustomer(){

        return listOfAllCustomer;
    }

    public void printList(){
        for(Customer i :listOfAllCustomer){
            System.out.println(i);
        }
    }

}

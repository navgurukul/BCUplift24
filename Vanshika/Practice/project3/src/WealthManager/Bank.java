package WealthManager;

import java.util.*;

public class Bank {
    Map<Customer, Integer> customerList = new HashMap<Customer, Integer>();
    private SortedSet<Customer> customerSet = new TreeSet<>();
    public String checkEligibility(Customer c) throws NotEligibleException {
        if (c.calculateNetWorth()>=1000000){
            customerSet.add(c);
            return "Welcome to our bank kya huqum apka? :)";
        }
        else{
           throw new NotEligibleException("Sorry we can't create your account :(");
        }
    }
    Map<Customer, Integer> getCustomerList(){
        return customerList;
    }
}

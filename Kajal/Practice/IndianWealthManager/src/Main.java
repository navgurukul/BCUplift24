import org.exceptions.NotEligibleForWMServices;
import org.wealth.manager.WealthManager;
import org.wealthmanager.customer.Customer;
import org.wealthmanager.customer.CustomersRecords;

import java.text.ParseException;


public class Main {
    public static void main(String[] args)throws ParseException{
        CustomersRecords cr = new CustomersRecords();
        cr.addCustomers();

    }
}
import org.uplift.wealthmanager.CreateObject;
import org.uplift.wealthmanager.NotEligibleException;
import org.uplift.wealthmanager.Register;

import java.text.ParseException;

public class Main {

    public static void main(String[] args)throws ParseException, NotEligibleException {
        CreateObject i1=new CreateObject();
        i1.createCutomerObject();
    }
}
import org.uplift.com.Citizen;
import org.uplift.com.InvalidAadharException;
import org.uplift.com.Registry;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class CitizenRegistry
{
    public static void main(String[] args) {
        Registry r= new Registry();

        try{
            Citizen c1 = new Citizen("dipti", "7983278397", "99999999999");
            r.addCitizen(c1);
            Citizen c2 = new Citizen("trupti", "7983278397", "88888888888");
            r.addCitizen(c2);
            Citizen c3 = new Citizen("maya", "79866666", "777777777");
            r.addCitizen(c3);
            Citizen c4 = new Citizen("riya", "873984379898","666666666");
            r.addCitizen(c4);
        }
        catch(InvalidAadharException e){
            System.out.println("error:" + e.getMessage());
        }

    }
}
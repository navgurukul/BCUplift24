import org.uplift.birthday.Register;
import org.uplift.birthday.Students;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");

        Students s1 = new Students("Sonam", s.parse("02-03-2004"));
        Students s2 = new Students("Anjali", s.parse("03-06-2004"));
        Students s3 = new Students("Rakhi", s.parse("06-03-2003"));
        Students s4 = new Students("Rakhi", s.parse("06-03-2005"));
        Students s6 = new Students("Anshika", s.parse("04-02-2003"));
        Students s5 = new Students("Vanshika", s.parse("07-04-2002"));

        Register r1 = new Register();
        r1.addStudents(s1);
        r1.addStudents(s2);
        r1.addStudents(s3);
        r1.addStudents(s4);
        r1.addStudents(s5);
        r1.addStudents(s6);

        int targetMonth =sc.nextInt();
        r1.check(targetMonth);
        r1.printBirthdayWishes();
    }
}
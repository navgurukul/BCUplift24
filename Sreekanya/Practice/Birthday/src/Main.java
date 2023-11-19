import org.birthday.BirthdayRegister;
import org.birthday.Student;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Student student1 = new Student("Sreekanya", sdf.parse("19-1-1998"));
        Student student2 = new Student("Swapna", sdf.parse("21-04-2019"));
        Student student3 = new Student("Sweety", sdf.parse("16-1-2012"));
        Student student4 = new Student("Pandu", sdf.parse("20-1-2020"));
        BirthdayRegister register = new BirthdayRegister();
        register.addStudent(student1);
        register.addStudent(student2);
        register.addStudent(student3);
        register.addStudent(student4);

        printBirthdayWishes(register, 1);

    }

    public static void printBirthdayWishes(BirthdayRegister register, int month) {
        List<Student> studentsForMonth = new ArrayList<>();
        for (Student s : register.getSR()) {
            if (s.getBirthMonth() == month - 1) {
                studentsForMonth.add(s);
            }
        }

        Collections.sort(studentsForMonth);

        for (Student s : studentsForMonth) {
            System.out.println( s.getBirthDate() + ": Happy birthday, " + s.getName() + "!");
        }
    }
}
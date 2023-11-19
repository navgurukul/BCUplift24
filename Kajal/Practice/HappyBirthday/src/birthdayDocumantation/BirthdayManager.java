package birthdayDocumantation;

import birthdayDocumantation.student.StudentList;
import birthdayDocumantation.student.Students;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

public class BirthdayManager {
    public SortedSet<Students> monthBirthday = new TreeSet<Students>();
    private int month;

    public BirthdayManager(int month) throws ParseException{
        this.month = month;
        StudentList sl = new StudentList();
        Students[] students = sl.addStudents();
        for (Students s:students){
            Date d = s.getDateOfBirth();
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            //c.get(Calendar.MONTH)+1;
            if (month==c.get(Calendar.MONTH)+1){
                monthBirthday.add(s);
            }

        }
    }

    public int getMonth(){
        return month;
    }

    public void showsStudentList(){
        if (monthBirthday.isEmpty()){
            System.out.println("There are no students born in this month.");
        }
        else{
            for (Students s1: monthBirthday) System.out.println(s1);
        }
    }
}

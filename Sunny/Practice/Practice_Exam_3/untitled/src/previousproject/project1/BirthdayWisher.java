package previousproject.project1;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

class BirthdayWisher{
    private int userMonth;
    private SortedSet<Student> mySet = new TreeSet<>();

    BirthdayWisher(int userMonth){
        this.userMonth = userMonth;
    }

    void wish(){
        StudentDataRegister obj = new StudentDataRegister();
        ArrayList<Student> studentData = obj.getStudents();

        for(Student i : studentData){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(i.getDate());
            int objMonth = calendar.get(Calendar.MONTH) + 1;
            if(userMonth==objMonth){
                mySet.add(i);
            }
        }
        // System.out.println(mySet);
        for (Student i : mySet){
            System.out.println(i);
        }

    }
}

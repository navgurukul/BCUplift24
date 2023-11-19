package previousproject.project1;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;


class StudentDataRegister{
    public static ArrayList<Student> allStudents = new ArrayList<>();


    void addNewStudents(Student obj){
        allStudents.add(obj);
    }

    public ArrayList<Student> getStudents(){
        return allStudents;
    }

}
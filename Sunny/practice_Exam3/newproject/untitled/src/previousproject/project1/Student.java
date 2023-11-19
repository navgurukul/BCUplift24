package previousproject.project1;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

class Student implements Comparable<Student>{
    private String name;
    private Date birthDate;
    private String phoneNumber;


    Student(String name,String dateStr,String phoneNumber){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            this.birthDate = sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Student otherStudent) {
        int diff = this.birthDate.compareTo(otherStudent.birthDate);

        if (diff == 0){
            return this.name.compareTo(otherStudent.getName()) ;
        }
        return diff;
    }

    public Date getDate(){
        return birthDate;
    }
    public String getName(){
        return name;
    }

    public String toString(){
        return "Happy Bday Month "+name+" Birthdate is "+ getDate();
    }

}
package previousproject.project1;
import previousproject.project1.*;


public class Main{
    public static void main(String[] args) {
        Student s1 = new Student("Sunny", "16/10/2001","123456");
        Student s2 = new Student("Ankit", "16/10/2001","123456");
        Student s3 = new Student("Mohit", "18/10/2001","123456");
        Student s4 = new Student("Jainab", "18/11/2001","123456");
        Student s5 = new Student("Mohit", "18/11/2001","123456");
        StudentDataRegister obj = new StudentDataRegister();
        obj.addNewStudents(s1);
        obj.addNewStudents(s2);
        obj.addNewStudents(s3);
        obj.addNewStudents(s5);
        obj.addNewStudents(s4);
        BirthdayWisher obj1  = new BirthdayWisher(11);
        obj1.wish() ;
    }
}
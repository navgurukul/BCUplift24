package org.uplift.demo.Repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.uplift.demo.laptop.Laptop;
import org.uplift.demo.student.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

public class StudentRepository {



    public ArrayList<Student> getStudentList() {
        List<Student> studentsList = Arrays.asList(new Student("1","Janu","email@email","1222",new Laptop("12","232","Dell")),
                new Student("3","Sanu","sanu@gmail.com","12132",new Laptop("133","CN123","Lenovo")),
                new Student("5","Chhaku","chhaku@gmail.com","67687",new Laptop("568","B86","Macbook")));
        return studentList;
    }

    ArrayList <Student> studentList = new ArrayList<Student>();

    public boolean createStudent(Student s){
        return  studentList.add(s);
    }

    public boolean deleteStudent(Student s){
        return  studentList.remove(s);
    }

    public Student findById(String id){
        return  studentList.stream().filter(s->s.getId().equals(id)).findFirst().orElse(null);
    }


//    public List<Student> displayStudentList(){
//        List<Student> students = Arrays.asList(new Student("1","Janu","email@email","1222",new Laptop("12","232","Dell")),
//                new Student("3","Sanu","sanu@gmail.com","12132",new Laptop("133","CN123","Lenovo")),
//                new Student("5","Chhaku","chhaku@gmail.com","67687",new Laptop("568","B86","Macbook")));
//        return students;
//    }


}
package org.uplift.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.uplift.demo.Repository.LaptopRepository;
import org.uplift.demo.Repository.StudentRepository;
import org.uplift.demo.laptop.Laptop;
import org.uplift.demo.student.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class StudentService {

    @Autowired
    private LaptopRepository lr;




    @Autowired
    private StudentRepository sr;




    public boolean addStudents(Student s){
        lr.addLaptop(s.getLaptop());
        sr.createStudent(s);
        return true;
    }

    //    public Student  findStudent(String id){
//         return sr.findById(id);
//
//
//    }
    public Student findById(String id){
        return  sr.findById(id);
    }

    public boolean update(Student updatedStudent){
        Student s = findById(updatedStudent.getId());
        if (s==null)return false;
        Laptop l = findBySerialNumber(updatedStudent.getLaptop().getSerialNumber());
        if(l==null)return false;
        removeStudent(s);
        addStudents(updatedStudent);
        return true;
    }


    private boolean removeStudent(Student s){
        System.out.println(lr);
        System.out.println(sr);
        boolean result = lr.removeLaptop(s.getLaptop());
        if (!result)return false;
        return sr.deleteStudent(s);


    }

    public boolean removeStudentById(String id){
        Student s = findById(id);
        if (s == null) return false;
        return sr.deleteStudent(s);
    }

    public Laptop findBySerialNumber(String sn){
        System.out.println(lr);
        return  lr.findBySerialNumber(sn);
    }

    public List<Student> getStudentList(){
        System.out.println(sr);
        //System.out.println(context.getBean(StudentRepositry.class));
        return sr.getStudentList();
    }

    public boolean addLaptops(Laptop laptop){
        System.out.println(lr);
        return lr.addLaptop(laptop);
    }
}
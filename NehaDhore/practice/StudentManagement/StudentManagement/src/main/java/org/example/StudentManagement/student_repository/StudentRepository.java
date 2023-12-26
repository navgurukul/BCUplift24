package org.example.StudentManagement.student_repository;

import org.example.StudentManagement.student.Student;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class StudentRepository {


    List<Student> studentList = new ArrayList<>();

    public boolean createStudent(Student s){
        return  studentList.add(s);
    }
    public Student findById(String id){
        return studentList.stream().filter(s->s.getId().equals(id)).findFirst().orElse(null);
    }
    public boolean updateStudent(Student s){
        if(s.getId().equals(s.getId())){
            return false;
        }
        return true;
    }
    public boolean deleteStudent(Student s){
        return studentList.remove(s);
    }



}

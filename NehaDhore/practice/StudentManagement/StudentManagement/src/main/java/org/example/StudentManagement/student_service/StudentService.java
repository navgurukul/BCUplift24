package org.example.StudentManagement.student_service;

import org.example.StudentManagement.student.Student;
import org.example.StudentManagement.student_repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class StudentService {
    @Autowired
    private StudentRepository sr ;
    public boolean createStudent(Student s){
        return sr.createStudent(s);
    }
    public Student findById(String id){
         return  (sr.findById(id)) ;

//        if(sr.findById())
    }

        public boolean updateStudent(Student s){
        if(sr.findById(s.getId())==null){
            sr.updateStudent(s);
            return true;
             }
        return false;
        }
        public boolean deleteStudent(Student s){
        if(sr.findById(s.getId())==null){
            return false;
            }

            return sr.deleteStudent(s);
        }



}

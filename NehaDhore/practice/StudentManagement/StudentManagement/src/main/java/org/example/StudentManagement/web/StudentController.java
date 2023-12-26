package org.example.StudentManagement.web;

import org.example.StudentManagement.student.Student;
import org.example.StudentManagement.student_service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService ss;

    @GetMapping("/")
    public String test(){
        return "Hello";
    }
    @PostMapping ("/students")
    public ResponseEntity<Boolean> createStudent(@RequestBody Student s){
        boolean result = ss.createStudent(s);
        if(!result) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(true);
    }
    @GetMapping("/students/{id}")

    public Student findById(@PathVariable String id){
        System.out.println("test1");
        return ss.findById(id);

    }
    @PutMapping("/students")

    public boolean updateStudent(@RequestBody Student s) {
          boolean update = ss.updateStudent(s);
        if (update) return true;
        return false;

    }
    @DeleteMapping("/students")
//    @DeleteMapping("/student/{id}")
//    public ResponseEntity<Boolean> deleteStudent(@PathVariable String id) {
//        boolean result = ss.removeStudentById(id);
//        if (!result) return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(true);
//    }
public Boolean deleteStudent(@RequestBody Student s){
        boolean delete = ss.deleteStudent(s);
        if (delete) return true;
        return false;
    }




}

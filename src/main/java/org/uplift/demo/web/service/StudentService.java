package org.uplift.demo.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uplift.demo.web.laptop.Laptop;
import org.uplift.demo.web.Repositery.LaptopRepository;
import org.uplift.demo.web.Repositery.StudentRepository;
import org.uplift.demo.web.student.Student;

import java.util.List;
import java.util.Objects;

@Service

public class StudentService {

    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private StudentRepository studentRepository;

    public boolean addStudent(Student s){
        boolean result = laptopRepository.addLaptop(s.getLaptop());
        if (!result) return false;
        return studentRepository.createStudent(s);
    }

    public boolean removeStudentById(String id){
        Student student = findStudent(id);
        if (student==null) return false;
        boolean result = laptopRepository.removeLaptop(student.getLaptop());
        if (!result) return false;
        studentRepository.deleteStudent(student);
        return true;
    }

    private boolean removeStudent(Student student){
        boolean result = laptopRepository.removeLaptop(student.getLaptop());
        if (!result) return false;
        return studentRepository.deleteStudent(student);
    }

    public Student findStudent(String id){
        return studentRepository.findStudent(id);
    }

    public boolean update(Student updateStudent){
        Student s = findStudent(updateStudent.getId());
        if (s==null) return false;
        Laptop result = laptopRepository.findLaptop(s.getLaptop().getSerialNo());
        if (result==null) return false;
        removeStudent(s);
        addStudent(updateStudent);
        return true;
    }

    public Laptop findLaptop(String id){
        return laptopRepository.findLaptop(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentService that)) return false;
        return Objects.equals(laptopRepository, that.laptopRepository) && Objects.equals(studentRepository, that.studentRepository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(laptopRepository, studentRepository);
    }
}


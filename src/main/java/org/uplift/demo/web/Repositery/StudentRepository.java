package org.uplift.demo.web.Repositery;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.uplift.demo.web.student.Student;

import java.util.ArrayList;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StudentRepository {

    ArrayList<Student> allStudents = new ArrayList<>();

    public ArrayList<Student> getAllStudents() {
        return allStudents;
    }

    public boolean createStudent(Student s){
        return allStudents.add(s);
    }

    public Student findStudent(String id){
        return allStudents.stream().filter(student -> student.getId().equals(id)).
                findFirst().orElse(null);
    }

    public boolean deleteStudent(Student student){
        return allStudents.remove(student);
    }


}

package org.birthday;

import java.util.HashSet;

public class BirthdayRegister {
    private HashSet<Student> sR;

    public BirthdayRegister() {
        this.sR = new HashSet<>();
    }

    public void addStudent(Student student) {
        sR.add(student);
    }

    public HashSet<Student> getSR() {
        return sR;
    }
}

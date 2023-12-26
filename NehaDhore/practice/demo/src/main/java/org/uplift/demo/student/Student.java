package org.uplift.demo.student;

import org.uplift.demo.laptop.Laptop;

import java.util.ArrayList;
import java.util.Objects;

public class Student {
    private String id;
    private String name;
    private String email;
    private String phone;



    private ArrayList<Laptop> laptopdetails;

    private Laptop laptop;

    public Student(String id, String name, String email, String phone,Laptop laptop) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.laptop = laptop;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(email, student.email) && Objects.equals(phone, student.phone) && Objects.equals(laptopdetails, student.laptopdetails) && Objects.equals(laptop, student.laptop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone, laptopdetails, laptop);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", laptopdetails=" + laptopdetails +
                ", laptop=" + laptop +
                '}';
    }
}
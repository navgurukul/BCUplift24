package org.uplift.demo.web.student;

import org.uplift.demo.web.laptop.Laptop;

import java.util.Objects;

public class Student {

    //This is DTO : data transfer object - this means to transfer data from database to server/service or something like this.
    private String name;
    private String id;
    private String email;
    private String phone;
    private Laptop laptop;

    public Student(String name, String id, String email, String phone, Laptop laptop) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.laptop = laptop;
    }

    public Laptop getLaptop(){
        return laptop;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Student student)) return false;
//        return Objects.equals(name, student.name) && Objects.equals(id, student.id) && Objects.equals(email, student.email) && Objects.equals(phone, student.phone) && Objects.equals(laptop, student.laptop);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getName(), getId(), getEmail(), getPhone(), getLaptop());
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(getName(), student.getName()) && Objects.equals(getId(), student.getId()) && Objects.equals(getEmail(), student.getEmail()) && Objects.equals(getPhone(), student.getPhone()) && Objects.equals(getLaptop(), student.getLaptop());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), getEmail(), getPhone(), getLaptop());
    }
}

package org.uplift.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.uplift.demo.Repository.LaptopRepository;
import org.uplift.demo.laptop.Laptop;
import org.uplift.demo.student.Student;

import java.util.ArrayList;
import java.util.List;

public class LaptopService {
    @Autowired
    private LaptopRepository lr;

    List<Laptop> laptopList = new ArrayList<>();
    public  boolean addLaptop(Laptop laptop){
        return laptopList.add(laptop);
    }
    public Laptop findLaptop(String id){
        return laptopList.stream().filter(s -> id.equals(s.getId())).findFirst().orElse(null);
    }

    public boolean updateStudent(Laptop l){
        Laptop s = findLaptop(l.getId());
        if(s == null )return false;
        return laptopList.add(l);
    }
}

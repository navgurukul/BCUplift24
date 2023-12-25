package org.example.student;

import org.example.laptop.Lenovo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Anshika implements Student{
    @Autowired
    private Lenovo laptop;

    @Override
    public void getLaptopId() {

    }

    @Override
    public Lenovo getLaptop() {
        return laptop;

    }
    @Override
    public void getLaptopName() {
        System.out.println("lenovo z31");
    }
}

package org.example.obs.student;

import org.example.obs.laptop.Laptop;
import org.example.obs.laptop.Thinkpad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kajal implements Student{
    @Autowired
    private Thinkpad thinkpad;


    @Override
    public Thinkpad getLaptop() {
        return thinkpad;
    }
}

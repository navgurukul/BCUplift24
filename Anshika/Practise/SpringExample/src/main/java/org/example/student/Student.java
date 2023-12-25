package org.example.student;

import org.example.laptop.Laptop;
import org.example.laptop.Lenovo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public interface Student {

    void getLaptopId();
    Lenovo getLaptop();


    void getLaptopName();
}

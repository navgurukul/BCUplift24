package org.example.obs.student;


import org.example.obs.laptop.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public interface Student {

    Laptop getLaptop();
}

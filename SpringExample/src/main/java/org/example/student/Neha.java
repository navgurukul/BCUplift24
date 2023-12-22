package org.example.student;

import org.example.laptop.Dell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Neha implements Student{

    @Autowired   //its like you are showing the electrician where to place the bulb.......
    private Dell laptop;

    @Override
    public String getName() {
        return "Neha";
    }

    public Dell getLaptop() {
        return laptop;
    }
}

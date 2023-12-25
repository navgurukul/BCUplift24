package org.example.obs.student;


import org.example.obs.laptop.Dell;
import org.example.obs.laptop.Thinkpad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sonam implements Student{
    @Autowired
    private Dell dell;


    @Override
    public Dell getLaptop() {
        return dell;
    }

}

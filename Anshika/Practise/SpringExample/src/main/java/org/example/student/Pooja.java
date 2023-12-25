package org.example.student;

import org.example.laptop.Lenovo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Pooja implements Student{

    @Override
    public void getLaptopId() {

    }

    @Override
    public Lenovo getLaptop() {
        return null;
    }

    @Override
    public void getLaptopName() {

    }

    public static void main(){
        AnnotationConfigApplicationContext acac=new AnnotationConfigApplicationContext()
;
    }
}

package org.example;

import org.example.laptop.Lenovo;
import org.example.student.Anshika;
import org.example.student.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.w3c.dom.ls.LSOutput;

import java.util.logging.Level;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@ComponentScan(basePackages = {"org.example"})
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext acac=new AnnotationConfigApplicationContext();
        acac.register(Main.class);
        acac.refresh();

        Anshika s1=acac.getBean(Anshika.class);
        Lenovo l1 = s1.getLaptop();
        l1.config();


    }
}
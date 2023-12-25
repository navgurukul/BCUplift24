package org.example.obs.laptop;


import org.springframework.stereotype.Component;

@Component
public class Dell implements Laptop{


    @Override
    public int getId() {
        return 5;
    }


}

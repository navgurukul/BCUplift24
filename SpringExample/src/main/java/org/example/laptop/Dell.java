package org.example.laptop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class Dell implements Laptop{
    @Override
    public String getSerialNumber() {
        return "123";
    }
}

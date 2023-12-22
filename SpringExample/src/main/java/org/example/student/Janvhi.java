package org.example.student;

import org.example.laptop.Dell;
import org.example.laptop.ThinkPad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Janvhi implements Student {
    @Autowired
    private ThinkPad tp;
    @Override
    public String getName() {
        return "Janvhi";
    }
    public ThinkPad getLaptop() {
        return tp;
    }
}

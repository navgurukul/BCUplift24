package org.example.laptop;

import org.springframework.stereotype.Component;

@Component

public class ThinkPad implements Laptop {
    @Override
    public String getSerialNumber() {
        return "456";
    }
}

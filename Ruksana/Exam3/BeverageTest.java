package org.exam3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
class BeverageTest {
    @BeforeEach
    void setup(){
        Beverage beverage = new Beverage("Nimbu", "PaperBoat", 1000, 5);
        System.out.println(beverage.getDescription());
    }
}
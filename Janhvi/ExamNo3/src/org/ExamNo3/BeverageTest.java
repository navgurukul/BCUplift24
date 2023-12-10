package org.ExamNo3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {

    @Test
    void getProductDescription() {
        Beverage beverage = new Beverage(5, 400, 0.3, "PaperBoat", 1000, "Kiwi");
        String result = beverage.getProductDescription();
        assertTrue(result.contains("PaperBoat"));

    }
    @Test
    void testForDiscountApplied(){
        Beverage beverage = new Beverage(5, 400, 0.3, "PaperBoat", 1000, "Kiwi");
        assertEquals(280.0,beverage.getDiscountApplied());

    }
    @Test
    void testForCalculatingNetPrice(){
        Beverage beverage = new Beverage(5, 400, 0.3, "PaperBoat", 1000, "Kiwi");
        assertEquals(280.0,beverage.netPrice());

    }
}
package order.products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {

    @Test
    void testGetProductDescription() {
        Beverage beverage = new Beverage(1, 20.0, "Paper Boat", 50, "Nimbu");
        String result = beverage.getProductDescription();
        assertTrue(result.contains("50ml"));
        assertTrue(result.contains("Paper Boat"));
        assertTrue(result.contains("Nimbu"));
        assertTrue(result.contains(" flavoured beverage "));
        assertTrue(result.contains(" with capacity "));
    }

    @Test
    void testGetDiscountApplied() {
        Beverage beverage = new Beverage(1, 20.0, "Paper Boat", 50, "Nimbu");
        assertEquals(4, beverage.getDiscountApplied());
    }
}
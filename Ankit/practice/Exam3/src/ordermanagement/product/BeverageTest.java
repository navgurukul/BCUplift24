package ordermanagement.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {

    @Test
    void getProductDescription() {
        Beverage b1 = new Beverage(1,200,20,"nimbu",500L,"paperBoat");
        String str = b1.getProductDescription();
        assertTrue(str.contains(b1.getMake()));
    }

    @Test
    void getDiscountApplied() {
        Beverage b1 = new Beverage(1,200,20,"nimbu",500L,"paperBoat");
        double discount = b1.getDiscountApplied();
        assertEquals(40,discount);
    }

    @Test
    void getPrice() {
        Beverage b1 = new Beverage(1,200,20,"nimbu",500L,"paperBoat");
        double price = b1.getPrice();
        assertEquals(b1.getPrice(),price);
    }

    @Test
    void netPrice() {
        Beverage b1 = new Beverage(1,200,20,"nimbu",500L,"paperBoat");
        double netPrice = b1.netPrice();
        assertEquals(160,netPrice);
    }

    @Test
    void testToString() {
        Beverage b1 = new Beverage(1,200,20,"nimbu",500L,"paperBoat");
        String str = b1.toString();
        assertTrue(str.contains(b1.getMake()));
    }
}
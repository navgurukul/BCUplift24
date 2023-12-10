package OnlineShopping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {

    @org.junit.jupiter.api.Test
    void testToString() {
        Beverage br1= new Beverage("21",100.0,5,"cool",1000,"nimbu");
        assertTrue(br1.toString().contains("cool"));
        assertTrue(br1.toString().contains("21"));
        assertTrue(br1.toString().contains("nimbu"));

    }

}
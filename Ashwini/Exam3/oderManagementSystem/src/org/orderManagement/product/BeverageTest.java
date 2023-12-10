package org.orderManagement.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {
    @Test
    void testgetDiscountApplied(){
        Product beverage1 = new Beverage(12,"abc","hhjuyhn",98766544L,300);
        assertEquals(30,beverage1.getDiscountApplied());
    }
    @Test
    void testnetPrice(){
        Beverage beverage1 = new Beverage(12,"abc","hhjuyhn",98766544L,300);
        assertEquals(170,beverage1.netPrice());
    }

}
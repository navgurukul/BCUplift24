package org.uplift.ordermanagementsystem;

import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

class BookTest {
    @Test
    public void testBookDescription() {
        Book book = new Book("Fiction", "Amish", "The Immortals of Melhua");
        String description = book.getProductDescription();
        assertEquals("Book of genre The Immortals of Melhua written by Amish with title Fiction", description);
    }

}
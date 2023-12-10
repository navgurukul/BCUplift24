package org.uplift.exam3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testToString() {
        Book b1 = new Book("The Immortals of Melhua","Amish","Fiction",10,50);
        String result = b1.toString();
        assertTrue(result.contains("The Immortals of Melhua"));
        assertTrue(result.contains("Amish"));
        assertTrue((result.contains("Fiction")));
    }
}
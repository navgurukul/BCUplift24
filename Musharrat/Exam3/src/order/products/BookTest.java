package order.products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testGetProductDescription() {
        Book book = new Book(1, 500.0, "1921", "Stephen King", "Horror");
        String result = book.getProductDescription();
        assertTrue(result.contains("Book of genre"));
        assertTrue(result.contains("Horror"));
        assertTrue(result.contains("written by"));
        assertTrue(result.contains("Stephen King"));
        assertTrue(result.contains(" with title "));
        assertTrue(result.contains("1921"));
    }

    @Test
    void testGetDiscountApplied() {
        Book book = new Book(1, 500.0, "1921", "Stephen King", "Horror");
        assertEquals(50, book.getDiscountApplied());
    }
}
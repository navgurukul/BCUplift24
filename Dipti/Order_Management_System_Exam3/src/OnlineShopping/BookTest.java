package OnlineShopping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testToString() {
        Book b1= new Book("11",50.0,5,"Wings of fire","APJ abdul kalam","autobiography");
        assertTrue(b1.toString().contains("wings of fire"));
        assertTrue(b1.toString().contains("APJ abdul kalam"));
        assertTrue(b1.toString().contains("autobiography"));
        assertTrue(b1.toString().contains("11"));
    }
}
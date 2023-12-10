package org.exam3;

import org.junit.jupiter.api.BeforeEach;


import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @BeforeEach
    void setup(){

        Book book = new Book("SELFCARE", "Ramh", "The 5am club", 55);
    }


}
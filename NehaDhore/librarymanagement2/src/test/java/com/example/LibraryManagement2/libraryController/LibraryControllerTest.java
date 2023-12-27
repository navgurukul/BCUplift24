package com.example.LibraryManagement2.libraryController;

import com.example.LibraryManagement2.book.Book;
import com.example.LibraryManagement2.libraryRepository.LibraryRepository;
import com.example.LibraryManagement2.libraryService.LibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class LibraryControllerTest {
    @Autowired
    private TestRestTemplate trt;

    @MockBean
    LibraryRepository lr;

    @MockBean
    private LibraryService ls;
    @Mock
    private Book b;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testdirectAddMap() {
        Map<Book, Integer> bookIntegerMap = new HashMap<>();
        bookIntegerMap.put(b, 5);
        when(ls.getMap()).thenReturn(bookIntegerMap);
        ResponseEntity<Map> result = trt.getForEntity("/book", Map.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());

    }

    @Test
    void testGetBookFromId() {
        when(ls.findById("1")).thenReturn(b);
        ResponseEntity<String> result = trt.getForEntity("/book/1", String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void PostaddBook() {
        Book b = new Book("1", "agnipankh", "abdul kalam");
        int q = 5;
        when(ls.addBooks(b, q)).thenReturn(true);
        HttpEntity<Book> request = new HttpEntity<>(b);

        ResponseEntity<Boolean> result = trt.postForEntity("/book/5", request, Boolean.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertTrue(result.getBody());

    }





    @Test
    void testDeleteBorrowBook(){                                    //for delete and put we use exchange
        Book book1 = new Book("1", "agnipankh", "abdul kalam");

        when(ls.BorrowBook(book1,5)).thenReturn(true);
        HttpEntity<Book> request = new HttpEntity<>(book1);

        ResponseEntity<Boolean> result = trt.exchange("/book/5", HttpMethod.DELETE,request, Boolean.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());

    }

    @Test
    void testPutReturnBook(){
        Book book1 = new Book("1", "agnipankh", "abdul kalam");
        int q=5;
        when(ls.returnBook(book1,5)).thenReturn(true);
        HttpEntity<Book> request = new HttpEntity<>(book1);

        ResponseEntity<Boolean> result = trt.exchange("/book/5", HttpMethod.PUT,request, Boolean.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertTrue(result.getBody());

    }
}

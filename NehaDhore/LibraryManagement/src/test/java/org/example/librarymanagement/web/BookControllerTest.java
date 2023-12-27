package org.example.librarymanagement.web;

import org.example.librarymanagement.book.Book;
import org.example.librarymanagement.repository.BookRepository;
import org.example.librarymanagement.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Nested
@SpringBootTest(webEnvironment = RANDOM_PORT)
class BookControllerTest {
    //    @Autowired
//    private MockMvc mvc;
    @Autowired
    private TestRestTemplate trt;

    @Mock
    private Book b;
    @MockBean
    private BookService bs;
//    @Mock
//    private BookRepository br;
////    @MockBean
//    private BookController bc;

//    static BookControllerTest
//    createBookControllerTest(bs.addBook(c) {
//        return new BookControllerTest();
//    }

    //    private Book b = new Book("1","Anna Karenina","Fiction","Thomas gray");
    @BeforeEach
    void init_Mock() {
        MockitoAnnotations.openMocks(this);
    }

//@Test
//    void test(){
//    assertEquals(true,bc.test().contains("&"));
//}

    @Test
    void addBook() {

        Book c = new Book("1", "Anna Karenina", "Fiction", "Thomas gray");
        when(bs.addBook(c)).thenReturn(true);
        HttpEntity<Book> request = new HttpEntity<>(c);
        ResponseEntity<Boolean> result = trt.postForEntity("/Books", request, Boolean.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void postException() {
        Book c = new Book("1", "Anna Karenina", "Fiction", "Thomas gray");
        when(bs.addBook(c)).thenReturn(false);
        HttpEntity<Book> request = new HttpEntity<>(c);
        ResponseEntity<Boolean> result = trt.postForEntity("/Books", request, Boolean.class);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }


    @Test
    void findBook() {
        when(bs.findBook("2")).thenReturn(b);
        when(b.getId()).thenReturn("2");
        ResponseEntity<Book> result = trt.getForEntity("/Books/2", Book.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("2", result.getBody().getId());
        ;
    }

    @Test
    void findBookException() {
        when(bs.findBook("2")).thenReturn(null);
        ResponseEntity<Book> result = trt.getForEntity("/Book/2", Book.class);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());

    }

    @Test
    void updateBook() {
        Book c = new Book("1", "Anna Karenina", "Fiction", "Thomas gray");
        when(bs.updateBook(c)).thenReturn(true);
        HttpEntity<Book> request = new HttpEntity<>(c);
        ResponseEntity<Boolean> result = trt.exchange("/Books", HttpMethod.PUT, request, Boolean.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
//        assertTrue(bs.addBook(b));

    }

//    @Test
//    void updateBookException() {
//
//        Book c = new Book("1", "Anna Karenina", "Fiction", "Thomas gray");
//        when(bs.updateBook(c)).thenReturn(true);
//        HttpEntity<Book> request = new HttpEntity<>(c);
//        ResponseEntity<Boolean> result = trt.exchange("/Books", HttpMethod.PUT, request, Boolean.class);
//        assertEquals(HttpStatus.OK, result.getStatusCode());
////        assertEquals();

    @Test
    void deleteBook(){
        Book c = new Book("1", "Anna Karenina", "Fiction", "Thomas gray");

        when(bs.deleteBook(c)).thenReturn(true);
        HttpEntity<Book> request = new HttpEntity<>(c);
        ResponseEntity<Boolean> result = trt.exchange("/Books",HttpMethod.DELETE,request,Boolean.class);
        assertEquals(HttpStatus.OK,result.getStatusCode());
        assertEquals(null,bs.findBook(c.getId()));

    }


}
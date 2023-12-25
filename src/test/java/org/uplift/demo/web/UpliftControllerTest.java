package org.uplift.demo.web;

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
import org.uplift.demo.web.Repositery.LaptopRepository;
import org.uplift.demo.web.laptop.Laptop;
import org.uplift.demo.web.service.StudentService;
import org.uplift.demo.web.student.Student;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import static javafx.beans.binding.Bindings.when;
import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment=RANDOM_PORT)
class UpliftControllerTest {
    @MockBean
    StudentService studentService;
    @Mock
    Student student;
    @Mock
    LaptopRepository laptopRepository;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    void index(){
        ResponseEntity<String> result = testRestTemplate.getForEntity("/", String.class);
        assertTrue(result.getBody().contains("Welcome"));
        assertNotNull(result.getBody());
    }
    @Test
    void getStudent(){
        when(studentService.findStudent("5")).thenReturn(null);
        ResponseEntity<String> result = testRestTemplate.getForEntity("/students?id=5", String.class);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

    @Test
    void getStudentThrowError(){
        when(studentService.findStudent("5")).thenReturn(null);
        ResponseEntity<String> result = testRestTemplate.getForEntity("/students?id=5", String.class);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }
    @Test
    public void listOfStudent(){
        List<Student>s1=new ArrayList<>();
        s1.add(student);
        when (studentService.getAllStudents()).thenReturn(s1);
        ResponseEntity<ArrayList> result = testRestTemplate.getForEntity("/studentsall", ArrayList.class);
        assertEquals(s1.size(),result.getBody().size());
        assertEquals(HttpStatus.OK, result.getStatusCode());

    }

    @Test
    void postStudent(){
        Student s =new Student("Sonam","101","sonamku8130@gmail.com","8291419812",
                new Laptop("Lanavo","1001",9));
        when(studentService.addStudent(s)).thenReturn(true);
        HttpEntity<Student> request=new HttpEntity<>(s);
        ResponseEntity<String> result = testRestTemplate.postForEntity("/student",request, String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(s.getName(),result.getBody());
    }
    @Test
    void postStudentthrowError(){
        when(studentService.addStudent(student)).thenReturn(false);
        HttpEntity<Student> request=new HttpEntity<>(student);
        ResponseEntity<String> result = testRestTemplate.postForEntity("/student",request, String.class);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());

    }

    @Test
    void putStudents(){
        Student s =new Student("Sonam","101","sonamku8130@gmail.com","8291419812",
                new Laptop("Lanavo","1001",9));
        when(studentService.update(s)).thenReturn(true);
        HttpEntity<Student> request=new HttpEntity<>(s);
        ResponseEntity<Student> result = testRestTemplate.exchange("/student", HttpMethod.PUT,request, Student.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(s,result.getBody());

    }
    @Test
    void putStudentsThrowError(){
        when(studentService.update(student)).thenReturn(false);
        HttpEntity<Student> request=new HttpEntity<>(student);
        ResponseEntity<Student> result = testRestTemplate.exchange("/student", HttpMethod.PUT,request, Student.class);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());


    }
    @Test
    void deleteStudent(){
        when(studentService.removeStudentById("5")).thenReturn(true);
        ResponseEntity<String> result = testRestTemplate.exchange("/student/5", HttpMethod.DELETE,HttpEntity.EMPTY,String.class);
        assertEquals(HttpStatus.OK, ((ResponseEntity<String>)result).getStatusCode());
        assertEquals("Removed",result.getBody());
    }
    @Test
    void deleteStudentwithError(){
        when(studentService.removeStudentById("5")).thenReturn(false);
        ResponseEntity<String> result = testRestTemplate.exchange("/student/5", HttpMethod.DELETE,HttpEntity.EMPTY,String.class);
        assertEquals(HttpStatus.NOT_FOUND, ((ResponseEntity<String>)result).getStatusCode());

    }






}
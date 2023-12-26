package org.uplift.demo;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.uplift.demo.Repository.LaptopRepository;
import org.uplift.demo.laptop.Laptop;
import org.uplift.demo.services.LaptopService;
import org.uplift.demo.services.StudentService;
import org.uplift.demo.student.Student;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)

//class UpliftControllerTest {
//    @Autowired
//    private TestRestTemplate trt;
////    @BeforeEach
////    void setUp(){
////
////    }
//@MockBean
//private StudentService ss;
//@Mock
//private Student s ;
//@MockBean
//private LaptopService ls;
////@InjectMocks
////private StudentService svs;
//
//    @Test
//    void index() {
//        ResponseEntity<String> result = trt.getForEntity("/", String.class);
//        assertTrue(result.getBody().contains("Welcome"));
//    }
//
//    @Test
//    void getLaptop() {
//        ResponseEntity<String> result = trt.getForEntity("/laptops", String.class);
//        assertTrue(result.getBody().contains("we"));
//
//    }
//
//    @Test
//    void getLaptopByQuery() {
////        String id = "123";
////        String owner = "Neha";
////        Laptop l = new Laptop(id,owner,"123","Dell","core i-5");
//////        assertEquals(l.getId().equals(id));
////        assertEquals(id.equals(l.getId()), true);
//
////        ResponseEntity<Student> result = trt.getForEntity("laptops", Student.class);
////        assertTrue(result.getBody().equals());
////
//
//
//    }
//
//
//    @Test
//    void getStudentByQuery() {
//        when(ss.findStudent("123")).thenReturn(s);
//        ResponseEntity<Student> result = trt.getForEntity("/studentlist/123",Student.class);
//        assertEquals(HttpStatus.OK,result.getStatusCode());
//    }
//
//
//
////    @Test
////    void getLaptopDetails() {
////        ResponseEntity<String> result = trt.getForEntity("/laptops/12", String.class);
////        Laptop l = new Laptop("12","Neha","122","Dell","i-5");
////        assertEquals(HttpStatus.OK,result.getStatusCode()) ;
////
////    }
//
//    @Test
//    void poststudent() {
//    }
//
//    @Test
//    void getStudentDetails() {
//        List<Student> l1 = new ArrayList<>();
//        l1.add(s);
//        when(ss.getStudentList()).thenReturn(l1);
//        ResponseEntity<String> result = trt.getForEntity("/studentlist", String.class);
//        assertEquals(l1.size(),result.getBody().length());
//        assertEquals(HttpStatus.OK, result.getStatusCode());
//
//
//    }
//    @Test
//    void postStudent(){
////        when(ss.addStudent(s)).thenReturn(true);
////        when(s.getId()).thenReturn("123");
//        Student student = new Student("abc","Neha","email@","1234567");
//        when(ss.updateStudent(student)).thenReturn(true);
//        HttpEntity<Student>  request = new HttpEntity<>(student);
//        ResponseEntity<String> result = trt.postForEntity("/student",request, String.class);
//        assertEquals(HttpStatus.OK,result.getStatusCode());
////        assertEquals("abc",result.getBody());
//        assertTrue(result.getBody().contains("abc"));
//
//    }
//
//    @Test
//    void updateStudent() {
//        Student student = new Student("abc","Neha","email@","1234567");
//        when(ss.updateStudent(student)).thenReturn(true);
//
//
//    }
//    @Test
//    void getLaptopDetails(){
//        Laptop l = new Laptop("19","Neha","123","Hp","i-10");
////        when(ls.addLaptop(l)).thenReturn(true);
//        when(ls.addLaptop(l));return;
//        HttpEntity<Laptop> request;
//        request = new HttpEntity<>();
//        ResponseEntity <Boolean> result = trt.postForEntity("/laptoplist",request,Boolean.class);
//        assertEquals(HttpStatus.OK,result.getStatusCode());
//        assertEquals("19",result.getBody());
////        assertTrue(result.getBody().contains(l.getId()));
//
//    }
//
//
//    @Test
//    void putStudent(){
////        when(ss.addStudent(s)).thenReturn(true);
////        when(s.getId()).thenReturn("123");
//        Student student = new Student("abc","Neha","email@","1234567");
//        when(ss.updateStudent(student)).thenReturn(true);
//        HttpEntity<Student> request = new HttpEntity<>(student);
//        ResponseEntity<Boolean> result = trt.exchange("/Student", HttpMethod.PUT,request, Boolean.class);
//        assertEquals(HttpStatus.OK,result.getStatusCode());
//      assertTrue(result.getBody());
//    }
//

//////////////////////////////////--------------------///////////////////////////////////////

//@RestController
//@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class UpliftController {

    @Autowired
    private StudentService ss;

    @Autowired
    private LaptopRepository lr;

    @Autowired
    private ApplicationContext context;


    @GetMapping("/")
    public String index() {
        System.out.println(ss);
        return "Welcome again to uplift";
    }



    @PostMapping("/student")
    public ResponseEntity<String> createStudent(@RequestBody Student s) {
        System.out.println(ss);
        boolean result = ss.addStudents(s);
        if(!result) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(s.getId());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudents(@PathVariable String id) {
        System.out.println(ss);
        Student s = ss.findById(id);
        if (s == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(s);
        }
    }

    @PutMapping("/student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student s) {
        boolean updateds = ss.update(s);
        if (updateds) return ResponseEntity.ok(s);
        return ResponseEntity.notFound().build();

    }


    @DeleteMapping("/student/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable String id) {
        boolean result = ss.removeStudentById(id);
        if (!result) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(true);
    }

    @GetMapping("/studentlist")
    public ResponseEntity<List<Student>> getStudentList(){
        System.out.println(this);
        System.out.println(context.getBean(UpliftController.class));
        System.out.println(context.getBean(UpliftController.class));

        ///List<Student> students = Arrays.asList(new Student("1","Janu","email@email","1222",new Laptop("12","232","Dell")));
        return ResponseEntity.ok(ss.getStudentList());
    }

    @PostMapping("/laptop")
    public ResponseEntity<Laptop> createLaptop(@RequestBody Laptop laptop ){
        boolean result = ss.addLaptops(laptop);
        if(!result) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(laptop);
    }

    @PostMapping ("/StudentArray")
    public ResponseEntity<List<Student>> displayStudentList(){
        System.out.println(ss);
        return ResponseEntity.ok(ss.getStudentList());
    }





}

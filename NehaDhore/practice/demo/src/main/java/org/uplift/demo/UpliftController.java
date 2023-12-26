package org.uplift.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
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

//    @RestController
//    public class UpliftController {
//        @Autowired
//        private StudentService ss;
//        @Autowired
//        private LaptopService ls;
//        public String i = "Software Engineering";
//        //    public String name = "Neha";
//        @GetMapping("/")
//        public String index(Student s){
//            System.out.println(ss);
////            return s;
//
//            return "Welcome to uplift!.....again";
//        }
////        @GetMapping("/students")
////        public String getStudents(){
////            return "we are students of uplift!.....";
////        }
//        //    @GetMapping("/students/{id}")
////    public ResponseEntity<Student> getStudentDetails(@PathVariable String id){
//////        return " Hello....I am "+id;
////        Student s = new Student(id,"neha","neha@123","234569876");
////        return ResponseEntity.ok(s);
////    }
//        @GetMapping("/laptops")
//        public String getLaptop(){
//            return "we are laptops of uplift.......!";
//        }
//        @GetMapping("/laptop")
//        public ResponseEntity<Laptop> getLaptopByQuery(@RequestParam String id,@RequestParam String owner){
//            Laptop l = new Laptop(id,owner,"123","Dell","core i-5");
//
//            if (id == "123") {
////            return new ResponseEntity<>(resource, HttpStatus.OK);
//                return ResponseEntity.ok(l);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        }
//        @GetMapping("/student")
//        public ResponseEntity<Student> getStudentByQuery(@RequestParam String id){
//            ArrayList<Laptop> list = new ArrayList<>();
//            Laptop l1= new Laptop(id,"Neha","123","Dell","i-3");
//            Laptop l2 = new Laptop(id,"Nisha","193","ThinkPad","i-5");
//            Laptop l3 = new Laptop(id,"Alka","1239","HP","i-7");
//            list.add(l1);
//            list.add(l2);
//            list.add(l3);
//            Student s = new Student(id,"neha","neha@123","234569876"/*,list*/);
//            return ResponseEntity.ok(s);
//        }
////        @GetMapping("/laptops/{id}")
////        public String getLaptopDetails(@PathVariable String id){
////            return "I am Laptop of Brand : "+id;
////        }
//        //    @GetMapping("/laptops/{id}/{name}")
////        public String details(@PathVariable String id,@PathVariable  String name){
////        return "I am a Student of class: "+i+" and my name is "+name+" \n"+"My laptop brand is: "+id;
////    }
////        @PostMapping("student/{id}")
////        public String createStudent(@PathVariable String id){
////            return "Student "+id+" Created";
////        }
//
////        @PutMapping("studentUpdate/{id}")
////        public String updateStudent(@PathVariable String id){
////            return "Student "+id+" Updated";
////        }
////        @DeleteMapping("studentDelete/{id}")
////        public String deleteStudent(@PathVariable String id){
////            return "Student "+id+" deleted....!";
////        }
//
////        @PostMapping("student/{id}")
////        public String createStudentjson(@PathVariable String id){
////            return "Student "+id+" Created";
////        }
//        @Autowired
//        private StudentService std;
//        @PostMapping("/student")
//        public ResponseEntity<Student> poststudent(@RequestBody Student s){
//            boolean result = std.updateStudent(s);
//            if(!result)ResponseEntity.notFound().build();
//            return ResponseEntity.ok(s);
//        }
//
//        @GetMapping("/studentlist/{id}")
//       public ResponseEntity<Student> getStudentDetails(@PathVariable String id){
//            Student s = ss.findStudent(id);
//            if (s == null) ResponseEntity.notFound().build();
//            return ResponseEntity.ok(s);
//        }
//
//        //you've missed few methods
//
//        @PutMapping("/Student")
//        public ResponseEntity<Boolean> updateStudent(@RequestBody Student s){
//            boolean result = ss.updateStudent(s);
//            if(!result) return ResponseEntity.notFound().build();
//            return ResponseEntity.ok(result);
//
//
//        }
//        @GetMapping("/laptoplist/{id}")
//        public boolean getLaptopDetails(@PathVariable String id){
//            Laptop s = ls.findLaptop(id);
//            if (s == null) ResponseEntity.notFound().build();
////            return ResponseEntity.ok(s);
//            return true;
//        }
//
//
//
//
//
//}


///////////////////////------------------------------------///////////////////////////////


@RestController
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
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

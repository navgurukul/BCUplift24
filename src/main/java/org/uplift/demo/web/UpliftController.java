package org.uplift.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uplift.demo.web.laptop.Laptop;
import org.uplift.demo.web.student.Student;
import org.uplift.demo.web.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UpliftController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")  //get http request, it will call automatically
    public String index(){
        System.out.println(studentService);
        return "Welcome again to uplift";
    }

    @PostMapping("/student")
    public ResponseEntity<String> addStudents(@RequestBody Student st){
        boolean b = studentService.addStudent(st);
        if (b){
            return ResponseEntity.ok(st.getName());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/students")
    public ResponseEntity<Student>getStudentsByName(@RequestParam String id){
        if (studentService.findStudent(id)!=null){
            System.out.println(studentService);
            return ResponseEntity.ok(studentService.findStudent(id));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/laptop")
    public ResponseEntity<Laptop>getLaptopById(@RequestParam String id){
        if (studentService.findLaptop(id)!=null){
            return ResponseEntity.ok(studentService.findLaptop(id));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable String id){
        boolean result = studentService.removeStudentById(id);
        if (result){
            return ResponseEntity.ok("Removed");
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping("/student")
    public ResponseEntity<Student> putStudent(@RequestBody Student student){
        boolean result = studentService.update(student);
        if (result){
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/studentsall")
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

//    @GetMapping("/students/{id}")
//    public ResponseEntity<Student> getStudentData(@PathVariable String id){
//        Student s = new Student("abc", id, "abc@gmail.com", "8765321450");
//        return ResponseEntity.ok(s);  //It is used to convert the objects in json file.
//    }
//
//    @GetMapping("/students")
//    public ResponseEntity<Student> getStudentByQuery(@RequestParam String id){
//        Student s = new Student("abc", id, "abc@gmail.com", "8765321450");
//        return ResponseEntity.ok(s);  //It is used to convert the objects in json file.
//    }

//    @GetMapping("/laptop/{name}/{serialNumber}")
//    public ResponseEntity<Laptop> getLaptopData(@PathVariable String name, @PathVariable String serialNumber){
//        Laptop l = new Laptop(name, serialNumber, 12, true);
//        return ResponseEntity.ok(l);  //It is used to convert the objects in json file.
//    }
//
//    @GetMapping("/laptop")
//    public ResponseEntity<Laptop> getLaptopByquery(@RequestParam String name, @RequestParam String serialNumber){
//        Laptop l = new Laptop(name, "id", 23, false);
//        if (l.getSerialNo().equals(serialNumber))
//            return ResponseEntity.ok(l);  //It is used to convert the objects in json file.
//        else
//            return ResponseEntity.notFound().build();
//    }
//
//    @GetMapping("/student")
//    public ResponseEntity<Student> getStudentLaptop(@RequestParam String name, @RequestParam String id){
//        Student student = new Student(name, id, "name@gmail", "6754329812", new Laptop("Dell", "DELL2342", 23, true));
//        return ResponseEntity.ok(student);
//    }

//    @GetMapping("/students")
//    public ResponseEntity<ArrayList<Student>> getStudentsArray(@RequestParam String name, @RequestParam String name1, @RequestParam String name2){
//        ArrayList<Student> students = new ArrayList<>();
//        students.add(new Student(name, "123", "name@gmail", "6754329812", new Laptop("Dell", "DELL2342", 23, true)));
//        students.add(new Student(name1, "234", "name@gmail", "6754329812", new Laptop("Dell", "DELL2342", 23, true)));
//        students.add(new Student(name2, "129", "name@gmail", "6754329812", new Laptop("Dell", "DELL2342", 23, true)));
//
//        return ResponseEntity.ok(students);
//    }

//    @PostMapping("/student")
//    public ResponseEntity<String> postStudent(@RequestBody Student student){
//        return ResponseEntity.ok(student.getName());
//    }
//
//    @DeleteMapping("/student")
//    public ResponseEntity<String> deleteStudent(@RequestBody Student student){
//        return ResponseEntity.ok("Student has benn removed");
//    }
//
//    @PutMapping("/student")
//    public ResponseEntity<String> updateStudentRecord(@RequestBody Student student){
//        return ResponseEntity.ok(student.getName()+" "+student.getId());
//    }


    //Get
//    @GetMapping("/")  //get http request, it will call automatically
//    public String index(){
//        return "Welcome again to uplift";
//    }
//
//    @GetMapping("/students")
//    public String getStudent(){
//        return "We are students of Uplift";
//    }
//
//    @GetMapping("/laptop")
//    public String getLaptop(){
//        return "I have dell laptop";
//    }
//
//    @GetMapping("/students/{id}")
//    public String getStudentDetails(@PathVariable String id){
//        return ("Hello, I am "+ id);
//    }

    //GIT FOR TWO PARAMETERS
//    @GetMapping("/students/{name}/{rollnumber}")
//    public String getStudentRollNumber(@PathVariable String name, @PathVariable String rollnumber){
//        return "I am "+ name + " and roll number is "+rollnumber;
//    }
//
//    @GetMapping("/laptop/{laptopName}/{laptopId}")
//    public String getLaptopWithId(@PathVariable String laptopName, @PathVariable int laptopId){
//        return "I have "+ laptopName +" laptop and laptop id is: "+laptopId;
//    }
//
//    @GetMapping("/students/{rollno}")
//    public int getRollNumber(@PathVariable int rollno){
//        System.out.println("Roll no: " + rollno);
//        return rollno;
//    }

    // POST

//    @PostMapping("/students/{id}")
//    public String createStudent(@PathVariable String id){
//        return "Student "+id;
//    }

    //PUT
//    @PutMapping("/students/{id}")
//    public String updateStudent(@PathVariable String id){
//        return "Student "+id;
//    }

    //DELETE

    //DEETE
//    @DeleteMapping("/students/{id}")
//    public String deleteStudent(@PathVariable String id){
//        return "Student "+id;
//    }

}


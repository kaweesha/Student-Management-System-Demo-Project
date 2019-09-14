package com.demoproject.rest;

import com.demoproject.Service.StudentService;
import com.demoproject.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    // add mapping for get /students
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/students")
    public List<Student> getStudents(@RequestParam(value="className") String className) {
        return studentService.getStudents(className);
    }
//    // add mapping for get /students
//    @CrossOrigin(origins = "http://localhost:4200")
//    @GetMapping("/students")
//    public List<Student> getStudents() {
//        return studentService.getStudents();
//    }

    // add mapping to get a single student "/students/{studentId}"
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        Student theStudent = studentService.getStudent(studentId);

        if (theStudent == null) {
            throw new StudentNotFoundException("student id not found - " + studentId);
        }

        return theStudent;
    }

    // save a student
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student theStudent) {

        theStudent.setId(0);

        studentService.saveStudent(theStudent);

        return theStudent;

    }

    // update a student
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student theStudent) {

        studentService.saveStudent(theStudent);

        return theStudent;
    }

    // delete a student
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {

        Student tempStudent = studentService.getStudent(studentId);

        if (tempStudent == null) {
            throw new StudentNotFoundException("student id not found - " + studentId);
        } else {
            studentService.deleteStudent(studentId);
            return ("Deleted student id - " + studentId);
        }

    }


}

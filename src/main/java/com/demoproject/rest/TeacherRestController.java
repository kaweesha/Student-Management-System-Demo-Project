package com.demoproject.rest;


import com.demoproject.Service.TeacherService;
import com.demoproject.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherRestController {

    @Autowired
    private TeacherService teacherService;

    // add mapping for get /teachers
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/teachers")
    public List<Teacher> getTeachers() {
        return teacherService.getTeachers();
    }

    // add mapping to get a single teacher "/teachers/{className}"
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/teachers/{className}")
    public Teacher getTeacher(@PathVariable String className) {

        Teacher theTeacher = teacherService.getTeacher(className);

        if (theTeacher == null) {
//            throw new StudentNotFoundException("student id not found - " + teacherId);
        }

        return theTeacher;
    }
}

package com.demoproject.Service;

import com.demoproject.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    void saveStudent(Student theStudent);

    Student getStudent(int studentId);

    void deleteStudent(int studentId);
}

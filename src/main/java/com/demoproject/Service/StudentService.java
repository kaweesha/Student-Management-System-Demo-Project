package com.demoproject.Service;

import com.demoproject.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    public void saveStudent(Student theStudent);

    public Student getStudent(int studentId);

    public void deleteStudent(int studentId);
}
